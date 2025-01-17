import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.papermc.paperweight.userdev")
}

repositories {
    mavenCentral()
    maven("https://repo.alessiodp.com/releases/")
}

dependencies {
    paperDevBundle("1.20-R0.1-SNAPSHOT")
    compileOnly(project(":bukkit:DreamCore"))
    compileOnly(project(":bukkit:DreamCash"))
    compileOnly(project(":bukkit:DreamCorreios"))
    compileOnly(project(":bukkit:DreamCasamentos"))
    compileOnly(project(":bukkit:DreamClubes"))
    compileOnly(project(":bukkit:DreamVanish"))
    compileOnly(project(":bukkit:DreamBedrockIntegrations"))
    compileOnly(files("../../libs/mcMMO.jar"))
    compileOnly("net.luckperms:api:5.0")
    compileOnly("com.github.ChestShop-authors:ChestShop-3:3.12")
    compileOnly("net.citizensnpcs:citizens-main:2.0.30-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    reobfJar {
        // For some reason the userdev plugin is using "unspecified" as the suffix, and that's not a good name
        // So we are going to change it to "PluginName-reobf.jar"
        outputJar.set(layout.buildDirectory.file("libs/${project.name}-reobf.jar"))
    }

    // Configure reobfJar to run when invoking the build task
    build {
        dependsOn(reobfJar)
    }
}
