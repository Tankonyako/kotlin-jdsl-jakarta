apply<PublishPlugin>()

dependencies {
    implementation(Dependencies.javaPersistenceApi)

    api(Modules.core)

    implementation("org.hibernate.common:hibernate-commons-annotations:6.0.2.Final")
    compileOnly(Dependencies.hibernate)
    compileOnly(Dependencies.slf4j)

    testImplementation(Modules.core)
    testImplementation(Dependencies.hibernate)
    testImplementation(Dependencies.h2)
}
