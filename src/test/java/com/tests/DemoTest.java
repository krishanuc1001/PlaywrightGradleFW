package com.tests;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoTest {

  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser =
        playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext browserContext = browser.newContext();
    /**
     * Launching test on stock Chrome or MSEdge browsers for Regression testing purpose Can be
     * "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
     */
    // Browser browser = playwright.chromium().launch(new
    // BrowserType.LaunchOptions().setChannel("chrome"));

    // Start tracing before creating / navigating a page.
    browserContext
        .tracing()
        .start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

    Page page = browserContext.newPage();
    page.navigate("https://www.google.com");
    System.out.println("Page title => " + page.title());
    page.type("input[name='q']", "Krishanu");
    page.click("//input[@name='btnK']");
    page.screenshot(
        new Page.ScreenshotOptions()
            .setPath(
                Paths.get(
                    "screenshot_"
                        + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())
                        + ".png")));

    // Stop tracing and export it into a zip archive.
    browserContext
        .tracing()
        .stop(
            new Tracing.StopOptions()
                .setPath(
                    Paths.get(
                        "trace_"
                            + DemoTest.class.getSimpleName()
                            + "_"
                            + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())
                            + ".zip")));

    page.close();
    browser.close();
    playwright.close();
  }
}
