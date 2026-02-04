package com.company.automation.hooks;

import com.company.automation.base.BaseTest;
import com.company.automation.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  extends BaseTest {

    @Before
    public void setUp(){
        launchApplication();
    }

    @After
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
