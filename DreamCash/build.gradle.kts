import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(files("../libs/paper_server.jar"))
    compile(files("../libs/DreamCore-shadow.jar"))
    compile("net.luckperms:api:5.0")
    compile(project(":DreamClubes"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
