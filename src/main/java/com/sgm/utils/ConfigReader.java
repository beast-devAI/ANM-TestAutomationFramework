package com.sgm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final static String propFilePath ="src/main/resources/config.properties";

    static Properties prop;

    public static void init_property() throws IOException {

        prop = new Properties();
        prop.load(new FileInputStream(new File(propFilePath)));

    }


    public static String getBrowser() {

        return prop.getProperty("browser");
    }

    public static String getAppURL() {
        return prop.getProperty("appURL");

    }

    public static String getUserName() {

        return prop.getProperty("userName");

    }

    public static String getPassword() {

        return prop.getProperty("password");

    }

    public static String getEnvDetails() {

        return prop.getProperty("env");

    }

    public static String getAppVersion() {

        return prop.getProperty("appVersion");

    }


}
