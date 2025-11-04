package com.sgm.utils;

import com.sgm.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtils {



    // take screenshot


    public static void takeScreenshotOnError(WebDriver driver,String testName) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshot" + File.separator +testName+ "_" + new Date().getTime() + ".jpeg");

        FileUtils.copyFile(src, dest);


    }


    // send email

    public void sendEmailOnError() {


    }


}
