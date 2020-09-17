import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.4.0"

plugins {
    kotlin("jvm") version "1.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks {
    withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "14"
    }
    test {
        useJUnitPlatform()
    }
}