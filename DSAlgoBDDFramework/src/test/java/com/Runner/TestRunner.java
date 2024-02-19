package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
		         features = "src/test/resources/Features", 
                 glue = {"com.StepDefinition", "com.ApplicationHooks" }, 
                 monochrome = true, 
		         dryRun = false, 
		         plugin = { "pretty","html:cucumber-report/htmlReport.html", "json:cucumber-report/jsonReport.json",
		        		    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        		    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		        		 }
				)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	  @Override	 
	  @DataProvider(parallel = true) 
	  public Object[][] scenarios() 
	     {
		  return super.scenarios(); 
		  }
	 
}
