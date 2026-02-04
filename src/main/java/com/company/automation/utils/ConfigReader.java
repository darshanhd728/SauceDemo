package com.company.automation.utils;

import com.company.automation.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader{

    private static Properties prop;

    static {
        try{
            prop = new Properties();
            FileInputStream fis =
                    new FileInputStream(FrameworkConstants.CONFIG_PATH);
            prop.load(fis);
        } catch (Exception e){
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }
}
