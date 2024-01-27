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
	private Properties prop;

	@Before
	public void setUp() {
		prop = ConfigReader.getProperties();
		String browseName = prop.getProperty("browser");
		dFactory = new DriverFactory();
		driver = dFactory.initializeDriver(browseName);
		driver.get(prop.getProperty("url"));
				
	}

	@After
	public void tearDown() {
		if(driver!=null)
		driver.quit();
	}
}
