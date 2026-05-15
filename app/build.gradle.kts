plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.galagidae.broadboard"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.galagidae.broadboard"
        minSdk = 26
        targetSdk = 36
        versionCode = 5
        versionName = "2.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2026.04.01")
    implementation(composeBom)
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")
    // Optional but useful for runtime:
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.savedstate:savedstate:1.2.1")    
    implementation("androidx.compose.material3:material3")
    implementation("androidx.savedstate:savedstate-ktx:1.2.1")
    implementation("androidx.core:core-ktx:1.18.0")
}