plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.trackyourexpense"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trackyourexpense"
        minSdk = 27
        targetSdk = 33
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    /**
     * Navigation
     */
    // NOTE 2.4.0-alpha-07 is not working as of 8-25-2021
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0-alpha01")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0-alpha01")
    implementation ("androidx.navigation:navigation-compose:2.6.0-alpha01")
    androidTestImplementation ("androidx.navigation:navigation-testing:2.6.0-alpha01")

    /**
     * Compose Packages
     */
    implementation ("androidx.compose.ui:ui:1.5.1")
    implementation ("androidx.compose.ui:ui-tooling:1.5.1")
    implementation ("androidx.compose.compiler:compiler:1.4.4")
    implementation ("androidx.compose.foundation:foundation:1.5.1")
    implementation ("androidx.compose.animation:animation:1.5.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.1")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.26.3-beta")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.1")
    implementation ("androidx.compose.material:material:1.5.1")

    // compose image helper
    implementation ("io.coil-kt:coil-compose:1.3.2")

    /**
     * Hilt / Dagger
     */
    implementation ("com.google.dagger:hilt-android:2.48")
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.48")

    /**
     * Constraint Layouts
     */
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha04")
}