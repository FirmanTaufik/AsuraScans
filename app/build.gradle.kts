plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
  //  id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization") version "1.7.0"

}

android {
    namespace = "com.app.asurascans"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.asurascans"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlin.sourceSets.all {
         languageSettings.enableLanguageFeature("DataObjects")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.testing)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation ("org.jsoup:jsoup:1.17.2")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    implementation("androidx.navigation:navigation-compose:2.5.0")
    implementation ("androidx.activity:activity-compose:1.5.0")


    val lifecycle_version =  "2.6.1"
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
    // Saved state module for ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    // Annotation processor
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    implementation("dev.chrisbanes.haze:haze-jetpack-compose:0.4.1")
    implementation ("com.github.Kaaveh:sdp-compose:1.1.0")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.3.0")


    implementation ("androidx.compose.foundation:foundation:1.6.6")
  //  implementation ("com.scwang.wave:MultiWaveHeader:1.0.0-andx")
    implementation ("androidx.datastore:datastore-preferences:1.0.0")


    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

    // hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.44")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    //chucker
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation ("com.github.chuckerteam.chucker:library-no-op:3.5.2")
    implementation ("io.github.2307vivek:seeker:1.2.2")
    implementation (libs.accompanist.systemuicontroller)

    implementation ("androidx.paging:paging-compose:3.3.0-alpha02")
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
//    implementation  ("com.1gravity:android-colorpicker:2.2.3")
    //  implementation  ("com.larswerkman:HoloColorPicker:1.5")

    implementation("com.github.skydoves:colorpicker-compose:1.0.7")
    implementation("com.github.marlonlom:timeago:4.0.3")

    //firebase
  /*  implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.android.gms:play-services-auth")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.firebase:firebase-messaging")*/

    implementation ("com.google.accompanist:accompanist-permissions:0.35.0-alpha")

//    Serialization :
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    implementation("androidx.room:room-runtime:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")
//  implementation("androidx.room:room-coroutines:2.1.0-alpha04") // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.room:room-paging:2.5.2")
    implementation("com.google.accompanist:accompanist-pager:0.24.13-rc")

    implementation("com.github.MshariAlsayari:Request-Permission-Compose:1.2.0")

    implementation("com.github.ireward:compose-html:1.0.2")

    val nav_version = "2.8.6"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("com.github.GIGAMOLE:ComposeScrollbars:1.0.4")

}