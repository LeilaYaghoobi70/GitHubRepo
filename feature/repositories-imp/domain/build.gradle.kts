plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{

    //hilt
    implementation ("com.google.dagger:hilt-core:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")

}