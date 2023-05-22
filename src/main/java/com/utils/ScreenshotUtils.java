package com.utils;

import static com.factories.PlaywrightFactory.getPage;

import com.constants.FrameworkConstants;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.util.Base64;

public final class ScreenshotUtils {

  private ScreenshotUtils() {}

  public static String takeScreenshot() {
    String path =
        FrameworkConstants.getScreenshotFolderPath() + System.currentTimeMillis() + ".png";
    byte[] buffer =
        getPage()
            .screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
    return Base64.getEncoder().encodeToString(buffer);
  }
}
