# Deliveroo Clone - KMP and Compose Multiplatform

A cross-platform food delivery application built using Kotlin Multiplatform (KMP) and Compose Multiplatform, demonstrating modern app development practices.

## 🌟 Features

- **Cross-Platform UI**: Single codebase targeting multiple platforms using Compose Multiplatform
- **Seamless Navigation**: Implemented using PreCompose for consistent navigation across platforms
- **Modern UI Components**:
  - Splash Screen
  - Home Screen with featured restaurants
  - Restaurant Menu Screen
  - Interactive restaurant cards with ratings and offers
  - Search functionality
  - Category filtering

## 📸 App Demo

Here’s a quick demonstration of the Deliveroo Clone app:

![App Demo](assets/app-demo.gif)

## 🛠 Tech Stack

- **Kotlin Multiplatform (KMP)**: Share business logic across platforms
- **Compose Multiplatform**: Cross-platform UI toolkit
- **PreCompose**: Navigation and state management
- **Material 3**: Modern Material Design components
- **Gradle**: Build system

## 📱 Supported Platforms

- Android
- iOS

## 🏗 Architecture

The project follows Clean Architecture principles with the following modules:

```
├── shared
│   ├── commonMain      # Shared Kotlin code
│   ├── androidMain     # Android-specific code
│   └── iosMain         # iOS-specific code
├── androidApp          # Android application module
└── iosApp              # iOS application module
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- JDK 11 or later
- Xcode (for iOS development)

### Building the Project

1. Clone the repository:

```bash
git clone https://github.com/shaibinc/deliveroo-demo.git
```

2. Open the project in Android Studio
3. Build and run:

- For Android: Select 'androidApp' configuration
- For iOS: Open `iosApp/iosApp.xcworkspace` in Xcode

## 📦 Dependencies

```kotlin
dependencies {
    implementation("moe.tlaster:precompose:1.5.7")  // Navigation
    implementation(compose.material3)                // Material Design 3
    implementation(compose.material)                 // Material Design Components
}
```

## 📸 Screenshots

[Add your app screenshots here]

## 🛣 Future Roadmap

- Real-time Order Tracking
- Payment Integration
- User Authentication
- Offline Support

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details

## 🙏 Acknowledgments

- Inspired by Deliveroo's UI/UX
- Built with Kotlin Multiplatform by JetBrains
- Compose Multiplatform community
