package com.forLastPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties finalProperties = new Properties();
    private static PropertyUtil instance = new PropertyUtil();

    private PropertyUtil() {
        String[] fileNames = new String[] {"/work.properties"};
        bindLocalProperties(fileNames);
    }

    public static PropertyUtil getInstance() {
        return instance;
    }

    public String getStringValue(String key) {
        String value = finalProperties.getProperty(key);
        if (value == null) {
            return null;
        }
        return value;
    }

    private void bindLocalProperties(String[] fileName) {
        Properties properties = new Properties();
        for (String signalFileName : fileName) {
            InputStream inputStream = TestPropertyUtil.class.getResourceAsStream(signalFileName);
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finalProperties.putAll(properties);
    }

}
