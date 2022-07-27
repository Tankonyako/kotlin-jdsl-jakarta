import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

data class Module(
    val name: String
)

@Suppress("unused")
object Modules {
    val core = module(":kotlin-jdsl-core")
    val reactiveCore = module(":kotlin-jdsl-reactive-core")
    val hibernate = module(":hibernate-kotlin-jdsl")
    val eclipselink = module(":eclipselink-kotlin-jdsl")
    val query = module(":kotlin-jdsl-query")

    val testFixtureCore = module(":test-fixture-core")
    val testFixtureEntity = module(":test-fixture-entity")
    val testFixtureIntegrationReactive = module(":test-fixture-integration-reactive")

    private fun module(name: String): Module = Module(name)
}

fun DependencyHandler.api(module: Module): Dependency? =
    add("api", this.project(module.name))

fun DependencyHandler.implementation(module: Module): Dependency? =
    add("implementation", this.project(module.name))

fun DependencyHandler.compileOnly(module: Module): Dependency? =
    add("compileOnly", this.project(module.name))

fun DependencyHandler.testImplementation(module: Module): Dependency? =
    add("testImplementation", this.project(module.name))
