package base;

import com.microsoft.playwright.*;
import config.TestSettings;
import org.testng.annotations.Test;

public class FrameworkInitialize {

    public BrowserType.LaunchOptions launchOptions;
    public BrowserIntialize browserIntialize;
    public Browser browser;
    public Browser.NewContextOptions contextOptions;
    public BrowserContext browserContext;

    public Playwright playwright;
    public BrowserType browserType;

    public Page initializePlaywright() {

        // Set launch options
        launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = TestSettings.headLess;
        launchOptions.devtools = TestSettings.devTools;

        // Initialize the browser
        browserIntialize = new BrowserIntialize();

        //Get Browser
        browser = new FrameworkInitialize().getBrowser(TestSettings.browserName, launchOptions);

        // Get BrowserContext
        contextOptions = new Browser.NewContextOptions();
        contextOptions.locale = TestSettings.locale;

        // contextOptions.setIsMobile(true);
//        if (TestSettings.IsMobile) {
//            contextOptions.setViewportSize(360, 640);
//            contextOptions.setDeviceScaleFactor(1);
//        }

        browserContext = new FrameworkInitialize().getBrowserContext(browser, contextOptions);

        // return Page
        return new FrameworkInitialize().getPage(browserContext);

    }

    public Browser getBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {

        playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        }
        if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }

        return browserType.launch(launchOptions);

    }

    public BrowserContext getBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions) {
        return browser.newContext(newContextOptions);
    }

    public Page getPage(BrowserContext browserContext) {
        return browserContext.newPage();
    }

}
