package com.DriverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
				ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("headless");
	            chromeOptions.addArguments("window-size=1366,768");          
	           	thdriver.set(new ChromeDriver(chromeOptions));
								
			} else if (browser.equalsIgnoreCase("firefox")) {
				LoggerLoad.info("Initializing Firefox Browser in headless mode....");
				FirefoxOptions firefoxOptions=new FirefoxOptions();
				firefoxOptions.addArguments("headless");
				firefoxOptions.addArguments("window-size=1366,768"); 
				thdriver.set(new FirefoxDriver(firefoxOptions));
			} else if (browser.equals("edge")) {
				LoggerLoad.info("Initializing edge Browser in headless mode....");
				
				EdgeOptions edgeOptions=new EdgeOptions();
				edgeOptions.addArguments("--headless");
				edgeOptions.addArguments("window-size=1366,768");
				thdriver.set(new EdgeDriver(edgeOptions));
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
