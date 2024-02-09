package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
		         features = "src/test/resources/Features/", 
                 glue = {"com.StepDefinition", "com.ApplicationHooks" }, 
                 monochrome = true, 
		         dryRun = false, 
		         plugin = { "pretty", 
		        		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        		 }
				)
public class TestRunner extends AbstractTestNGCucumberTests {

}
