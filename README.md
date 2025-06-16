# Market SDK for Android

A lightweight Android SDK that provides easy integration for marketplace functionalities (market creation, post management, category handling, etc.) via a RESTful backend.

---

## 📦 Getting started

1. **Register youre appliction :**
    - 1. Get you're uniq packge name from android studio and register on the web dashboard
    - 2. Add first market and categories data using the dashboard

2. **Add JitPack to your root `build.gradle` (project-level):**

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

3. **Add the SDK dependency in your app/module `build.gradle`:**

```gradle
dependencies {
    implementation ("com.github.Gutismall:MarketSDK:v1.0.1")
}
```

---

## 🚀 Initialize

###  **Initialize the SDK**
- inside your Appliction class add:

```kotlin
MarketSDK.initialize(getPackageName());
```
- to call the market sdk for usage use: 
```kotlin
var market = MarketSDK.getInstance()
```
---

## 🧾 Requirements

- Android API 21+
- Kotlin 1.8+
- Internet permission in `AndroidManifest.xml`

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

## 📚 Documentation

👉 Full documentation, usage guides, and API reference available at:  
[📖 View Docs](https://your-username.github.io/your-repo/)

---
