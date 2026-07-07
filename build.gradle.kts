plugins {
    kotlin("jvm") version "2.4.0"
    id("com.gradleup.shadow") version "9.5.1"
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
    maven("https://nexus.scarsz.me/content/groups/public/")

}

dependencies {
    compileOnly("org.spigotmc:spigot-api:26.1.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.github.Ynfuien:YVanish:0.1.4")
    compileOnly("com.discordsrv:discordsrv:1.30.5")
}

kotlin {
    jvmToolchain(25)
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    processResources {
        val props = mapOf("version" to version)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}
