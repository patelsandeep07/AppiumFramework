```markdown
# Appium Mobile Test Automation Framework

An automated mobile testing framework built with **Appium**, **Java**, **TestNG**, and **Maven**. Designed for automated testing of native, hybrid, and mobile web applications on **Android** and **iOS** devices.

---

## 🚀 Features

- **Cross-Platform Support**: Reusable test automation for both Android (.apk) and iOS (.app / .ipa) applications.
- **Page Object Model (POM)**: Organized architecture separating page elements/gestures from test cases for high maintainability.
- **Gesture Support**: Built-in utility functions for common mobile gestures (scroll, swipe, pinch, zoom, long press).
- **Driver & Server Management**: Configurable desired capabilities with automatic Appium driver initialization.
- **Test Execution & Reporting**: Integrated with TestNG for suite management, parallel execution, and report generation (Extent Reports / TestNG Reports).

---

## 🛠️ Prerequisites & Setup

### Prerequisites
- **Java Development Kit (JDK)**: 11 or higher
- **Node.js & npm**: Required to run the Appium server
- **Appium Server**: Installed globally via `npm install -g appium`
- **Android Studio & SDK** (for Android testing): Configured with `ANDROID_HOME` environment variable
- **Xcode** (for iOS testing, macOS required): Configured with command-line tools
- **Build Tool**: Apache Maven 3.6+

---

## 📁 Repository Structure

```text
AppiumFramework/
├── src/
│   ├── main/java/
│   │   ├── com/qa/pages/          # Page Object classes (UI locators and gestures)
│   │   ├── com/qa/utils/          # Utility classes (Appium gestures, config reader, wait strategies)
│   │   └── com/qa/base/           # Base class for Driver setup and Desired Capabilities
│   └── test/java/
│       └── com/qa/tests/          # Mobile Test Cases
├── apps/                          # Directory for target .apk / .app files
├── testng.xml                     # TestNG execution suite configuration
├── pom.xml                        # Maven dependencies & build plugins
└── README.md                      # Framework documentation

```

---

## ⚙️ Configuration

1. Place your application file (`.apk` or `.app`) inside the `apps/` directory or specify the absolute path in your configuration properties file (`src/main/resources/config.properties`).
2. Set up desired capabilities for your target device/emulator:

```properties
platformName=Android
deviceName=Android Emulator
automationName=UiAutomator2
appPath=${user.dir}/apps/sample.apk

```

---

## ⚡ Running Tests

### 1. Start Appium Server

Ensure the Appium server is running locally on port `4723`:

```bash
appium

```

### 2. Execute Tests via Maven

Run the full test suite from the terminal:

```bash
mvn clean test

```

Run tests targeting a specific platform or test suite:

```bash
mvn test -Dplatform=android

```

---

## 📊 Test Reports

After execution finishes, test logs and execution reports are generated under:

* **TestNG HTML Report**: `test-output/index.html`
* **Extent Report** *(if configured)*: `test-output/ExtentReport.html`

---

## 🤝 Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/MobileTestCase`).
3. Commit your changes (`git commit -m 'Add mobile automation test'`).
4. Push to the branch (`git push origin feature/MobileTestCase`).
5. Open a Pull Request.
