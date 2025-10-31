package com.sgm.tests;

import com.sgm.base.Base;
import com.sgm.factory.DriverFactory;
import com.sgm.pages.LoginPage;
import com.sgm.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest {

    Base base;
    LoginPage loginPage;

    Logger log= LogManager.getLogger(this.getClass().getName());


    @BeforeMethod

    public void setup() throws IOException {

        ConfigReader.init_property();
        base=new Base(new DriverFactory().get_Driver());
        base.initialization();
        loginPage = base.fromBasePage();

    }


    @Test(priority = 1)

    public void verifyInvalidLogin() {

        loginPage.enterUserName("Test"+Math.round(Math.random()+1)+"@test.com");
        loginPage.enterPassword("12345678");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getInvalidLoginMessageText(), "Invalid Username, Kindly check again!");
        log.info("Invalid Login Test Passed");

    }


    @Test(priority = 2)

    public void verifyValidLogin() {

        loginPage.enterUserName(ConfigReader.getUserName());
        loginPage.enterPassword(ConfigReader.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.ifUserNameVisible());
        log.info("Valid Login Test Passed");


    }


    @AfterTest

    public void tearDown() {


    }

}
