# VAT Calculator Test Automation

This project contains automated tests for the VAT Calculator web application using Selenium WebDriver, Cucumber, and Gradle.

## Project Structure

```
vat-calculator-test/
├── build.gradle
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── pages/
│   │   │   │   └── VatCalculatorPage.java
│   │   │   ├── stepdefinitionss/
│   │   │   │   └── VatCalculatorStepDefinitions.java
│   │   │   ├── utils/
│   │   │   │   └── WebDriverFactory.java
│   │   │   └── runners/
│   │   │       └── TestRunner.java
│   │   └── resources/
│   │       └── features/
│   │           └── vat_calculator.feature
└── gradle/
    └── wrapper/
        ├── gradle-wrapper.jar
        └── gradle-wrapper.properties
```

## Prerequisites

- Java JDK 8 or higher
- Gradle (or use the included Gradle wrapper)
- Chrome browser installed

## Setup

1. Clone this repository:
   ```
   git clone https://github.com/pelkosom/vat-calculator-test.git
   cd vat-calculator-test
   ```

2. The project uses Gradle for dependency management. All necessary dependencies are specified in the `build.gradle` file.

## Running the Tests

To run the tests, use the following command in the project root directory:

```
./gradlew cucumber
```

This will execute all the Cucumber scenarios defined in the feature files.

## Key Components

- `VatCalculatorPage.java`: Page Object Model class for the VAT Calculator page.
- `VatCalculatorStepDefinitions.java`: Step definitions for Cucumber scenarios.
- `WebDriverFactory.java`: Factory class for creating WebDriver instances.
- `TestRunner.java`: JUnit test runner for Cucumber tests.
- `vat_calculator.feature`: Cucumber feature file containing test scenarios.

## Writing New Tests

1. Add new scenarios to the `vat_calculator.feature` file or create new feature files in the `src/test/resources/features` directory.
2. Implement new step definitions in `VatCalculatorStepDefinitions.java` or create new step definition classes as needed.
3. If new pages are introduced, create corresponding Page Object Model classes in the `pages` package.

## Configuration

- The tests run using ChromeDriver by default. To change browser settings or add support for other browsers, modify the `WebDriverFactory.java` file.
- Tests run in headless mode by default. To run with a visible browser, comment out the `--headless` option in `WebDriverFactory.java`.

## Troubleshooting

- If you encounter issues with ChromeDriver, ensure you have the latest version of Chrome installed.
- The project uses WebDriverManager to handle driver executables. If you face any driver-related issues, try updating the WebDriverManager dependency in `build.gradle`.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.