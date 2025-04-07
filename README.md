# AutomationFramework

# 🚀 Selenium-Cucumber Automation Framework

This project is a **Java-based Automation Framework** built with **Selenium WebDriver**, **Cucumber (BDD)**, **Maven**, and **Extent Reports**, designed to automate functional testing of a sample e-commerce site — `demotesting.com`. The framework follows a **Page Object Model (POM)** design pattern for better scalability and maintainability.

---

## 📌 Features

- ✅ Modular structure using Page Object Model (POM)
- ✅ Cucumber for Behavior-Driven Development (BDD)
- ✅ Selenium WebDriver for UI Automation
- ✅ Maven for build and dependency management
- ✅ Extent Reports for detailed HTML reporting with screenshots
- ✅ Test data handled separately using `.properties` or `.csv` files
- ✅ Screenshot capture on test failure
- ✅ Email report functionality with secure credentials via environment variables
- ✅ Compatible with both **Windows** and **macOS**

---

## 🔧 Technologies Used

- Java 17+
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven
- ExtentReports
- Git & GitHub
- VS Code

---

## 📂 Project Structure

AutomationFramework/ ├── src/test/java/com/automation/ │ ├── base/ # WebDriver setup and base functions │ ├── pages/ # Page Object classes │ ├── stepdefinitions/ # Cucumber step definitions │ ├── hooks/ # Test setup & teardown │ ├── utils/ # Report, Screenshot, Wait utilities │ ├── testdata/ # Test data files ├── src/test/resources/ │ ├── features/ # .feature files (Cucumber) ├── test-output/ # Extent reports & screenshots ├── pom.xml # Maven project config


---


## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/AutomationFramework.git

2. Navigate into the project directory: 
    cd AutomationFramework

3. Run the tests:
    mvn clean test

4. View the generated report at:
    test-output/ExtentReport.html

---

📸 Sample Report Output
The report includes:
1. Test case name and status
2. Execution time
3. Screenshots on failure
4. Failure reasons

---

📩 Email Report (Optional)
To send reports via email after execution:
Set environment variables:
EMAIL_USER = your sender Gmail address
EMAIL_PASS = app password (not your main Gmail password)

The framework will send the test report to a specified recipient securely.

---

🧪 Sample Scenario

Feature: User Login

  Scenario: Successful Login
    Given User navigates to "https://demotesting.com"
    When User enters username "testUser" and password "testPass"
    Then User should be logged in successfully

👨‍💻 Author
Hariharan B
Manual Tester turned Automation Enthusiast
www.linkedin.com/in/harryjeens

🌟 Show Your Support
If you find this framework helpful, feel free to ⭐ star the repository and fork it to your own workspace!