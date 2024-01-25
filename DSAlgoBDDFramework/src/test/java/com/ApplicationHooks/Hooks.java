package com.ApplicationHooks;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.DriverFactory.DriverFactory;
import com.Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	// these variables are private as they are specific to this class only

	private WebDriver driver;
	private DriverFactory dFactory;
	Properties pro;

	@Before
	public void openBrowser() {
		pro = ConfigReader.getProperties();
		String browseName = pro.getProperty("browser");
		dFactory = new DriverFactory();
		driver = dFactory.initializeDriver(browseName);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
