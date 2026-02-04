package com.company.automation.stepdefinitions;

import com.company.automation.pages.LoginPage;
import com.company.automation.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("user is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        loginPage = new LoginPage();

    }
    @When("user logs in using valid credentials")
    public void user_logs_in_using_valid_credentials() {
       loginPage.login("standard_user","secret_sauce");
    }
    @Then("user should see Products page")
    public void user_should_see_products_page() {
        productsPage = new ProductsPage();
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }
}
