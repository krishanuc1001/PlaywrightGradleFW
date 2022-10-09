package com.factories;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PlaywrightFactory {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;

    Properties properties;

    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        log.info("<<======= USING BROWSER" + browserName + "=======>>");
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                log.info("<<============ WARNING !!! Please pass correct Browser name. ============>>");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url").trim());

        return page;
    }

    public Properties initProperties() {

        try (FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");) {
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

}
