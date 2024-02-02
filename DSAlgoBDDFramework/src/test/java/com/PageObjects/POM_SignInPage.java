package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.Constant;
import com.Utilities.ElementUtil;
import com.Utilities.LoggerLoad;

public class POM_SignInPage {

	private WebDriver driver ;
	
	POM_SignInPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(name = "username")
		WebElement signInPage_username;
		@FindBy(name = "password")
		WebElement signInPage_password;
		@FindBy(xpath = "//input[@value='Login']")
		WebElement signInPage_loginBtn;	
		
		@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
		WebElement signInPage_invalidErrMsg;
		
		@FindBy(xpath = "//a[text()='Register!']")
		WebElement signInPage_registerLink;
		
		@FindBy(xpath = "//div[@class='alert alert-primary']")
		WebElement signInPage_alertMsg;
	
		public String getSignInPageTitle() {
			return driver.getTitle();
		}
		
		public void enterValidCredentials(String validUserName,String validPwd) {
			ElementUtil.typeInputIntoElement(driver, signInPage_username, validUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
			ElementUtil.typeInputIntoElement(driver, signInPage_password, validPwd, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
		}
		
		public void clickOnLoginBtn() {
			 ElementUtil.clickOnElement(driver, signInPage_loginBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			 
		}
		
		public POM_HomePage verifyUserRedirectedToHomePage() {
			
			   //when ever user redirected to new page that method shld return new page object.	   
			   POM_HomePage  homePage = new POM_HomePage(driver);//this driver has a reference home page driver
		      return homePage;
			}
		
		public  String getPopUpTextOnBlankField() {
			
		    String isRequiredAttPresent = signInPage_username.getAttribute("required");
		    LoggerLoad.info("Is required attribute present on element :--"+isRequiredAttPresent);		    
			String blankFieldPopUpText = signInPage_username.getAttribute("validationMessage");
			return blankFieldPopUpText;
		}
		public String getInvalidLoginErrorMsgText() {
			
			String alerText= ElementUtil.getTextFromElement(driver, signInPage_alertMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			return alerText;
		}
		public void clickOnRegisterLink() {
			 ElementUtil.clickOnElement(driver, signInPage_registerLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		
		public POM_RegisterPage verifyUserRedirectedToRegisterPage() {
			
			   //when ever user redirected to new page that method shld return new page object.	   
			   return new POM_RegisterPage(driver);//this driver has a reference home page driver
		      
			}
}
