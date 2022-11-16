plugins {
  id ("com.android.application")
  id ("kotlin-android")
  kotlin("kapt")
  id ("com.osacky.fladle")
  id("realm-android")
}

realm {
    isSyncEnabled = true
}

android {
  compileSdkVersion(30)

  defaultConfig {
    applicationId = "com.example.com.example.myapplication"
    minSdkVersion(16)
    targetSdkVersion(30)
    multiDexEnabled = true

    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
    options.jvmTarget = "1.8"
  }
}

dependencies {

  implementation(kotlin("stdlib"))
  implementation(project(":example-processor"))
  implementation(project(":example-annotation"))
  kapt(project(":example-processor"))

  implementation("androidx.multidex:multidex:2.0.1")

  implementation("androidx.annotation:annotation:1.0.2")
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
  implementation("androidx.core:core-ktx:1.3.1")
  implementation("androidx.appcompat:appcompat:1.2.0")
  implementation("com.google.android.material:material:1.2.1")
  implementation("androidx.constraintlayout:constraintlayout:2.0.1")
  testImplementation("junit:junit:4.+")
  androidTestImplementation("androidx.test.ext:junit:1.1.2")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
