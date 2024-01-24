# Mobile Tests using Appium

This repository contains Appium tests for a mobile application. The tests are written in Java and use TestNG as the testing framework.

## Prerequisites

Before running the tests, ensure you have the following installed:

- Appium
- Android Emulator or Real Device
- Java Development Kit (JDK)
- Appium Server running

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/usmanali18feb/izi.TRAVEL.git
    ```

2. Install dependencies:

    ```bash
    # Assuming you are using Maven
    mvn clean install
    ```

3. Update the Appium server URL and device capabilities in the `setUp` method of the `mobileTests` class.

4. Run the tests:

    ```bash
    # Assuming you are using Maven
    mvn test
    ```

## Project Structure

- **src/main/java**: Contains the main Java code.
- **src/test/java**: Contains the test code.
- **pom.xml**: Maven project configuration file.

## Test Descriptions

### 1. Consent Handling Test

This test verifies the functionality of handling consent in the mobile application.

### 2. Around Me Functionality Test

This test verifies the functionality related to the "Around Me" feature in the application.

### 3. Location Permission Handling Test

This test checks the application's behavior when handling location permissions.

### 4. Selecting School Test

This test verifies the process of selecting a school in the application.

### 5. Playing Audio Test

This test checks the functionality of playing audio in the mobile application.

## Cleanup

The `tearDown` method ensures proper cleanup after the test execution.

