package com.tests;

import com.microsoft.playwright.*;

public class MultipleBrowserContextDemo {

  public static void main(String[] args) {

    Playwright playwright = Playwright.create();
    Browser browser =
        playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

    BrowserContext browserContext1 = browser.newContext();
    Page page1 = browserContext1.newPage();
    page1.navigate("https://www.saucedemo.com/");
    String title1 = page1.title();
    System.out.println(title1);

    BrowserContext browserContext2 = browser.newContext();
    Page page2 = browserContext2.newPage();
    page2.navigate("https://www.playwright.dev");
    String title2 = page2.title();
    System.out.println(title2);

    BrowserContext browserContext3 = browser.newContext();
    Page page3 = browserContext3.newPage();
    page3.navigate("https://www.selenium.dev/");
    String title3 = page3.title();
    System.out.println(title3);

    page1.close();
    browserContext1.close();

    page2.close();
    browserContext2.close();

    page3.close();
    browserContext3.close();

    browser.close();
    playwright.close();
  }
}
