package ru.sold.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {

    public static final Properties PROPERTIES = new Properties();
    private static TestPropManager instance = null;

    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    public static TestPropManager getInstance() {
        if (instance == null) {
            instance = new TestPropManager();
        }
        return instance;
    }

    private void loadApplicationProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/" + System.getProperty("propFile", "application") + ".properties")) {
            PROPERTIES.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomProperties() {
        PROPERTIES.forEach((key, value) ->
                System.getProperties().forEach((customKey, customValue) -> {
                            if (key.toString().equals(customKey.toString()) && value.toString().equals(customValue.toString())) {
                                PROPERTIES.setProperty(key.toString(), customValue.toString());
                            }
                        }
                ));
    }

    public String getProperty(String key, String defaultValue) {
        return PROPERTIES.getProperty(key, defaultValue);
    }

    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
