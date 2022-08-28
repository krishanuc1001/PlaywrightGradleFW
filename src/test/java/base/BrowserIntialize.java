package base;

import com.microsoft.playwright.*;

public class BrowserIntialize {

    public BrowserType browserType;
    public static Playwright playwright;
    public static Page localPage;
    public static Browser browser;

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
