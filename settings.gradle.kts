rootProject.name = "kotlin-jdsl"

val modules: MutableList<Module> = mutableListOf()

fun module(name: String, path: String) {
    modules.add(Module(name, "${rootDir}/${path}"))
}

data class Module(
    val name: String,
    val path: String,
)

// CORE
module(name = ":kotlin-jdsl-core", path = "core")
module(name = ":kotlin-jdsl-reactive-core", path = "reactive-core")
module(name = ":hibernate-kotlin-jdsl", path = "hibernate")
module(name = ":eclipselink-kotlin-jdsl", path = "eclipselink")
module(name = ":kotlin-jdsl-query", path = "query")

// TEST FIXTURE
module(name = ":test-fixture-core", path = "test-fixture/core")
module(name = ":test-fixture-entity", path = "test-fixture/entity")

// EXAMPLES
module(name = ":hibernate-example", path = "examples/hibernate")
module(name = ":eclipselink-example", path = "examples/eclipselink")

modules.forEach {
    include(it.name)
    project(it.name).projectDir = file(it.path)
}
