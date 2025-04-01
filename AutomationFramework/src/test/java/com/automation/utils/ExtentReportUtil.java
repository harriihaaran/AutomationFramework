package com.automation.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final String REPORT_PATH = "test-output/ExtentReport.html";

    // Initialize Extent Report
    public static void initReport() {
        if (extent == null) {  // ✅ Avoid multiple initializations
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("UI Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Hariharan");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
    }

    // Start Test Case Logging
    public static void startTest(String testName) {
        if (extent == null) {
            throw new IllegalStateException("Extent Report not initialized. Call initReport() first.");
        }
        test = extent.createTest(testName);
    }

    // Log Pass
    public static void logPass(String message) {
        test.log(Status.PASS, message);
    }

    // Log Fail with Reason
    public static void logFail(String message) {
        test.log(Status.FAIL, message);
    }

    // Log Info
    public static void logInfo(String message) {
        test.log(Status.INFO, message);
    }

    // Capture Screenshot on Failure
    public static void logFailureDetails(Scenario scenario, WebDriver driver) {
        if (scenario.isFailed()) {
            test.fail("Test Case Failed: " + scenario.getName());
            test.fail("Failure Reason: " + scenario.getStatus().toString());
    
            // ✅ Capture screenshot and attach to report
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            if (screenshotPath != null) {
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

    // Flush Report
    public static void generateReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
