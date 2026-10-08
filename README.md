# NewsHub

A lightweight, modern Android news aggregator application designed to provide quick and seamless access to leading global news outlets within a unified interface.

## Overview

**NewsHub** simplifies how users consume news from top international and regional publishers. Instead of jumping between standalone web browsers or heavy third-party applications, NewsHub consolidates real-time feeds from major news channels—including **Al Jazeera**, **ARY News**, **BBC News**, **CNN**, and **The New York Times**—into a single, organized mobile experience.

### Primary Purpose & Audience
- **Purpose**: Deliver a centralized, distraction-free reading experience for breaking news, global reporting, and opinion blogs across major platforms.
- **Target Audience**: News enthusiasts, professionals, and daily readers who want convenient access to world news sources directly on their Android devices.

---

## Features

- **Multi-Source News Feeds**: Swiftly switch between top news publishers via a side navigation drawer:
  - **Al Jazeera**: Global news and in-depth reporting.
  - **ARY News**: Latest blogs, national, and regional coverage.
  - **BBC News**: World news updates and analysis.
  - **CNN**: Breaking news and international coverage.
  - **The New York Times**: Deep-dive international journalism.
- **In-App Web Navigation**: Built-in custom `WebViewClient` (`WebViewController`) ensures all internal article links and sub-pages load inside the application without redirecting to external web browsers.
- **Interactive Navigation Drawer**: Slide-out menu powered by `DrawerLayout` and `NavigationView` for fluid category and channel switching.
- **Edge-to-Edge Experience**: Enabled via `EdgeToEdge.enable()` for a modern, immersive full-screen display.
- **Custom Branding & Typography**: Custom navigation header featuring specialized styling and custom preloaded fonts (`Akaya Kanadaka`).
- **Material 3 Foundation**: Built on Material Design 3 guidelines for consistent UI components.

---

## Tech Stack

| Component / Library | Purpose |
|---------------------|---------|
| **Java 11** | Primary programming language |
| **Android SDK (API 24 – 36)** | Platform APIs (`compileSdk 36`, `minSdk 24`) |
| **Material Components (`com.google.android.material:material`)** | Navigation Drawer, AppBar, and Material UI components |
| **AndroidX AppCompat (`androidx.appcompat:appcompat`)** | Backward-compatible action bar and app activity support |
| **AndroidX Fragment (`androidx.fragment:fragment`)** | Fragment lifecycle management and transactions |
| **AndroidX ConstraintLayout (`androidx.constraintlayout:constraintlayout`)** | Adaptive UI layouts |
| **Android WebKit (`android.webkit.WebView`)** | Embedded browser engine for loading web news feeds |
| **Firebase Realtime Database (`com.google.firebase:firebase-database`)** | Backend services integration |
| **Gradle Version Catalog (`libs.versions.toml`)** | Modern, centralized dependency management |

---

## Architecture

NewsHub uses a **Single-Activity Architecture** leveraging Android Fragments and a Navigation Drawer layout pattern.

```text
                           +------------------------+
                           |      MainActivity      |
                           | (DrawerLayout/Toolbar) |
                           +-----------+------------+
                                       |
                   +-------------------+-------------------+
                   | Nav Item Selected |                   |
                   v                   v                   v
        +-------------------+ +-----------------+ +-------------------+
        | AlJazeeraFragment | |   BBCFragment   | |    CNNFragment    | ... (ARY, NYT)
        +---------+---------+ +--------+--------+ +---------+---------+
                  |                    |                    |
                  +--------------------+--------------------+
                                       |
                                       v
                             +------------------+
                             |   WebView UI     |
                             +--------+---------+
                                      |
                                      v
                             +------------------+
                             | WebViewController|
                             | (WebViewClient)  |
                             +------------------+
```

### Key Components & Responsibilities

1. **`MainActivity`**:
   - Serves as the single activity container for the app.
   - Manages the `DrawerLayout`, `Toolbar`, and `NavigationView` setup.
   - Handles menu selection events and performs `FragmentTransaction` replacements in `fragmentContainer`.
   - Manages back-stack interaction (`onBackPressed`) to close the navigation drawer when open.

2. **News Fragments (`AlJazeeraFragment`, `ARYFragment`, `BBCFragment`, `CNNFragment`, `NewYorkTimes_Fragment`)**:
   - Each fragment represents a distinct news provider.
   - Responsible for inflating its layout, binding the `WebView`, attaching `WebViewController`, and loading the target URL.

3. **In-App Browser Client (`WebViewController`)**:
   - Implements a custom `WebViewClient`.
   - Overrides `shouldOverrideUrlLoading` to load clicked hyperlinks directly inside the `WebView` instance, preventing external browser launches.

---

## Project Structure

```text
NewsHub/
├── app/
│   ├── build.gradle
│   ├── google-services.json
│   ├── proguard-rules.pro
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/
│       │   │   └── com/example/newshub/
│       │   │       ├── MainActivity.java
│       │   │       ├── WebViewController.java
│       │   │       └── fragments/
│       │   │           ├── AlJazeeraFragment.java
│       │   │           ├── ARYFragment.java
│       │   │           ├── BBCFragment.java
│       │   │           ├── CNNFragment.java
│       │   │           └── NewYorkTimes_Fragment.java
│       │   └── res/
│       │       ├── drawable/
│       │       ├── font/
│       │       │   └── akaya_kanadaka.xml
│       │       ├── layout/
│       │       │   ├── activity_main.xml
│       │       │   ├── app_bar_main.xml
│       │       │   ├── content_main.xml
│       │       │   ├── drawer_header_layout.xml
│       │       │   ├── fragment_aljazera.xml
│       │       │   ├── fragment_ary.xml
│       │       │   ├── fragment_bbc.xml
│       │       │   ├── fragment_cnn.xml
│       │       │   └── fragment_new_york_times.xml
│       │       ├── menu/
│       │       │   └── drawer_menu.xml
│       │       ├── values/
│       │       │   ├── colors.xml
│       │       │   ├── strings.xml
│       │       │   └── themes.xml
│       │       └── xml/
│       │           ├── backup_rules.xml
│       │           └── data_extraction_rules.xml
│       ├── test/
│       │   └── java/com/example/newshub/
│       │       └── ExampleUnitTest.java
│       └── androidTest/
│           └── java/com/example/newshub/
│               └── ExampleInstrumentedTest.java
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md
```

---

## Prerequisites & Getting Started

### Prerequisites

- **Android Studio**: Android Studio Ladybug (2024.2.1) or higher.
- **JDK**: Java Development Kit 11.
- **Android SDK**: API level 36 (`minSdk 24`, targeting API 36).

### Building & Running

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/usmana6072/NewsHub.git
   cd NewsHub
   ```

2. **Open in Android Studio**:
   - Open Android Studio and select **Open**.
   - Navigate to and select the `NewsHub` directory.

3. **Sync & Build**:
   - Allow Gradle to sync dependencies automatically.
   - Build the project using Gradle:
     ```bash
     ./gradlew assembleDebug
     ```

4. **Launch**:
   - Connect an Android device or start an emulator running Android 7.0 (API level 24) or higher.
   - Press **Run** (`Shift + F10`) in Android Studio.

---

## Author & Acknowledgments

- **Developer**: [M. Usman Ali](https://github.com/usmana6072) *(Built solo)*
- **Team / Organization**: **TechTitans**

---

## License

This project is licensed under standard project terms.
