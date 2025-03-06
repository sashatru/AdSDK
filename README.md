# AdSDK

AdSDK is a modular Android SDK designed to handle AdMob integration for **Interstitial Ads** and **Native Ads**.  
It provides a clean and scalable architecture to support multiple ad providers in the future.

## 🚀 Features
✅ Supports **AdMob Interstitial Ads**  
✅ Supports **AdMob Native Ads**  
✅ Uses **Kotlin, Coroutines, Flow** for async ad management  
✅ Built with **Jetpack Compose & MVVM** compatibility  
✅ Lightweight and modular architecture  

---

## 📥 Installation (Using JitPack)
To integrate AdSDK into your project, follow these steps:

1️⃣ Add JitPack Repository
In your **`settings.gradle.kts`**, add:

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // Required for JitPack
    }
}

2️⃣ Add AdSDK as a Dependency
In your app/build.gradle.kts, add:
dependencies {
    implementation("com.github.sashatru:AdSDK:1.0.0") // Replace with the latest version
}

3️⃣ Sync the Project
After adding the dependency, sync Gradle files.

3️⃣ Sync the Project
After adding the dependency, sync Gradle files.

## 📖 Usage Guide

1️⃣ Initialize the SDK
Call AdManager in your Application class or Activity:
val adManager = AdManager(context)

2️⃣ Load and Show Interstitial Ads
adManager.loadInterstitialAd()
// Show the ad when needed
adManager.showInterstitialAd()

3️⃣ Load Native Ads
adManager.loadNativeAd()

## 🛠 Requirements
Min SDK: 29
Target SDK: 35
Kotlin 1.9+
AndroidX & Jetpack Compose

## 🏗 Future Enhancements
🔹 Support for multiple ad providers (AppLovin, RTB, etc.)
🔹 Ad analytics tracking (impressions, clicks)
🔹 Banner and Rewarded Ads integration

## 💡 Contribution
Feel free to open issues and contribute to this project!

🔗 Created by sashatru 🚀
