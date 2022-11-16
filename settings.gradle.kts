pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id ("com.gradle.enterprise") version "3.11.2"
}

rootProject.name = "My Application"
include ("example-app", "example-annotation", "example-processor")

gradleEnterprise {
    //server = "http://localhost:5086"
    server = "https://ge.solutions-team.gradle.com"

    buildScan {
        publishAlways()

        isUploadInBackground = System.getenv("CI") == null

        capture {
            isTaskInputFiles = true
        }

        buildCache {
            local {
                directory = File(rootDir, "build-cache")
                removeUnusedEntriesAfterDays = 30
            }
        }
    }
}
