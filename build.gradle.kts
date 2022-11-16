buildscript {
  repositories {
    mavenLocal()
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.3.1")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    classpath("com.osacky.flank.gradle:fladle:0.17.2")
    classpath("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
    classpath("io.realm:realm-gradle-plugin:10.12.0")
  }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

allprojects {
  repositories {
    mavenLocal()
    google()
    mavenCentral()
  }
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}
