import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    jacoco

    kotlin("jvm") version Dependencies.kotlinVersion
    kotlin("plugin.noarg") version Dependencies.kotlinVersion
    kotlin("plugin.allopen") version Dependencies.kotlinVersion

    idea
}

allprojects {
    group = "com.linecorp.kotlin-jdsl"
    version = "2.0.4.min-jakarta"

    repositories {
        mavenCentral()
        mavenLocal()
    }
}

rootProject {
    apply<JacocoExtensionPlugin>()
}

subprojects {
    apply(plugin = "jacoco")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-noarg")
    apply(plugin = "kotlin-allopen")

    val javaVersion = JavaVersion.VERSION_11
    java.sourceCompatibility = javaVersion
    java.targetCompatibility = javaVersion

    apply<LocalPropertiesPlugin>()

    dependencies {
        implementation(Dependencies.koltin)
    }

    allOpen {
        annotation("org.springframework.context.annotation.Configuration")
        annotation("jakarta.persistence.Entity")
        annotation("jakarta.persistence.Embeddable")
    }

    noArg {
        annotation("org.springframework.context.annotation.Configuration")
        annotation("jakarta.persistence.Entity")
        annotation("jakarta.persistence.Embeddable")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            showExceptions = true
            exceptionFormat = FULL
            showCauses = true
            showStackTraces = true
            events = setOf(FAILED)
        }
    }
}
