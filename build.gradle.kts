
plugins {
    idea
    java
    kotlin("jvm") version Versions.kotlin
    kotlin("kapt") version Versions.kotlin
    kotlin("plugin.allopen") version Versions.kotlin
}

version = "0.1"
group = "com.hex.shopping"

allprojects {

    apply {
        plugin<IdeaPlugin>()
        plugin<JavaPlugin>()
        plugin<JavaLibraryPlugin>()
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.apply {
            jvmTarget = "14"
            javaParameters = true
            allWarningsAsErrors = true
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
        testLogging {
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    configurations.all {
        resolutionStrategy {
            preferProjectModules()
        }
    }

}