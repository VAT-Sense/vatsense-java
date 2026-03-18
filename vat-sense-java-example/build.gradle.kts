plugins {
    id("vat-sense.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":vat-sense-java-core"))
    implementation(project(":vat-sense-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :vat-sense-java-example:run` to run `Main`
    // Use `./gradlew :vat-sense-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.vat_sense.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
