package com.testUtilities.extentReporting;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    /**
     * Private constructor to avoid external initialization
     */
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extentDriver = new ThreadLocal<>();

    /**
     * Returns the thread-safe {link com.aventstack.extentreports.ExtentTest}
     * instance fetched from ThreadLocal variable.
     * <p>
     * Jul 4, 2021
     *
     * @return Thread-safe {link com.aventstack.extentreports.ExtentTest} instance
     * @author Krishanu
     */
    static ExtentTest getExtentDriver() { // default access modifier: It can be accessed only within the package
        return extentDriver.get();
    }

    /**
     * Set the {link thread-safe {link com.aventstack.extentreports.ExtentTest}
     * instance to ThreadLocal variable.
     * <p>
     * Jul 4, 2021
     *
     * @param test {link thread-safe {link com.aventstack.extentreports.ExtentTest}
     *             instance that needs to be saved from Thread safety issues
     * @author Krishanu
     */
    static void setExtentDriver(ExtentTest test) {

        if (Objects.nonNull(test)) {
            extentDriver.set(test);
        }

    }

    /**
     * Calling the remove() method on ThreadLocal variable ensures to set the
     * default value to ThreadLocal variable. It is much safer tha assigning null
     * value to ThreadLocal variable.
     * <p>
     * Jul 4, 2021
     *
     * @author Krishanu
     */
    static void removeExtentDriver() {
        extentDriver.remove();
    }

}
