package com.company.automation.stepdefinitions;

import com.company.automation.driver.DriverManager;
import com.company.automation.pages.LoginPage;
import com.company.automation.pages.ProductsPage;
import com.company.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addTocart {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("user is logged in as {string}")
    public void user_is_logged_in_as(String string) {

        DriverManager.getDriver().get(ConfigReader.get("url"));

        loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage();
    }

    @Given("the user is on the product page")
    public void user_adds_product_to_cart() {

        productsPage.getPageTitle();
    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_car() {

        productsPage.selectProduct();
    }

    @Then("the product should be displayed on the cart page")
    public void the_product_should_be_displayed_on_the_cart_page(){

        productsPage.AddToCart();
    }
}
