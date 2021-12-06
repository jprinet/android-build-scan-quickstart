buildscript {
  val kotlin_version by extra("1.5.31")
    repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.3")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    classpath("com.osacky.flank.gradle:fladle:0.17.2")
    classpath("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
    classpath ("com.autonomousapps:dependency-analysis-gradle-plugin:0.78.0")
    classpath ("com.github.gmazzo:gradle-buildconfig-plugin:3.0.3")
    classpath("com.github.bjoernq:unmockplugin:0.7.9")
      classpath("io.michaelrocks:paranoid-gradle-plugin:0.3.5")
      classpath("org.springframework.boot:spring-boot-gradle-plugin:2.5.6")
      classpath("com.github.ben-manes:gradle-versions-plugin:0.39.0")
      classpath( "com.trevjonez.composer:plugin:1.0.0-rc07")
      classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.17")
      classpath("com.google.gms:google-services:4.3.8")
      classpath("com.google.firebase:firebase-crashlytics-gradle:2.6.1")
  }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")
apply(plugin = "com.autonomousapps.dependency-analysis")
apply(plugin = "com.github.gmazzo.buildconfig")
apply(plugin = "de.mobilej.unmock")
apply(plugin = "org.springframework.boot")
apply(plugin = "com.github.ben-manes.versions")
apply(plugin = "com.google.gms.google-services")

plugins {
    id("org.gradle.android.cache-fix") version "2.4.4" apply false
    id( "com.google.osdetector") version "1.7.0"
    id("io.github.cdsap.talaiot.plugin.influxdb") version "1.5.1"
    id("ru.vyarus.animalsniffer") version "1.5.3"

}

subprojects {
    tasks.withType<ru.vyarus.gradle.plugin.animalsniffer.AnimalSniffer>().configureEach {
        getReports().getText().getRequired().set(true)
    }

    plugins.withType<com.android.build.gradle.api.AndroidBasePlugin>() {
        apply(plugin = "io.michaelrocks.paranoid")
        apply(plugin = "com.trevjonez.composer")
        apply(plugin = "org.gradle.android.cache-fix")
        apply(plugin = "com.google.protobuf")
    }
}
allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

//tasks.create<Delete>("clean") {
//    delete(rootProject.buildDir)
//}
