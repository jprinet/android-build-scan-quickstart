pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id ("com.gradle.enterprise") version "3.11.4"
}

rootProject.name = "My Application"
include ("example-app", "example-annotation", "example-processor")

gradleEnterprise {
    server = "http://localhost:5086"

    buildScan {
        publishAlways()

        isUploadInBackground = System.getenv("CI") == null

        capture {
            isTaskInputFiles = true
        }

    }
}

buildCache {
    local {
        isEnabled = true
        directory = File(rootDir, "build-cache")
        removeUnusedEntriesAfterDays = 30
    }

    remote(gradleEnterprise.buildCache) {
        isEnabled = false
        isPush = true
    }
}
