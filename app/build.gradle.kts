plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.compose.compiler)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.notesappandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notesappandroid"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    listOf(
        libs.android.core,
        libs.android.lifecycle,
        libs.compose.activity,
        platform(libs.compose.bom),
        libs.compose.ui,
        libs.compose.ui.graphics,
        libs.compose.preview,
        libs.compose.material3,
        libs.compose.nav,
        libs.room.runtime,
        libs.hilt.android,
        libs.google.devtools,
        libs.room.ktx,
        libs.androidx.hilt
    ).forEach {
        implementation(it)
    }

    annotationProcessor(libs.room.compiler)
    listOf(
        libs.room.compiler,
        libs.hilt.compiler,
        libs.androidx.hilt.compiler
    ).forEach(::kapt)

    listOf(
        libs.junit.jupiter,
        libs.junit,
    ).forEach {
        testImplementation(it)
    }

    listOf(
        libs.androidx.test.core,
        libs.androidx.espresso,
        platform(libs.compose.bom),
        libs.android.junit4,
        libs.androidx.junit
    ).forEach {
        androidTestImplementation(it)
    }

    listOf(
        libs.compose.ui.tooling,
        libs.androidx.manifest
    ).forEach {
        debugImplementation(it)
    }
}

hilt {
    enableAggregatingTask = true
    enableTransformForLocalTests = true
    enableExperimentalClasspathAggregation = true
}
