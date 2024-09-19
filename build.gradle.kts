plugins {
    id("java")
    application
    `java-library`
     id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "org.example.Main"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
}
javafx {
    version = "22.0.1"
    modules("javafx.controls", "javafx.fxml")
}