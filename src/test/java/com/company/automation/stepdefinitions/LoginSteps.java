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
    @When("user logs in with {string} and {string}")
    public void user_logs_with_credentials(String username, String password) {

        loginPage.login(username, password);

    }

    @Then("products page should be displayed")
    public void products_page_should_be_displayed() {
        productsPage = new ProductsPage();
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }
}
