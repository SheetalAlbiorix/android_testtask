# ChargebackUI Android test task

A modern Android application built with Jetpack compose.

## :movie_camera: Demo

[Watch the app demo video]()
> Click the link above to see the app in action! The video showcases the complete user flow from
> service selection to subscription creation.

## :sparkles: Features

- **Service Selection**: Choose from popular subscription services (Netflix, Hulu, Spotify,
  PlayStation+, Paramount+, YouTube Music)
- **Search Functionality**: Quickly find services with real-time search
- **Subscription Categories**: Organize subscriptions by type (Subscription, Utility, Card Payment,
  Loan, Rent)
- **Flexible Frequency**: Set recurring payment schedules (Weekly, Monthly, Annually)
- **Active Status Toggle**: Enable/disable subscriptions as needed
- **Custom Date Picker**: Select subscription start dates
- **Modern UI**: Clean design with custom colors and shadows

## :building_construction: Architecture

The project follows a clean MVVM-inspired architecture with the following structure:

```
PaymentFlowTest/
├── app/                              # Main Android app module
│   ├── src/
│   │   └── main/
│   │       ├── java/com/jetpack/paymentflowtest/
│   │       │   ├── pages/             # 📄 Main app screens
│   │       │   │   ├── HomePage.kt                     # Landing screen
│   │       │   │   └── CreateSubscriptionPage.kt       # Subscription creation UI
│   │       │   │
│   │       │   ├── widgets/           # 🧩 Reusable UI components
│   │       │   │   ├── pickers/                       # Input selectors (e.g., date/service)
│   │       │   │   ├── tiles/                         # UI tile components
│   │       │   │   ├── ChooseAService.kt              # Service selector with icons
│   │       │   │   ├── CommonCheckbox.kt              # Custom checkbox UI
│   │       │   │   ├── Header.kt                      # Section header UI
│   │       │   │   └── SubscriptionServiceBottomSheet.kt # Bottom sheet for service selection
│   │       │   │
│   │       │   ├── ui/theme/         # 🎨 App theming and styling
│   │       │   │   ├── Color.kt                        # Color palette
│   │       │   │   ├── Theme.kt                        # Theme setup (Material3)
│   │       │   │   └── Type.kt                         # Typography definitions
│   │       │   │
│   │       │   ├── AppRoute.kt        # 🔀 Navigation routes
│   │       │   └── MainActivity.kt    # 🚀 App launcher activity
│   │       │
│   │       ├── res/                   # 🎨 Resources (images, layouts, XMLs)
│   │       │   ├── drawable/                           # Icons & images
│   │       │   │   ├── hulu.png
│   │       │   │   ├── netflix.png
│   │       │   │   ├── spotify.png
│   │       │   │   ├── youtube.png
│   │       │   │   └── etc...
│   │       │   ├── values/                             # Colors, strings, themes XML
│   │       │   └── xml/                                # Misc XML configs (if any)
│   │       └── AndroidManifest.xml   # 🧭 App manifest & permissions
│   │
│   ├── build.gradle.kts              # ⚙️ Module Gradle configuration
│   └── proguard-rules.pro            # 🔒 Code obfuscation rules
│
├── build.gradle.kts                  # ⚙️ Root Gradle configuration
├── gradle/                           # 🔧 Gradle wrapper files
├── settings.gradle.kts               # 🧩 Module linking configuration
└── .gitignore   
```

## :hammer_and_wrench: Technical Stack

**Language**: Kotlin  
**UI Framework**: Jetpack Compose (Material 3)  
**Android Studio Version**: Android Studio Otter | 2025.2.1  
**Gradle Plugin Version**: AGP 8.1.3+  
**Kotlin Version**: 2.0.21  
**Design Pattern**: MVVM (Model–View–ViewModel)  
**Architecture Principles**: Single-Activity architecture, unidirectional data flow, modular UI (
pages + widgets)  
**Min SDK**: 24  
**Target SDK**: 36  
**Compile SDK**: 36  
**Version Code**: 1  
**Version Name**: 1.0  
**Build System**: Gradle (KTS)  
**Navigation**: Jetpack Compose Navigation (`AppRoute.kt`)  
**Theme System**: Material 3 with custom colors and typography

## :rocket: Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd PaymentFlowTest
   ```
2. Open the project in Xcode:
   ```bash
   open PaymentFlowTest
   ```
3. Select an emulator or connected device
4. Sync the project
4. Run the project (Shift + F10)

### Project Setup

No additional dependencies or package managers are required. The project uses only native Android
frameworks.

### Code Style

- Follow Kotlin naming conventions
- Use Jetpack Compose view builders
- Keep views small and composable
- Extract magic numbers to constants
- Document complex logic
  **Built with :heart: using Jetpack Compose**