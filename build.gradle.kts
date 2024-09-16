plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.java.dev.jna:jna-platform:5.14.0")
    implementation("net.java.dev.jna:jna:5.14.0")
}

tasks.test {
    useJUnitPlatform()
}