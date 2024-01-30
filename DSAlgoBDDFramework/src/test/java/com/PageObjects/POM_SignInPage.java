package com.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementUtil;

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
		
		@FindBy(xpath = "//*[contains(text(),'Please fill out this field.')]")
		List<WebElement> signInPage_emptyFeildErrorMsg;
		
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
		
		public int verifyBlankFeildErrorMsgSize() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
			
			return signInPage_emptyFeildErrorMsg.size();
			
		}
		public String getInvalidLoginErrorMsgText() {
			
			String alerText= ElementUtil.getTextFromElement(driver, signInPage_alertMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			return alerText;
			
		}
	
}
