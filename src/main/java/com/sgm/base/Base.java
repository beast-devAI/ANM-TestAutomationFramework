package com.sgm.base;

import com.sgm.factory.DriverFactory;
import com.sgm.pages.LoginPage;
import com.sgm.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Base {

   public WebDriver driver;

   public Base(WebDriver driver){

       this.driver=driver;

    }


   public void initialization (){

       driver.get(ConfigReader.getAppURL());
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


   }



   public void doClick(By locator) {

        driver.findElement(locator).click();

    }


    public void doSendKeys(By locator, String value) {

        driver.findElement(locator).sendKeys(value);

    }


    public String getTextFromLocator(By locator) {

        return driver.findElement(locator).getText();

    }

   public boolean checkifElementDisplayed(By locator) {

       return driver.findElement(locator).isDisplayed();

    }


    public List <WebElement> getElementsFromLocator(By locator) {

       return driver.findElements(locator);
    }


    public LoginPage fromBasePage() {

       return new LoginPage(driver);
    }


}
