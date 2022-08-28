package com.factories;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.FrameworkConstants;
// import com.drivers.DriverManager;
import com.enums.WaitStrategyEnum;

public final class ExplicitWaitFactory {

    static Logger logger;

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(By by, WaitStrategyEnum waitStrategyEnum) {

        WebElement ele = null;

//        if (waitStrategyEnum == WaitStrategyEnum.CLICKABLE) {
//            ele = new WebDriverWait(DriverManager.getDriver(),
//                    Duration.ofSeconds(FrameworkConstants.getExplicityWaitTime()))
//                    .until(ExpectedConditions.elementToBeClickable(by));
//        } else if (waitStrategyEnum == WaitStrategyEnum.PRESENCE) {
//            ele = new WebDriverWait(DriverManager.getDriver(),
//                    Duration.ofSeconds(FrameworkConstants.getExplicityWaitTime()))
//                    .until(ExpectedConditions.presenceOfElementLocated(by));
//        } else if (waitStrategyEnum == WaitStrategyEnum.VISIBLE) {
//            ele = new WebDriverWait(DriverManager.getDriver(),
//                    Duration.ofSeconds(FrameworkConstants.getExplicityWaitTime()))
//                    .until(ExpectedConditions.visibilityOfElementLocated(by));
//        } else if (waitStrategyEnum == WaitStrategyEnum.NONE) {
//            ele = DriverManager.getDriver().findElement(by);
//            logger.log(Level.INFO, "No need to wait...");
//        }

        return ele;

    }


}
