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

   public String getPageTitle(){
       return pageTitle.getText();
   }
}
