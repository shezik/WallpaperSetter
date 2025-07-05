plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.shezik.wallpapersetter"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.shezik.wallpapersetter"
        minSdk = 24
        targetSdk = 36
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    flavorDimensions += "TargetDevice"

    productFlavors {
        create("SamsungDeX") {
            dimension = "TargetDevice"
            applicationIdSuffix = ".SamsungDeX"
            versionNameSuffix = "-SamsungDeX"
            resValue("bool", "enable_samsung_dex_capabilities", "true")
        }

        create("standard") {
            dimension = "TargetDevice"
            applicationIdSuffix = ".standard"
            versionNameSuffix = "-standard"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}