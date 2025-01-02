# Selenium Java Automation Project

This is a Selenium automation project built with Java, Maven, TestNG and the **Page Object Model (POM)** design pattern. The project is designed for scalable and maintainable test automation.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Test Suites](#test-suites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

---

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)** (version 8 or higher)
- **Apache Maven** (version 3 or higher)
- **TestNG** (testing framework)
- **Browser Drivers** (e.g., ChromeDriver, GeckoDriver) for Selenium
- **Git** (Version control)

---

## Technologies Used

- **Java**: Programming language for writing automation scripts.
- **Selenium WebDriver**: Tool for automating browsers.
- **Maven**: Build automation tool for managing dependencies and running the project.
- **TestNG**: Testing framework for organizing and executing tests.
- **Git**: Version control system.

---

## Project Structure


-**src**
	-**main
		-**java**
			-**com.testautomation.pageobjects**
				-**BasePage** : Base page object including 
				-**HudlMainPage** : Hudl Main page denotes the page oirigianlle accessed from which the user is then directed to the Login Page via the menu options
				-**HudlLoginPage** : Hudl Login page is where the user name and password details are entered
				-**HudleHomePage** : Hudl Home page accessed once successfully logged in

		-**utils**
			-**TestDataUtil** : Utility classes, such as `DriverManager.java`.

		-**resources**
			-**testdata**
				-**credentials.properties** : properties file containing the username and password details used within the tests
			-**msedgedriver.exe** : Edge driver used in browser compatibility testing
	-**test**
		-**java**
			-**com.testautomation.tests.login**
				-**LoginTests** : Tests for teh login functionality stored here and reference the Page Objects
		-**resources**
			-**TestSuites**
				-**BrowserCompatibilityTestSuite.xml** 
				-**RegressionTestSuite.xml** 
				-**FullRegressionTestSuite.xml** 
				-**SmokeTestSuite.xml** 
	-**pom.xml** : Maven configuration file.
- **README.md**: Project documentation.




---

## Test Suites

The project includes the following test suites:

1. **Smoke Test Suite**:
   - A lightweight set of tests to verify critical functionalities of the login workflow work as expected to ensure the system is ready for further testing to be executed.
   - Found in `src/test/resources/TestSuites/SmokeTestSuite.xml`.

2. **Regression Test Suite**:
   - Covers further end-to-end test cases to ensure the login functionality works as expected after changes.
   - Found in `src/test/resources/TestSuites/RegressionTestSuite.xml`.

3. **Full Regression Test Suite**:
	- includes tests from the Smoke Test Suite and the Regression Test Suite combined (so avoiding duplication of test cases in the regression test suite). This is the default set run via mvn clean test command
	   - Found in `src/test/resources/TestSuites/FullRegressionTestSuite.xml`.
	   
4. **Browser Compatibility Test Suite**:
   - Validates login functionality across different browsers (i.e. Chrome and Edge).
   - Found in `src/test/resources/TestSuites/BrowserCompatibilityTestSuite.xml`.

---

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone [Link Text](https://github.com/helenwhitaker/Hudl_Public_HW.git)

2. Copy the user name and password data in the credentials.properties.txt file attached to the email into the credentials.properties file in the project found at src/main/resources/testdata/credentials.properties  

3. Navigate to the project directory

4. Install project dependencies using Maven:
   ```bash
   mvn clean install

---
## Running Tests

###Running Individual Test Suites
You can run the Full Regression Suite by running the command
   ```bash
   
   mvn clean test

If you want to run a specific test Suite including the Browser Compatibility Test Suite then run the commands as below:

###Running Smoke Test Suite
Run the SmokeTestSuite using the following command:

   ```bash
mvn clean  test -DsuiteXmlFile=SmokeTestSuite.xml


###Running Regression Test Suite
Run the RegressionTestSuite using:
   ```bash
   
   mvn clean  test -DsuiteXmlFile=RegressionTestSuite
   
   ###Running FullRegression Test Suite
Run the FullRegressionTestSuite using:
   ```bash
   
   mvn clean test

###Running Browser Compatibility Test Suite
Run the BrowserCompatibilityTestSuite using:
   ```bash

mvn clean  test -DsuiteXmlFile=BrowserCompatibilityTestSuite

---


##Features
* Full Regression Test: Full coverage of end-to-end test scenarios from both the regression and smoke test suites
* Regression Testing: Coverage of end-to-end test scenarios excl those in smoke test.
* Smoke Testing: Quick validation of critical functionalities.
* Cross-Browser Testing: Support for multiple browser configurations.
* TestNG Integration: Flexible and organized test execution.
* Maven Dependency Management: Easy management of Selenium, TestNG, and other libraries.


---


##Contributing
Contributions are welcome. In order to contribute please 

1. Create a fork
2. Create a feature branch
   ```bash
git checkout -b feature-branch-name


3. Commit your changes
   ```bash
git commit -m "Add a meaningful message about your feature"


4. Push to your branch
   ```bash
git push origin feature-branch-name

5. Submit a pull request

 


---


##License
This project is licensed under the MIT License.   
