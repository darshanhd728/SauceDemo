package com.company.automation.pages;

import com.company.automation.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

   private WebDriver driver;
   public ProductsPage(){
   this.driver = DriverManager.getDriver();
       PageFactory.initElements(driver, this);
    }

    @FindBy(className ="title") private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement product1;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
     private WebElement addToCart;

   public String getPageTitle(){

       return pageTitle.getText();
   }

   public void selectProduct(){
       product1.click();
   }

   public void AddToCart(){
       addToCart.click();
   }
}
