import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.novoda.bintray-release")
}

android {
    compileSdkVersion(targetSdk)
    buildToolsVersion(buildTools)
    defaultConfig {
        minSdkVersion(minSdk)
        targetSdkVersion(targetSdk)
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("src")
        }
    }
}

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    provided(support("appcompat-v7", supportVersion))
    compile(project(":kota-support-v4"))
}

publish {
    userOrg = bintrayUser
    groupId = bintrayGroup
    artifactId = "$bintrayArtifact-appcompat-v7"
    publishVersion = bintrayPublish
    desc = bintrayDesc
    website = bintrayWeb
}
