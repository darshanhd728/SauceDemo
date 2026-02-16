package com.company.automation.hooks;

import com.company.automation.driver.DriverManager;
import com.company.automation.utils.ConfigReader;
import com.company.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

        @Before
        public void setUp() {

            ChromeDriver driver = new ChromeDriver();

            DriverManager.setDriver(driver);

            driver.manage().window().maximize();

            String url = ConfigReader.get("url");

            driver.get(url);
        }

        @After
        public void tearDown(Scenario scenario){

            if(scenario.isFailed()){

                String path = ScreenshotUtils.captureScreenshot(scenario.getName());

                scenario.attach(path, "image/png", scenario.getName());
            }

            DriverManager.getDriver().quit();
        }
    }
