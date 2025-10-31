package com.sgm.factory;

import com.sgm.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver get_Driver() {


        if (ConfigReader.getBrowser().equalsIgnoreCase("FF")) {

            driver = new FirefoxDriver();
        } else if (ConfigReader.getBrowser().equalsIgnoreCase("Chrome")) {

            driver = new ChromeDriver();
        } else if (ConfigReader.getBrowser().equalsIgnoreCase("Edge")) {

            driver = new EdgeDriver();
        } else if (ConfigReader.getBrowser().equalsIgnoreCase("safari")) {

            driver = new SafariDriver();
        } else {

            System.out.println("no matching driver found");
        }


        return driver;

    }


}
