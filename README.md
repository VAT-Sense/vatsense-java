# VAT Sense Java SDK

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.vatsense/vat-sense-java)](https://central.sonatype.com/artifact/com.vatsense/vat-sense-java/0.2.0)

<!-- x-release-please-end -->

The official Java library for the [VAT Sense](https://vatsense.com) REST API. Validate VAT/EORI numbers, look up VAT/GST rates, calculate prices, convert currencies, and generate VAT-compliant invoices.

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.vatsense:vat-sense-java:0.2.0")
```

### Maven

```xml
<dependency>
    <groupId>com.vatsense</groupId>
    <artifactId>vat-sense-java</artifactId>
    <version>0.2.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Quick start

Create a client using your API key from the [VAT Sense dashboard](https://vatsense.com/dashboard). The API uses HTTP Basic Auth with `user` as the username and your API key as the password.

```java
import com.vatsense.client.VatSenseClient;
import com.vatsense.client.okhttp.VatSenseOkHttpClient;

VatSenseClient client = VatSenseOkHttpClient.builder()
    .username("user")
    .password("your_api_key")
    .build();
```

You can also set the `VAT_SENSE_USERNAME` and `VAT_SENSE_PASSWORD` environment variables and use `VatSenseOkHttpClient.fromEnv()`.

### Validate a VAT number

```java
import com.vatsense.models.validate.ValidateCheckParams;
import com.vatsense.models.validate.ValidateCheckResponse;

ValidateCheckResponse response = client.validate().check(
    ValidateCheckParams.builder().vatNumber("GB288305674").build()
);

response.data().ifPresent(data -> {
    if (data.valid().orElse(false)) {
        data.company().ifPresent(company -> {
            company.asValidationCompany().companyName().ifPresent(System.out::println);  // "BRITISH BROADCASTING CORPORATION"
            company.asValidationCompany().companyAddress().ifPresent(System.out::println);
            company.asValidationCompany().countryCode().ifPresent(System.out::println);  // "GB"
        });
    }
});
```

VAT validation works for the UK, EU, Australia, Norway, Switzerland, South Africa, and Brazil.

### Validate an EORI number

```java
ValidateCheckResponse response = client.validate().check(
    ValidateCheckParams.builder().eoriNumber("GB123456789000").build()
);
```

EORI validation is available for UK and EU numbers only.

### Get a consultation number

If you need an official consultation number from VIES (EU) or HMRC (UK), provide your own VAT number as the requester:

```java
ValidateCheckResponse response = client.validate().check(
    ValidateCheckParams.builder()
        .vatNumber("FR12345678901")
        .requesterVatNumber("FR98765432101")
        .build()
);

response.data().flatMap(d -> d.consultationNumber()).ifPresent(System.out::println);
```

> **Note:** GB requester numbers only work for GB validations, and EU requester numbers only work for EU validations. Cross-region requests are not supported.

### Find the VAT rate for a country

```java
import com.vatsense.models.rates.FindRate;
import com.vatsense.models.rates.RateFindParams;

FindRate rate = client.rates().find(
    RateFindParams.builder().countryCode("DE").build()
);

rate.data().ifPresent(data -> {
    System.out.println(data.countryName());     // Optional["Germany"]
    data.taxRate().ifPresent(taxRate -> {
        System.out.println(taxRate.rate());      // Optional[19.0]
        System.out.println(taxRate.class_());    // Optional["standard"]
    });
});
```

### Find a rate for a specific product type

```java
FindRate rate = client.rates().find(
    RateFindParams.builder().countryCode("DE").type("ebooks").build()
);
```

### Find a rate by IP address

Useful for determining the correct rate based on your customer's location:

```java
FindRate rate = client.rates().find(
    RateFindParams.builder().ipAddress("185.86.151.11").build()
);
```

### Calculate a VAT-inclusive price

```java
import com.vatsense.models.rates.RateCalculatePriceParams;
import com.vatsense.models.rates.RateCalculatePriceResponse;

RateCalculatePriceResponse result = client.rates().calculatePrice(
    RateCalculatePriceParams.builder()
        .price("100.00")
        .taxType(RateCalculatePriceParams.TaxType.EXCL)
        .countryCode("FR")
        .build()
);

result.data().ifPresent(data -> {
    data.vatPrice().ifPresent(vatPrice -> {
        System.out.println(vatPrice.priceInclVat());  // Price including VAT
        System.out.println(vatPrice.priceExclVat());  // Price excluding VAT
        System.out.println(vatPrice.vatRate());        // VAT rate applied
        System.out.println(vatPrice.vat());            // VAT amount
    });
});
```

### List all VAT rates

```java
import com.vatsense.models.rates.RateListParams;
import com.vatsense.models.rates.RateListResponse;

RateListResponse rates = client.rates().list(RateListParams.builder().build());

rates.data().ifPresent(data -> {
    for (var rate : data) {
        System.out.printf("%s: %s%n", rate.countryCode(), rate.countryName());
    }
});

// Filter to EU countries only
RateListResponse euRates = client.rates().list(
    RateListParams.builder().eu(true).build()
);
```

## Handling errors

When the API returns an error, the library throws a typed exception:

```java
import com.vatsense.errors.VatSenseServiceException;
import com.vatsense.errors.RateLimitException;

try {
    client.validate().check(
        ValidateCheckParams.builder().vatNumber("GB288305674").build()
    );
} catch (RateLimitException e) {
    // 429: Too many requests (300/min general limit, 3/sec for UK validation)
    System.out.println("Rate limited, try again shortly");
} catch (VatSenseServiceException e) {
    // Covers all other HTTP errors
    System.out.println(e.statusCode());
    System.out.println(e.getMessage());
}
```

A `412` error means the upstream validation service (VIES, HMRC, etc.) is temporarily unavailable. These requests do not count against your usage quota.

## Retries

Failed requests are automatically retried up to 2 times with exponential backoff. This includes connection errors, timeouts, 429, and 5xx responses.

```java
// Disable retries
VatSenseClient client = VatSenseOkHttpClient.builder()
    .username("user")
    .password("your_api_key")
    .maxRetries(0)
    .build();
```

## Available services

| Service                  | Description                                     |
| ------------------------ | ----------------------------------------------- |
| `client.validate()`     | Validate VAT and EORI numbers                   |
| `client.rates()`        | VAT/GST rate lookups, price calculations         |
| `client.countries()`    | Country data and province lookups                |
| `client.currency()`     | Exchange rates and currency conversion           |
| `client.invoice()`      | Create and manage VAT-compliant invoices         |
| `client.usage()`        | Check your API usage                             |

## Documentation

Full API documentation is available at [vatsense.com/documentation](https://vatsense.com/documentation).

## Requirements

Java 8 or higher.

## Versioning

This package follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions. As the library is in initial development and has a major version of `0`, APIs may change at any time.

## Contributing

See [the contributing documentation](https://github.com/VAT-Sense/vatsense-java/tree/main/CONTRIBUTING.md).
