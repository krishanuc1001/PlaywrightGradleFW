/**
 * 
 */
package com.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.enums.ConfigPropertiesEnum;
import com.utils.PropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Jun 29, 2021
 * 
 * @author Krishanu
 */
public final class DriverFactory {

	private DriverFactory() {
	}

	/**	 
	 * Jul 4, 2021
	 * @author Krishanu
	 * @param browser
	 * @param version
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {

		String runmode = PropertiesUtils.get(ConfigPropertiesEnum.RUNMODE);
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {

			if (runmode.equalsIgnoreCase("Docker")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(version);

				driver = new RemoteWebDriver(new URL(PropertiesUtils.get(ConfigPropertiesEnum.SELENIUMGRIDURL)), cap);

			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			if (runmode.equalsIgnoreCase("Docker")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);

				driver = new RemoteWebDriver(new URL(PropertiesUtils.get(ConfigPropertiesEnum.SELENIUMGRIDURL)), cap);

			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		}
		return driver;

	}

}
