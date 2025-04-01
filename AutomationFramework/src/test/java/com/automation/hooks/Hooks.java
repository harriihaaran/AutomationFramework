package com.automation.hooks;

import com.automation.base.BaseTest;
import com.automation.utils.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {  // ✅ Initialize Extent Report before any test runs
        ExtentReportUtil.initReport();
    }
    
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("🚀 Launching the browser...");
        BaseTest.setup();
        ExtentReportUtil.startTest(scenario.getName());  // ✅ Start Extent Report logging
    }

    @After
public void afterScenario(Scenario scenario) {
    if (scenario.isFailed()) {
        ExtentReportUtil.logFailureDetails(scenario, BaseTest.driver);  // ✅ Capture and attach screenshot
    } else {
        ExtentReportUtil.logPass("Test Case Passed: " + scenario.getName());
    }

    System.out.println("🛑 Closing the browser...");
    BaseTest.tearDown();
    ExtentReportUtil.generateReport();  // ✅ Generate final report
}
}
