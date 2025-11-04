package com.sgm.pages;

import com.sgm.base.Base;
import com.sgm.factory.DriverFactory;
import com.sgm.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage extends Base {

    // OR (Object Repository)

    private By loc_userName = By.cssSelector("input[formcontrolname='username']");
    private By loc_pwd = By.cssSelector("input[formcontrolname='password']");
    private By loc_btn = By.cssSelector("button[type='submit']");
    private By loc_error_Message = By.cssSelector("div[class*='alert-danger']");
    private By loc_AccountID = By.cssSelector("span.demo1");

    public LoginPage(WebDriver driver) {

        super(driver);

    }


    // Page Actions

    // Enter username

    public void enterUserName(String uname) {

        doSendKeys(loc_userName, uname);

    }

    // Enter password

    public void enterPassword(String pwd) {

        doSendKeys(loc_pwd, pwd);
    }


    // click login

    public void clickLoginButton() {

        doClick(loc_btn);

    }


    // checkErrorMessagetext

    public String getInvalidLoginMessageText() {

        return getTextFromLocator(loc_error_Message);
    }


    public boolean ifUserNameVisible() {

        return checkifElementDisplayed(loc_AccountID);
    }

}
