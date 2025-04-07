package com.automation.testRunner;

import org.testng.annotations.AfterSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.automation.utils.EmailReport;

@CucumberOptions(
    features = "src/test/java/com/automation/features",
    glue = {"com.automation.stepDefinitions", "com.automation.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void sendEmailReport() {
        EmailReport.sendReport();
    }
}
