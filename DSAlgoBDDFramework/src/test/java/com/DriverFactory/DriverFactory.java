package com.DriverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;

public class DriverFactory {

	public static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();

//This method is use to initialize thread driver for a given browser and thread local will help in parallel execution

	public WebDriver initializeDriver(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				LoggerLoad.info("Initializing Chrome Browser...");
				thdriver.set(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("firefox")) {
				LoggerLoad.info("Initializing Firefox Browser...");
				thdriver.set(new FirefoxDriver());
			} else if (browser.equals("edge")) {
				LoggerLoad.info("Initializing edge Browser...");
				thdriver.set(new EdgeDriver());
			} else if (browser.equals("safaridriver")) {
				LoggerLoad.info("Initializing safari Browser...");
				thdriver.set(new SafariDriver());
			}
		} catch (Exception e) {
			LoggerLoad.error("Error while Initializing browser. Error is " + e.getMessage());
		}
		// getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return thdriver.get();
	}
}
