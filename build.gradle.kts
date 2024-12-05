group = "com.github.pkolosinski"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "2.1.0"
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
