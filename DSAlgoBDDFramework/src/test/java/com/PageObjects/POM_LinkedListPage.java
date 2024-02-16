package com.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.Constant;
import com.Utilities.ElementUtil;
import com.Utilities.LoggerLoad;

public class POM_LinkedListPage {

	
	
	WebDriver driver;

	public POM_LinkedListPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Introduction']")
	WebElement introductionLink;

	@FindBy(xpath = "//a[text()='Creating Linked LIst']")
	WebElement creatingLinkedListLink;

	@FindBy(xpath = "//a[text()='Types of Linked List']")
	WebElement typesOfLinkedListLink;

	@FindBy(xpath = "//a[text()='Implement Linked List in Python']")
	WebElement implementLinkedListInPythonLink;
	
	@FindBy(xpath = "//a[text()='Traversal']")
	WebElement traversalLink;

	@FindBy(xpath = "//a[text()='Insertion']")
	WebElement insertionLink;

	@FindBy(xpath = "//a[text()='Deletion']")
	WebElement deletionLink;	
	
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuestionsLink;
	
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereBtn;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement pyEditor_runBtn;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	WebElement pyEditor_textarea;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement pyEditor_output;

	
	
	public String getLinkedListPageTitle() {

		return driver.getTitle();
	}


   public void clickOnIntroductionLink()  {
		
		ElementUtil.javaScriptScrollToElement(driver, introductionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, introductionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getIntroductionPageUrl() {

		return driver.getCurrentUrl();
	}
	
   public void clickOnCreatingLinkedListLink() {
		
		ElementUtil.javaScriptScrollToElement(driver, creatingLinkedListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, creatingLinkedListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getCreatingLinkedListPageUrl() {

		return driver.getCurrentUrl();
	}
	
   public void clickOnTypesOfLinkedListLink() {
		
		ElementUtil.javaScriptScrollToElement(driver, typesOfLinkedListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, typesOfLinkedListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getTypesOfLinkedListPageUrl() {

		return driver.getCurrentUrl();
	}
	
    public void clickOnImplementLinkedListInPythonLink() {
		
		ElementUtil.javaScriptScrollToElement(driver, implementLinkedListInPythonLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, implementLinkedListInPythonLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getImplementLinkedListInPythonPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
   public void clickOnTraversalLink() {
		
		ElementUtil.javaScriptScrollToElement(driver, traversalLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, traversalLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getTraversalPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
   public void clickOnInsertionLink() {
		
		ElementUtil.javaScriptScrollToElement(driver, insertionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, insertionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}	

	public String getInsertionPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
	 public void clickOnDeletionLink() {
			
			ElementUtil.javaScriptScrollToElement(driver, deletionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.javaScriptClick(driver, deletionLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.waitForElementVisibility(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}	

		public String getDeletionPageUrl() {

			return driver.getCurrentUrl();
		}
		
		
	public String getPracticeQuestionsPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getPyEditorPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getValidOutputText() {

		return pyEditor_output.getText();
	}

	public void clickPracticeQuestion() {

		ElementUtil.javaScriptScrollToElement(driver, practiceQuestionsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, practiceQuestionsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Practice Question link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickOnTryHereBtn() {

		//tryHereBtn.click();
		ElementUtil.javaScriptScrollToElement(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);		
		LoggerLoad.info("Try Here btn clicked ...");
		ElementUtil.waitForPageLoad(driver);
		ElementUtil.waitForElementVisibility(driver, pyEditor_runBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public void clickRunBtn() {

		pyEditor_runBtn.click();
		LoggerLoad.info("Run button clicked ...");
	}

	
	public void sendValidInputIntoPyEditor(String input) {

		pyEditor_textarea.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				
		String[] lines = input.split("\n");
		for (String line : lines) {

			if (line.equals("\\b")) {
				pyEditor_textarea.sendKeys(Keys.BACK_SPACE);
			} else {
				pyEditor_textarea.sendKeys(line);
				pyEditor_textarea.sendKeys(Keys.ENTER);
			}
		}

	}

	public void sendInvalidInputIntoPyEditor(String input) {
		
		LoggerLoad.info("User enerting invalid input in practice editor");
		
		pyEditor_textarea.sendKeys(input);
	}

	public Alert isAlertPresent() {

		Alert alert = driver.switchTo().alert();
		return alert;

	}

	public String alertErrorMsgText() {

		return ElementUtil.getAlertText(driver, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public void acceptAlert() throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		//Thread.sleep(1000);
		alert.accept();
	}


}
