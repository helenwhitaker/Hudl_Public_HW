package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataUtil {
    private static Properties properties;

    static {
        try {
            // Load the properties file
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/testdata/credentials.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load credentials.properties file", e);
        }
    }

    // Get the property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
