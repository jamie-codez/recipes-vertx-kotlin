import java.io.ByteArrayOutputStream

plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.recipes.api"
version = getVersionName()

fun getVersionName(): String {
    return try {
        val stdOut = ByteArrayOutputStream()
        exec {
            commandLine("git", "describe", "--tags", "--abbrev=0")
            standardOutput = stdOut
        }
        stdOut.toString().trim()
    } catch (e: Exception) {
        "0.0.1-SNAPSHOT"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}