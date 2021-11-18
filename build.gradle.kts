buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.2.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}
