package com.DriverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;

public class DriverFactory {

	public static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();
	
	//we keep our WebDriver reference static to make it thread-safe

//This method is use to initialize thread driver for a given browser and thread local will help in parallel execution

	public WebDriver initializeDriver(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				LoggerLoad.info("Initializing Chrome Browser in headless mode...");
				
				//Add options for --headless browser launch
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("headless");
	            chromeOptions.addArguments("window-size=1366,768");          
	           // driver = new ChromeDriver(chromeOptions);
						
				thdriver.set(new ChromeDriver(chromeOptions));
				
				
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
