@file:Suppress("unused", "SpellCheckingInspection", "MemberVisibilityCanBePrivate")

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val kotlinVersion = "1.7.0"
    const val springCoreVersion = "5.3.21"
    const val springBootVersion = "2.7.1"
    const val springDataJpaVersion = "2.7.1"
    const val coroutineVersion = "1.6.3"

    // kotlin
    const val koltin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"

    // Common
    const val javaPersistenceApi = "jakarta.persistence:jakarta.persistence-api:3.0.0"
    const val slf4j = "org.slf4j:slf4j-api:1.7.36"
    const val logback = "ch.qos.logback:logback-classic:1.2.11"
    const val hibernate = "org.hibernate.orm:hibernate-core:6.1.1.Final"
    const val eclipselink = "org.eclipse.persistence:org.eclipse.persistence.jpa:4.0.0-M3"
    const val jacksonKotlinModule = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val agroalPool = "io.agroal:agroal-pool:2.0"
    const val vertxJdbcClient = "io.vertx:vertx-jdbc-client:4.3.1"
    const val coroutineJdk8 = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutineVersion"
    const val coroutineReactor = "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutineVersion"

    // Test
    const val junit = "org.junit.jupiter:junit-jupiter:5.8.2"
    const val assertJ = "org.assertj:assertj-core:3.22.0"
    const val mockk = "io.mockk:mockk:1.12.4"

    const val h2 = "com.h2database:h2:2.1.214"

    const val mutinyVersion = "1.6.0"
    const val mutinyCore = "io.smallrye.reactive:mutiny:$mutinyVersion"
    const val mutinyKotlin = "io.smallrye.reactive:mutiny-kotlin:$mutinyVersion"
    val mutiny = listOf(mutinyCore, mutinyKotlin)
}

fun DependencyHandler.api(dependencies: List<Any>) {
    dependencies.forEach {
        add("api", it)
    }
}

fun DependencyHandler.implementation(dependencies: List<Any>) {
    dependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.compileOnly(dependencies: List<Any>) {
    dependencies.forEach {
        add("compileOnly", it)
    }
}

fun DependencyHandler.testImplementation(dependencies: List<String>) {
    dependencies.forEach {
        add("testImplementation", it)
    }
}
