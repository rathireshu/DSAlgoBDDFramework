package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
		         features = "src/test/resources/Features/9_LinkedList.feature", 
                 glue = {"com.StepDefinition", "com.ApplicationHooks" }, 
                 monochrome = true, 
		         dryRun = false, 
		         plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		        		 }
				)
public class TestRunner extends AbstractTestNGCucumberTests {

}
