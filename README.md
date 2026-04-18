# SunLife Client Tactics

A professional Android application designed for SunLife insurance advisors to analyze client rejections and discover effective recovery strategies.

## 📱 Overview

SunLife Client Tactics is a comprehensive tool that helps insurance advisors understand client objections, identify root causes, and implement tactical approaches to convert potential losses into successful outcomes. The app features 15 rejection categories with 60+ specific reasons and 240+ proven recovery suggestions.

## ✨ Key Features

- **🎯 Smart Categorization**: 15 comprehensive rejection categories covering every client objection scenario
- **📊 Detailed Analysis**: Specific reasons for each category with actionable insights
- **💡 Tactical Suggestions**: Proven recovery strategies tailored to each rejection scenario
- **🎨 Modern UI**: Material 3 design with SunLife branding for seamless navigation
- **📱 Responsive Design**: Optimized for all Android devices and screen sizes
- **🔒 Offline Functionality**: Works offline after initial setup

## 🏗️ Technical Specifications

- **Platform**: Android
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Language**: Kotlin
- **Architecture**: MVVM with View Binding
- **UI Framework**: Material Design 3
- **Build Tool**: Gradle 8.8
- **Android Gradle Plugin**: 8.2.2

## 🚀 Installation

### Prerequisites

- Android Studio Hedgehog or later
- JDK 17 or later
- Android SDK with API 34
- Android device or emulator running Android 7.0+

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SunLifeClientTactics
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Sync Project**
   - Android Studio will automatically sync the project
   - Wait for Gradle sync to complete

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Or use command line: `./gradlew installDebug`

## 📋 App Features

### Rejection Categories

The app includes 15 comprehensive rejection categories:

1. **Lack of Trust or Credibility** - Trust issues and past negative experiences
2. **Price / Affordability Concerns** - Premium cost and value perception
3. **Lack of Perceived Need** - Young, healthy, or already covered clients
4. **Poor Timing** - Financial constraints and competing priorities
5. **Information Overload / Confusion** - Too many options or complex terms
6. **Lack of Urgency** - No immediate trigger or perceived consequences
7. **Emotional Resistance** - Discomfort discussing mortality or commitments
8. **Comparison / Shopping Around** - Evaluating multiple options
9. **Product Mismatch** - Plan doesn't fit needs or budget
10. **External Influence** - Family, friends, or other advisors
11. **Negative Industry Perception** - General distrust of insurance
12. **Advisor Approach Issues** - Sales tactics or communication problems
13. **Commitment Hesitation** - Fear of long-term decisions
14. **Already Covered** - Existing policies perceived as sufficient
15. **Hidden Objections** - Vague responses masking real concerns

### How to Use

1. **Select Category**: Choose the rejection category that best matches your client's objection
2. **Identify Reason**: Select the specific reason within that category
3. **Get Suggestions**: Tap "Suggestions" to receive tactical recovery strategies
4. **Apply Strategies**: Implement the suggested approaches in your client interactions

## 🎨 UI/UX Design

### Material 3 Design System

- **Colors**: SunLife yellow (#FCBA03) primary with complementary grays
- **Typography**: Roboto font family with proper hierarchy
- **Components**: Material cards, buttons, and input fields
- **Layout**: Responsive grid system with proper spacing
- **Animations**: Smooth transitions and micro-interactions

### Key Screens

- **Main Screen**: Category and reason selection with Material cards
- **Suggestions Dialog**: Recovery strategies presented in scrollable cards
- **Navigation**: Intuitive single-screen interface

## 📁 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/sunlife/clienttactics/
│   │   │   ├── ui/
│   │   │   │   └── MainActivity.kt
│   │   │   └── util/
│   │   │       └── RejectionDataLoader.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   └── dialog_suggestions.xml
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   └── drawable/
│   │   └── AndroidManifest.xml
│   └── test/
├── build.gradle
├── gradle.properties
└── README.md
```

## 🔧 Dependencies

### Core Dependencies

```gradle
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.activity:activity-ktx:1.8.2'
implementation 'androidx.fragment:fragment-ktx:1.6.2'
implementation 'com.google.code.gson:gson:2.10.1'
```

### Build Configuration

- **Kotlin Version**: 1.9.22
- **Compile SDK**: 34
- **Min SDK**: 24
- **Target SDK**: 34
- **Java Version**: 17

## 🧪 Testing

### Unit Tests

Run unit tests with:
```bash
./gradlew test
```

### UI Tests

Run UI tests with:
```bash
./gradlew connectedAndroidTest
```

## 📊 Performance

- **App Size**: ~5MB
- **Memory Usage**: <50MB during normal operation
- **Startup Time**: <2 seconds on modern devices
- **Battery Impact**: Minimal (no background services)

## 🔒 Security

- No sensitive data stored on device
- No network calls for core functionality
- All data is embedded in the app
- Follows Android security best practices

## 🌐 Localization

Currently supports:
- English (en)

Future releases will include:
- Filipino (tl)
- Chinese (zh)

## 📱 Device Compatibility

### Minimum Requirements
- Android 7.0 (API level 24)
- 2GB RAM
- 50MB storage space
- 720p screen resolution

### Recommended Requirements
- Android 10.0 (API level 29) or higher
- 4GB RAM
- 100MB storage space
- 1080p screen resolution

## 🚀 Build Variants

- **debug**: Development build with debugging enabled
- **release**: Production build with optimizations

## 📝 Version History

### Version 1.0.0 (Current)
- Initial release
- 15 rejection categories
- 60+ specific reasons
- 240+ tactical suggestions
- Material 3 UI design
- Offline functionality

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style

- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Add comments for complex logic
- Keep functions small and focused

## 📞 Support

For support and feedback:

- **Technical Issues**: Contact the development team
- **Feature Requests**: Submit through internal channels
- **User Guide**: See `SunLifeClientTactics.html` for detailed user manual

## 📄 License

© 2024 Sun Life Financial. All rights reserved.

## 🙏 Acknowledgments

- Sun Life Financial for the opportunity to serve advisors
- Material Design team for the excellent design system
- Android development community for best practices and tools

---

**Built with ❤️ for SunLife Advisors**
