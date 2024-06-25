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
include(":feature:repositories:repositories-imp:domain")
include(":feature:repositories:repositories-imp:data")
include(":feature:repositories:repositories-imp:presenter")
include(":feature:repositories:repositories-api")

include(":core:database:database-imp")
include(":core:database:database-api")

include(":core:network:network-imp")
include(":core:network:network-api")

include(":feature:repository:repository-imp:domain")
include(":feature:repository:repository-imp:data")
include(":feature:repository:repository-imp:presenter")
include(":feature:repository:repository-api")
