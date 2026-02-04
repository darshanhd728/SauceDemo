package com.company.automation.utils;

import com.company.automation.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebDriverWait explicitWait(WebDriver driver){
        return new WebDriverWait(
                driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
    }
}
