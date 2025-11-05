package com.sgm.tests;

import com.sgm.base.Base;
import com.sgm.factory.DriverFactory;
import com.sgm.pages.LoginPage;
import com.sgm.utils.ConfigReader;
import com.sgm.utils.ExcelReader;
import com.sgm.utils.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.TestResult;

import java.io.IOException;
import java.text.ParseException;

public class LoginPageTest {

    Base base;
    LoginPage loginPage;

    WebDriver driver;

    Logger log= LogManager.getLogger(this.getClass().getName());




    @BeforeMethod

    public void setup() throws IOException {

        ConfigReader.init_property();
        driver=new DriverFactory().get_Driver();
        base=new Base(driver);
        base.initialization();
        loginPage = base.fromBasePage();

    }


    @DataProvider(name="SGM Login Data")

    public String[][] userLoginData() throws IOException, ParseException {

       return ExcelReader.getTestDataFromExcel();

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


    @Test(priority = 3 , dataProvider = "SGM Login Data")

    public void verifyMultipleValidLogin(String uname , String pwd, String accName) {

        loginPage.enterUserName(uname);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.ifUserNameVisible());
        log.info("Valid Login Test Passed");


    }

    @AfterMethod

    public void onTestMethoFailure(ITestResult result) throws IOException {

        if(result.getStatus()==TestResult.FAILURE|result.getStatus()==TestResult.SKIP) {

            TestUtils.takeScreenshotOnError(driver,result.getName());

        }




    }




    @AfterTest

    public void tearDown() {

        driver.quit();

    }

}
