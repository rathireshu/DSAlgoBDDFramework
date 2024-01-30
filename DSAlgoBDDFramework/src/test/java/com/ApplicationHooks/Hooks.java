package com.ApplicationHooks;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.DriverFactory.DriverFactory;
import com.Utilities.ConfigReader;
import com.Utilities.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	// these variables are private as they are specific to this class only

	private WebDriver driver;
	private DriverFactory dFactory;
	private Properties prop;

	@Before
	public void setUp() {
		//Get Browser type from config file
		prop = ConfigReader.getProperties();
		String browseName = prop.getProperty("browser");
		
		//Initialize driver from driver factory class
		dFactory = new DriverFactory();
		driver = dFactory.initializeDriver(browseName);
		LoggerLoad.info("Initializing driver for browser :"+browseName);
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		LoggerLoad.info("Closing driver...");
		if(driver!=null)
		driver.quit();
	}
}
