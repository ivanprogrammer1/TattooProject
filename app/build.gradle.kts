plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.1.0"
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
}

android {
    namespace = "com.tattoshaman.tattooproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tattoshaman.tattooproject"
        minSdk = 27
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(project(":features:article_detail_api"))
    implementation(project(":features:article_detail_impl"))
    implementation(project(":features:articles_api"))
    implementation(project(":features:articles_impl"))
    implementation(project(":features:catalog_api"))
    implementation(project(":features:catalog_impl"))
    implementation(project(":features:form_api"))
    implementation(project(":features:form_impl"))
    implementation(project(":features:sketch_api"))
    implementation(project(":features:sketch_impl"))
    implementation(project(":features:tattoo_detail_api"))
    implementation(project(":features:tattoo_detail_impl"))
    implementation(project(":features:thank_api"))
    implementation(project(":features:thank_impl"))

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.glide)
    implementation(libs.glide.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}