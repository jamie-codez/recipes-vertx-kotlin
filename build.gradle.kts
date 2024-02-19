import java.io.ByteArrayOutputStream

plugins {
    application
    jacoco
    kotlin("jvm") version "1.9.22"
    id("io.vertx.vertx-plugin") version "1.4.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
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
    implementation(platform("io.vertx:vertx-core:4.5.3"))
    implementation("io.vertx:vertx-web")
    implementation("io.vertx:vertx-mongo-client")
    implementation("io.vertx:vertx-mail-client")
    implementation("io.vertx:vertx-lang-kotlin-coroutines")
    implementation("io.vertx:vertx-pg-client")
    implementation("io.vertx:vertx-health-check")
    implementation("com.auth0:java-jwt:4.2.2")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("commons-logging:commons-logging:1.2")
    implementation("com.google.firebase:firebase-admin:9.2.0")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.12"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("org.json:json:20231013")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testImplementation("io.vertx:vertx-junit5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

val mainVerticleName = "com.recipes.api.MainVerticle"
val watchForChange = "src/main/**/*"
val doChange = "${projectDir}/gradle classes -t"

vertx {
    mainVerticle = mainVerticleName
}

application {
    mainClass = "io.vertx.core.Launcher"
}

tasks.test {
    useJUnitPlatform()
}

jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        csv.required = true
        html.required = true
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
        xml.outputLocation = layout.buildDirectory.file("reports/jacoco/test/jacocoTestReport.xml")
        csv.outputLocation = layout.buildDirectory.file("reports/jacoco/test/jacocoTestReport.csv")
    }
}