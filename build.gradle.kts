// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //came with package
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //added with docker branch
    id("org.jetbrains.kotlin.jvm") version "2.1.20-Beta2" //Enables support for Kotlin code that targets JVM
    //if you're having trouble with docker, look up Fat Jars (https://blog.baens.net/posts/step-by-step-kotlin/)

    tasks.register<Jar>("uberJar") {
        archiveClassifier.set("uber")
        from(sourceSets.main.get().output)
        dependsOn(configurations.runtimeClasspath)
        from({
            configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
        })
    }
}