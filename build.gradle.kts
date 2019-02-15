import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    application
    id("com.google.cloud.tools.jib") version "1.0.0"
    id("com.diffplug.gradle.spotless") version "3.18.0"
}

val versionObj = Version(major = 3, minor = 0, revision = 0)

group = "com.grosslicht"
version = "$versionObj"

repositories {
    mavenCentral()
    jcenter()
}

val log4jVersion = "2.11.1"

dependencies {
    compile(kotlin("stdlib-jdk8"))

    compile("net.dv8tion:JDA:3.8.1_437") {
        exclude(module = "opus-java")
    }

    compile("org.slf4j:slf4j-api:1.7.25")
    compile("org.apache.logging.log4j:log4j-api:$log4jVersion")
    compile("org.apache.logging.log4j:log4j-core:$log4jVersion")
    compile("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    compile("io.github.microutils:kotlin-logging:1.6.22")
    compile("io.reactivex.rxjava2:rxkotlin:2.3.0")
    compile("io.reactivex.rxjava2:rxjava:2.2.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<ProcessResources>("processResources") {
    filesMatching("**/build.properties") {
        expand(project.properties)
    }
}

application {
    mainClassName = "com.grosslicht.pancake.PancakeKt"
}

val dockerImage = System.getenv("CONTAINER_NAME")

jib.to {
    image = dockerImage
    tags = setOf("latest", "${project.version}")
    auth {
        username = "pdgwien"
        password = System.getenv("DOCKER_PASSWORD")
    }
}

spotless {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        target("*.gradle.kts", "additionalScripts/*.gradle.kts")
        ktlint()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

data class Version(val major: Int, val minor: Int, val revision: Int) {
    private val buildNumber: String = System.getenv("TRAVIS_BUILD_NUMBER") ?: "dev"

    override fun toString(): String = "$major.$minor.$revision-$buildNumber"
}