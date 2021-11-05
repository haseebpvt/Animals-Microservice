val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("com.google.cloud.tools.appengine") version "2.4.2"
}

group = "com.example"
version = "0.0.1"
application {
    1
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

appengine {
    stage {

        val jar = "build/libs/${project.name}-${project.version}-all.jar"
        setArtifact(jar)
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // jsoup
    implementation("org.jsoup:jsoup:1.14.3")
}