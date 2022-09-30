package com.tests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CodeGenTest {

    /**
     * @author Krish
     *
     * Command to see all the options:
     * npx playwright codegen --help
     *
     * Command to run Playwright Codegen:
     * npx playwright codegen
     *
     * Command to launch CodeGen with the AUT URL:
     * npx playwright codegen https://saucedemo.com
     *
     * Command to launch CodeGen with desired language, browser (cr, ff, wk) and AUT URL:
     * npx playwright codegen --target java --browser ff https://saucedemo.com
     *
     * Command to emulate devices:
     * npx playwright codegen --device="iPhone 13 Pro"
     *
     */

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

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
        }
    }
}

