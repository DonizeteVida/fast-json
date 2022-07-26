plugins {
    kotlin("jvm")
}

group = "com.doni"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":fast-json-annotation"))

    implementation(kotlin("stdlib"))

    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.7.10-1.0.6")

    // https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20220320")
}