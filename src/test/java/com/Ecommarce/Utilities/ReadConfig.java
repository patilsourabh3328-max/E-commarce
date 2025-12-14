package com.Ecommarce.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    String path = "E:\\Automationpractise\\com.Ecommarce\\Configuration\\Config.properties";

    public ReadConfig() {
        try {
            properties = new Properties();        // ✅ FIX
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);                 // ✅ FIX
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getbaseUrl() {
        String value = properties.getProperty("baseUrl");
        if (value != null)
            return value;
        else
            throw new RuntimeException("baseUrl not added in config file");
    }

    public String getbrowser() {
        String value = properties.getProperty("browser");
        if (value != null)
            return value;
        else
            throw new RuntimeException("browser not added in config file");
    }
}
