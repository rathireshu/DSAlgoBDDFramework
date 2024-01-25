package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
		         features = "src/test/resources/com.features/1_Home.feature", 
                 glue = {"com.StepDefinition", "com.ApplicationHooks" }, 
                 monochrome = true, 
		         dryRun = false, 
		         plugin = { "pretty", "html:target/dsalgoReport.html" }
				)

public class TestRunner extends AbstractTestNGCucumberTests {

}
