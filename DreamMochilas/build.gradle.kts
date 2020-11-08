import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(files("../libs/paper_server.jar"))
    compile(files("../libs/DreamCore-shadow.jar"))
    compile(files("../libs/NoteBlockAPI.jar"))
    compile(files("../libs/ChestShop.jar"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
