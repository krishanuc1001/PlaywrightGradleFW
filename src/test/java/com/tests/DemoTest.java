package com.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoTest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.google.com");
        System.out.println("Page title => " + page.title());
        page.type("input[name='q']", "Krishanu");
        page.click("//input[@name='btnK']");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot_" + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + ".png")));

        browser.close();
        playwright.close();
    }

}
