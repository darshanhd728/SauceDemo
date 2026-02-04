package com.company.automation.base;

import com.company.automation.driver.DriverManager;
import com.company.automation.driver.WebDriverFactory;
import com.company.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected void launchApplication(){
        WebDriver driver =
                WebDriverFactory.createDriver(ConfigReader.get("browser"));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }
}
