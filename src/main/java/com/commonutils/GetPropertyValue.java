package com.commonutils;

import java.io.*;
import java.util.Properties;

public class GetPropertyValue {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/Configurations/app.properties";
    InputStream inputStream;
    String result;

    public GetPropertyValue() {
        BufferedReader reader;
        try {
            File path = new File(propertyFilePath);
            reader = new BufferedReader(new FileReader(path.getAbsolutePath()));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static GetPropertyValue getPropertyValueObject() {
        return new GetPropertyValue();
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null)
            return driverPath;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }


    public String getProperyValue(String key) {
        String value = properties.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


}
