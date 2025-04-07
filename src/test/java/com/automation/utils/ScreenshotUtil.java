package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtil {
    private static final String SCREENSHOT_FOLDER = "test-output/screenshots/";

    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        try {
            // Create screenshots folder if it doesn't exist
            File directory = new File(SCREENSHOT_FOLDER);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Set file path with scenario name
            String screenshotPath = SCREENSHOT_FOLDER + scenarioName.replaceAll(" ", "_") + ".png";

            // Take screenshot and save
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);

            return screenshotPath;  // ✅ Return path for Extent Report
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
