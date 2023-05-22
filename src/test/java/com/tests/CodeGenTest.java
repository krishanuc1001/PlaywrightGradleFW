package com.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeGenTest {

  /**
   * @author Krish Command to see all the options: npx playwright codegen --help
   *     <p>Command to run Playwright Codegen: npx playwright codegen
   *     <p>Command to launch CodeGen with the AUT URL: npx playwright codegen https://saucedemo.com
   *     <p>Command to launch CodeGen with desired language, browser (cr, ff, wk) and AUT URL: npx
   *     playwright codegen --target java --browser ff https://saucedemo.com
   *     <p>Command to emulate devices: npx playwright codegen --device="iPhone 13 Pro"
   */
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser =
          playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext browserContext = browser.newContext();

      // Start tracing before creating / navigating a page.
      browserContext
          .tracing()
          .start(
              new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

      Page page = browserContext.newPage();

      // Go to https://www.saucedemo.com/
      page.navigate("https://www.saucedemo.com/");

      // Click [data-test="username"]
      page.locator("[data-test=\"username\"]").click();

      // Fill [data-test="username"]
      page.locator("[data-test=\"username\"]").fill("problem_user");

      // Press Tab
      page.locator("[data-test=\"password\"]").press("Tab");

      // Click [data-test="password"]
      page.locator("[data-test=\"password\"]").click();

      // Fill [data-test="password"]
      page.locator("[data-test=\"password\"]").fill("secret_sauce");

      // Click [data-test="login-button"]
      page.locator("[data-test=\"login-button\"]").click();
      assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

      // Click text=Sauce Labs Backpack
      page.locator("text=Sauce Labs Backpack").click();
      assertThat(page).hasURL("https://www.saucedemo.com/inventory-item.html?id=5");

      // Click text=Sauce Labs Fleece Jacket
      page.locator("text=Sauce Labs Fleece Jacket").click();

      // Click [data-test="add-to-cart-sauce-labs-fleece-jacket"]
      page.locator("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click();

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
    }
  }
}
