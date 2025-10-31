package com.sgm.pages;

import com.sgm.base.Base;
import com.sgm.factory.DriverFactory;
import com.sgm.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage extends Base {


    public LoginPage(WebDriver driver) {

        super(driver);

    }


    // Enter username

    public void enterUserName(String uname) {

        doSendKeys("input[formcontrolname='username']", uname);

    }

    // Enter password

    public void enterPassword(String pwd) {

        doSendKeys("input[formcontrolname='password']", pwd);
    }


    // click login

    public void clickLoginButton() {

        doClick("button[type='submit']");

    }


    // checkErrorMessagetext

    public String getInvalidLoginMessageText() {

        return getTextFromLocator("div[class*='alert-danger']");
    }


    public boolean ifUserNameVisible() {

        return checkifElementDisplayed("span.demo1");
    }

}
