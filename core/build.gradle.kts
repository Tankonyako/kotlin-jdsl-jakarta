apply<PublishPlugin>()

dependencies {
    implementation(Dependencies.javaPersistenceApi)

    api(Modules.query)

    compileOnly(Dependencies.javaPersistenceApi)
    compileOnly(Dependencies.slf4j)
    compileOnly(Dependencies.hibernate)

    testImplementation(Modules.testFixtureCore)
    testImplementation(Modules.testFixtureEntity)
    testImplementation(Dependencies.javaPersistenceApi)
    testImplementation(Dependencies.hibernate)
    testImplementation(Dependencies.h2)
}
