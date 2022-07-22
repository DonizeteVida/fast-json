pluginManagement {
    plugins {
        kotlin("jvm") version "1.7.10"
        id("com.google.devtools.ksp") version "1.7.10-1.0.6"
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "fast-json"

include(":fast-json-compiler")
include(":fast-json-annotation")

