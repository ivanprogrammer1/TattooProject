pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "TattooProject"
include(":app")
include(":features:articles_impl")
include(":features:articles_api")
include(":features:article_detail_api")
include(":features:article_detail_impl")
include(":features:catalog_impl")
include(":features:catalog_api")
include(":features:tattoo_detail_api")
include(":features:tattoo_detail_impl")
include(":features:sketch_api")
include(":features:sketch_impl")
include(":features:form_api")
include(":features:form_impl")
include(":features:thank_api")
include(":features:thank_impl")
include(":core")
include(":data")
include(":domain")
