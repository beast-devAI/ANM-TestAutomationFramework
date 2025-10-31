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



   public void doClick(String locator) {

        driver.findElement(By.cssSelector(locator)).click();

    }


    public void doSendKeys(String locator, String value) {

        driver.findElement(By.cssSelector(locator)).sendKeys(value);

    }


    public String getTextFromLocator(String locator) {

        return driver.findElement(By.cssSelector(locator)).getText();

    }

   public boolean checkifElementDisplayed(String locator) {

       return driver.findElement(By.cssSelector(locator)).isDisplayed();

    }


    public List <WebElement> getElementsFromLocator(String locator) {

       return driver.findElements(By.cssSelector(locator));
    }


    public LoginPage fromBasePage() {

       return new LoginPage(driver);
    }


}
