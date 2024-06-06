pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GithubRepo"
include(":app")
include(":feature:repositories-imp:domain")
include(":feature:repositories-imp:data")
include(":feature:repositories-imp:presenter")
include(":feature:repositories-api")
include(":core:database:database-imp")
include(":core:network:network-imp")
include(":core:network:network-api")
include(":core:database:database-api")
