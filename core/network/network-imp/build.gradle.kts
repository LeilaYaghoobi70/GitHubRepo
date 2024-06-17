plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3").version("3.8.4")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android") version "2.50" apply false
}

android {
    namespace = "app.google.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField(type = "String", name = "GITHUB_TOKEN", value = project.properties["GITHUB_TOKEN"].toString())
        buildConfigField(type = "String", name = "BASE_URL", value = "\"https://api.github.com/graphql\"")
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
        jvmTarget =  JavaVersion.VERSION_17.toString()
    }
    apollo {
        service("github") {
            packageName.set("app.google")
        }
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {
    //project
    project(":core:network:network-api")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation(project(":core:network:network-api"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //apollo
    implementation("com.apollographql.apollo3:apollo-runtime:3.8.4")

    //hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")


}