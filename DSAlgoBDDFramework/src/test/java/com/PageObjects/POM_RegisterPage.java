package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POM_RegisterPage {

	
	private WebDriver driver ;
	
	POM_RegisterPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	public String getRegisterPageTittle() {
		
		return driver.getTitle();
		
	}
	
	
}
