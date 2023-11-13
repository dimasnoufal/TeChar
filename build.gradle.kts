// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories{
        maven {
            setUrl("https://jitpack.io")
        }
    }
}
plugins {
    id("com.android.library") version "8.0.2" apply  false
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}