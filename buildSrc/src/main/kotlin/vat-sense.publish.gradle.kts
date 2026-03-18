plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("VAT Sense API")
                description.set("Developer-friendly REST API for VAT/GST compliance. VAT Sense helps businesses\nselling internationally with VAT number validation, VAT/GST rate lookups,\ncurrency conversion, country data, and VAT-compliant invoicing.\n\n## Authentication\n\nAll API requests require authentication via HTTP Basic Auth:\n\n- **Username:** `user`\n- **Password:** Your API key\n\nAll requests must be made over HTTPS. Requests made over plain HTTP will fail.\n\n## Rate limits\n\n- **General:** 300 requests per minute (all endpoints)\n- **UK VAT validation:** 3 requests per second (to comply with HMRC upstream\n  limits)\n\nExceeding either limit returns a `429 Too Many Requests` response.\n\n## Base URL\n\nAll API URLs referenced in this documentation have the following base:\n\n`https://api.vatsense.com/1.0/`")
                url.set("https://vatsense.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Vat Sense")
                        email.set("support@vatsense.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/vat-sense-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/vat-sense-java.git")
                    url.set("https://github.com/stainless-sdks/vat-sense-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
    repositories {
        if (project.hasProperty("publishLocal")) {
            maven {
                name = "LocalFileSystem"
                url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
