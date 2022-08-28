package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ReadGlobalProperties {

    Properties pro;

    private ReadGlobalProperties() {

        try {
            File source = new File("/src/test/java/config/config.properties");
            FileInputStream fis = new FileInputStream(source);
            pro = new Properties();
            pro.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readProperties() {

        TestSettings.url = pro.getProperty("url");
        TestSettings.browserName = pro.getProperty("browserName");
        TestSettings.headLess = Boolean.parseBoolean(pro.getProperty("headLess"));
        TestSettings.devTools = Boolean.parseBoolean(pro.getProperty("devTools"));
        TestSettings.deviceEmulationType = pro.getProperty("deviceEmulationType");
        TestSettings.locale = pro.getProperty("locale");

    }

    public static void populateSettings(){
        new ReadGlobalProperties().readProperties();
    }

}
