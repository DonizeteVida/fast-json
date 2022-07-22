import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.google.devtools.ksp")
    application
}

group = "com.doni"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":fast-json-annotation"))
    ksp(project(":fast-json-compiler"))
    // https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20220320")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

sourceSets.main {
    java.srcDirs("build/generated/ksp")
}