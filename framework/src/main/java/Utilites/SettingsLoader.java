package Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsLoader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/settings.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load settings.properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}