package com.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementUtil;

public class POM_HomePage {

	private WebDriver driver;

//1.constructor
	public POM_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//2.locator

	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dataStructureDD;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a")
	List<WebElement> dataStrDDList;

	@FindBy(xpath = "//a[text()='Get Started']")
	List<WebElement> getStartedBtns;

	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement registerBtn;

	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signInBtn;	

	@FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
	List<WebElement> notSignInMsglist; //to check its visibility on page we need to use list as this ele is not in DOM
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement homePage_alertMsg;
	
	
	
//3.action methods for page i.e feature of the page

	public String getHomePageTitle() {
		return driver.getTitle();// NumpyNinja
	}

	public boolean verifyDataStructureDDPresent() {
		return ElementUtil.isElementDisplayedStatus(driver, dataStructureDD, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public void clickDataStructureDD() {
		ElementUtil.clickOnElement(driver, dataStructureDD, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public int verifyDataStrDDListCount() {
		return dataStrDDList.size();
	}

	public boolean verifyRegisterBtnPresent() {
		
		return ElementUtil.isElementDisplayedStatus(driver, registerBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public boolean verifySignInBtnPresent() {
		return signInBtn.isDisplayed();
	}

	public boolean verifySignInBtnEnable() {
		return signInBtn.isEnabled();
	}

	public boolean verifyRegisterBtnEnable() {
		return signInBtn.isEnabled();
	}

	public boolean verifyGetStartedBtnEnable() {
		return getStartedBtns.get(0).isEnabled();
	}

	public int verifyGetStartedBtnsCount() {
		return getStartedBtns.size();
	}

	public void clickOnGetStartedBtn() {
		getStartedBtns.get(0).click();
	}

	public int verifyNotSignInMsgNotPresent() {

		return notSignInMsglist.size();

	}

	public void clickOnSignInBtn() {
		ElementUtil.clickOnElement(driver, signInBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public String getTextLoginSuccessMsg() {
		return homePage_alertMsg.getText();
	}
	
   public POM_SignInPage verifyUserRedirectedToSignInPage() {
	
	   //when ever user redirected to new page that method shld return new page object.	   
	   return new POM_SignInPage(driver);//this driver has a reference home page driver
	}
	 
   public void clickOnRegisterBtn() {
	   
	   ElementUtil.clickOnElement(driver, registerBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
  public POM_RegisterPage verifyUserRedirectedToRegisterPage() {
		
	  return new POM_RegisterPage(driver);
		
	}
	
	
	
	
}
