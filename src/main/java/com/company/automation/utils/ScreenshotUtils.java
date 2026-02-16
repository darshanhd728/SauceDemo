package com.company.automation.utils;

import com.company.automation.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(String name) {
        try {

            File src = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String path = "target/screenhot/" + name + ".png";

            Files.createDirectories(Paths.get("target/screenshots"));
            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (Exception e) {
            return null;
        }
    }
}
