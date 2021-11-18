pluginManagement {
    repositories {
        mavenLocal()
    }
}
plugins {
    id ("com.gradle.enterprise") version "3.8-branch-master-prerelease"
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

        buildCache {
            local {
                directory = File(rootDir, "build-cache")
                removeUnusedEntriesAfterDays = 30
            }
        }
    }
}
