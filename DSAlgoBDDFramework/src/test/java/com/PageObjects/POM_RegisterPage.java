package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementUtil;
import com.Utilities.LoggerLoad;

public class POM_RegisterPage {

	
	private WebDriver driver ;
	
	POM_RegisterPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(id = "id_username")
	WebElement registerPage_Username;
	
	@FindBy(id = "id_password1")
	WebElement registerPage_Password;
	
	@FindBy(id = "id_password2")
	WebElement registerPage_PasswordConfirmation;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerPage_RegisterBtn;
	
	@FindBy(xpath = "//a[text()='Login ']")
	WebElement registerPage_LoginBtn;
	
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement registerPage_pwdMismatchError;
	
	@FindBy(xpath = "//div[@class='navbar-nav']/ul/a[2]")
	WebElement registerUsernameLink;
	
	
	
	
	public String getRegisterPageTitle() {
		
		return driver.getTitle();
	}
	
   public void enterUserName(String usernameValue) {
		
		 ElementUtil.typeInputIntoElement(driver, registerPage_Username, usernameValue, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
   public void enterPassword(String passwordValue) {
		
		 ElementUtil.typeInputIntoElement(driver, registerPage_Password,passwordValue, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
   
   public void enterPasswordConfirmation(String passwordConfValue) {
		
		 ElementUtil.typeInputIntoElement(driver, registerPage_PasswordConfirmation, passwordConfValue, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	
	public void clickOnRegisterBtn() {
		
		ElementUtil.clickOnElement(driver, registerPage_RegisterBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
   public String getRegisteredUserName() {
		
		return registerUsernameLink.getText();
	}
	
	public String getPopUpTextOnBlankField()
	{
		
		String isRequiredAttPresent = registerPage_Username.getAttribute("required");
	    LoggerLoad.info("Is required attribute present on element :--"+isRequiredAttPresent);		    
		String blankFieldPopUpText = registerPage_Username.getAttribute("validationMessage");
		return blankFieldPopUpText;
	}
	
   public String getPwdMismatchErrorText() {
	
		return ElementUtil.getTextFromElement(driver, registerPage_pwdMismatchError, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
  public POM_HomePage verifyUserRedirectedToHomePage() {
	
	  return new POM_HomePage(driver);
		
	}
	
}
