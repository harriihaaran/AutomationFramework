package com.automation.stepDefinitions;

import java.time.Duration;
import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;

import io.cucumber.java.en.*;

public class LoginSteps {
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        BaseTest.driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        loginPage = new LoginPage(BaseTest.driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {
        String username = ConfigReader.getProperty("login.username");
        String password = ConfigReader.getProperty("login.password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("Clicks on login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the homepage")
    public void verify_homepage() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String actualUrl = BaseTest.driver.getCurrentUrl();
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assert actualUrl.equals(expectedUrl);
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BaseTest.driver.quit();
    }
}
