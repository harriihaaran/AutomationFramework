package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // ✅ Set Explicit Wait

    }

    // Locators
    By usernameField = By.id("email");
    By passwordField = By.id("pass");
    By loginButton = By.id("send2");

    // Methods
    public void enterUsername(String username) {

        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));  // ✅ Wait for visibility
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
