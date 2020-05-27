package tool;

import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyUtils {
    private static Configuration config = new PropertiesConfiguration();

    public PropertyUtils() {
        try {
            config = new PropertiesConfiguration("application.properties");
            printConfig();
            log.info("PropertyUtils already load");
        } catch (ConfigurationException e) {
            log.error("PropertyUtils error: {}", e);
        }

    }

    public static void printConfig() {
        log.info("PropertyUtils printConfig begin");
        Iterator<String> keys = config.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            log.info("key=value:{}=={}", key, config.getString(key));
        }

    }

    public static void setValue(String key, String value) {
        config.setProperty(key, value);
    }

    public static String getStringValue(String key, String defaultValue) {
        if (null == config || null == config.getString(key)) {
            return defaultValue;
        } else {
            if (key.endsWith(".location")) {
                return config.getString("extractor.base.location") + config.getString(key);
            }
            return config.getString(key);
        }
    }

    public static int getStringValueAsInt(String key, String defaultValue) {
        if (null == config || null == config.getString(key)) {
            return Integer.valueOf(defaultValue);
        } else {
            return config.getInt(key);
        }
    }

}