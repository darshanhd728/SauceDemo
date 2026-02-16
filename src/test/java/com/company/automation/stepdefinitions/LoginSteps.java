package com.company.automation.stepdefinitions;

import com.company.automation.driver.DriverManager;
import com.company.automation.pages.LoginPage;
import com.company.automation.pages.ProductsPage;
import com.company.automation.utils.ConfigReader;
import com.company.automation.utils.UserCredentialsExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("user is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {

        DriverManager.getDriver().get(ConfigReader.get("url"));

        loginPage = new LoginPage();

    }
    @When("user logs in using excel data")
    public void user_logs_in_using_excel_data() {

        Object[][] data =
                UserCredentialsExcelUtils.getTestData("Login");

        for(Object[] credentials : data){

            loginPage = new LoginPage();

            loginPage.login(
                    credentials[0].toString(),
                    credentials[1].toString()
            );

            productsPage = new ProductsPage();

            try {

                // VALID LOGIN
                if(productsPage.getPageTitle().equals("Products")) {

                    System.out.println(
                            "VALID LOGIN: " + credentials[0]
                    );

                    productsPage.logout();
                }

            }
            catch(Exception e){

                // INVALID LOGIN
                if(loginPage.isErrorDisplayed()) {

                    System.out.println(
                            "INVALID LOGIN: " + credentials[0]
                    );

                    System.out.println(
                            "Error: " +
                                    loginPage.getErrorMessage()
                    );
                }
            }

            // navigate back to login page
            DriverManager.getDriver().get(
                    ConfigReader.get("url")
            );
        }
    }

    @Then("products page should be displayed")
    public void products_page_should_be_displayed() {

        System.out.println("All logins verified");
    }
}
