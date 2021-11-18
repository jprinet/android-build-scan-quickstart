plugins {
    kotlin("jvm")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":example-annotation"))
    implementation("com.google.auto.service:auto-service:1.0-rc2")
}
