import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

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
            connection.set("scm:git:git://github.com/VAT-Sense/vatsense-java.git")
            developerConnection.set("scm:git:git://github.com/VAT-Sense/vatsense-java.git")
            url.set("https://github.com/VAT-Sense/vatsense-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
