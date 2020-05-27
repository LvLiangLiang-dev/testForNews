package com.forLastPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2019/10/25.
 */
public class TestPropertyUtil {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = TestPropertyUtil.class.getResourceAsStream("/work.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.get("temp"));

        System.out.println(PropertyUtil.getInstance().getStringValue("temp"));

    }
}
