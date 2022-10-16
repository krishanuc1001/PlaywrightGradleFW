package com.utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Base64;

import static com.factories.PlaywrightFactory.getPage;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);
        return base64Path;
    }

}
