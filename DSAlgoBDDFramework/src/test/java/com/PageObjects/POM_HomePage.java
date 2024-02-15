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

	@FindBy(xpath = "//a[text()='Graph']")
	WebElement graphDDMenu;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a")
	List<WebElement> dataStrDDList;

	@FindBy(xpath = "//a[text()='Get Started']")
	List<WebElement> getStartedBtnsList;

	@FindBy (xpath ="//h5[text()='Graph']/..//a[text()='Get Started']")
	WebElement getStartedGraphBtn;
	
	@FindBy (xpath ="//h5[text()='Queue']/..//a[text()='Get Started']")
	WebElement getStartedQueueBtn;
	
	@FindBy (xpath ="//h5[text()='Data Structures-Introduction']/..//a[text()='Get Started']")
	WebElement getStartedDataStrIntoBtn;
	
	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement registerBtn;

	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='navbar-nav']/ul/a[2]")
	WebElement loggedInUserNameLink;
	
	
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signOutBtn;

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
		return getStartedBtnsList.get(0).isEnabled();
	}

	public int verifyGetStartedBtnsCount() {
		return getStartedBtnsList.size();
	}

	public void clickOnGetStartedBtn() {
		getStartedBtnsList.get(0).click();
	}

	public int verifyNotSignInMsgNotPresent() {

		return notSignInMsglist.size();

	}

	public void clickOnSignInBtn() {
		
		ElementUtil.clickOnElement(driver, signInBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public POM_SignInPage verifyUserRedirectedToSignInPage() {
		
		   //when ever user redirected to new page that method shld return new page object.	   
		   return new POM_SignInPage(driver);//this driver has a reference home page driver
		}
	
	public void clickOnSignOutBtn() {
		
		ElementUtil.clickOnElement(driver, signOutBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	
	public boolean verifyloggedInUserNameLinkPresent() {
		
		return loggedInUserNameLink.isDisplayed();
			
	}
	
    public String getloggedInUserNameLinkText() {
		
		return ElementUtil.getTextFromElement(driver, loggedInUserNameLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
	}
	
	public String getTextLoginSuccessMsg() {
		return homePage_alertMsg.getText();
	}
	
	public String getTextSignOutSuccessMsg() {
		return homePage_alertMsg.getText();
	}
	
	 
   public void clickOnRegisterBtn() {
	   
	   ElementUtil.clickOnElement(driver, registerBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
  public POM_RegisterPage verifyUserRedirectedToRegisterPage() {
		
	  return new POM_RegisterPage(driver);
		
	}
  
  public void clickOnGraphGetStartedBtn() {
		
		 ElementUtil.clickOnElement(driver, getStartedGraphBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
  public void clickOnDataStrIntoGetStartedBtn() {
		
		 ElementUtil.clickOnElement(driver, getStartedDataStrIntoBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
  
  public void clickOnGraphDropDownMenu() {
		
	  graphDDMenu.click();
		
	}

  public void clickOnQueueGetStartedBtn() {
		
		 ElementUtil.clickOnElement(driver, getStartedQueueBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	
  }
  
  public void clickOnGivenDSDropDownMenu(String menuName) {
	  
	for(WebElement menuItem : dataStrDDList){
		  
		if(menuItem.getText().equals(menuName)){
			 ElementUtil.clickOnElement(driver, menuItem, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			 ElementUtil.waitForPageLoad(driver);
			break;
	     }
	}  
}
  public POM_GraphPage verifyUserRedirectedToGraphPage() {
		
  	  return new POM_GraphPage(driver);
  		
  	}
	
  public POM_QueuePage verifyUserRedirectedToQueuePage() {
		
  	  return new POM_QueuePage(driver);
  		
  	}
  
  public POM_DataStrucIntroPage verifyUserRedirectedToDataStrIntroPage() {
		
  	  return new POM_DataStrucIntroPage (driver);
  		
  	}
  
  public POM_StackPage verifyUserRedirectedToStackPage() {
		
  	  return new POM_StackPage (driver);
  		
  	}
	
  public POM_ArraysPage verifyUserRedirectedToArraysPage() {
		
  	  return new POM_ArraysPage (driver);
  		
  	}
	
  
  public POM_LinkedListPage verifyUserRedirectedToLinkedListPage() {
		
  	  return new POM_LinkedListPage (driver);
  		
  	}
	
  
  public POM_TreePage verifyUserRedirectedToTreePage() {
		
  	  return new POM_TreePage (driver);
  		
  	}
}
