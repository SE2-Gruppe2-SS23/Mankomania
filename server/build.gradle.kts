plugins {
    id("java")
}

group = "org.example"
version = "unspecified"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(libs.vavr)
}

tasks.test {
    useJUnitPlatform()
}