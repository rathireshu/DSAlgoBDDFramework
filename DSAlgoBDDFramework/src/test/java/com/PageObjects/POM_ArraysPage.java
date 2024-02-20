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

public class POM_ArraysPage {

	WebDriver driver;

	public POM_ArraysPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement arraysInPythonLink;

	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement arraysUsingListLink;

	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOperationsInListsLink;

	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement applicationsOfArrayLink;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuestionsLink;
	
	@FindBy(xpath = "//a[text()='Search the array']")
	WebElement searchTheArrayLink;
	
	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement maxConsecutiveOnesLink;
	
	@FindBy(xpath = "//a[text()='Find Numbers with Even Number of Digits']")
	WebElement findNumWithEvenDigLink;
	
	@FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	WebElement squareOfSortedArrayLink;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereBtn;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement pyEditor_runBtn;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement pyEditor_SubmitBtn;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	WebElement pyEditor_textarea;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement pyEditor_output;

	public String getArraysPageTitle() {

		return driver.getTitle();
	}

	
	
	public void clickOnSearchTheArrayLink() {

		ElementUtil.clickOnElement(driver, searchTheArrayLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getSearchTheArrayPageUrl() {

		return driver.getCurrentUrl();
	}

	
	public void clickOnMaxConsOnesLink() {

		ElementUtil.clickOnElement(driver, maxConsecutiveOnesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getMaxConsOnesPageUrl() {

		return driver.getCurrentUrl();
	}

	
	public void clickOnFindNumWithEvenDigLink() {

		ElementUtil.clickOnElement(driver, findNumWithEvenDigLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getFindNumWithEvenDigPageUrl() {

		return driver.getCurrentUrl();
	}
	
	public void clickOnSquareOfSortedArrayLink() {

		ElementUtil.clickOnElement(driver, squareOfSortedArrayLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getSquareOfSortedArrayPageUrl() {

		return driver.getCurrentUrl();
	}
	
	public void clickOnArraysInPythonLink() {
		ElementUtil.javaScriptScrollToElement(driver, arraysInPythonLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, arraysInPythonLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//ElementUtil.clickOnElement(driver, arraysInPythonLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getArraysInPythonPageUrl() {

		return driver.getCurrentUrl();
	}

	public void clickOnArraysUsingListLink() {

		
		ElementUtil.javaScriptScrollToElement(driver, arraysUsingListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, arraysUsingListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//ElementUtil.clickOnElement(driver, arraysUsingListLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getArraysUsingListPageUrl() {

		return driver.getCurrentUrl();
	}

	public void clickOnBasicOperInListsLink() {

		ElementUtil.javaScriptScrollToElement(driver, basicOperationsInListsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, basicOperationsInListsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//ElementUtil.clickOnElement(driver, basicOperationsInListsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getBasicOperInListsPageUrl() {

		return driver.getCurrentUrl();
	}

	public void clickOnApplicationsOfArrayLink() {

		ElementUtil.javaScriptScrollToElement(driver, applicationsOfArrayLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, applicationsOfArrayLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//ElementUtil.clickOnElement(driver, applicationsOfArrayLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getApplicationsOfArrayPageUrl() {

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
		// practiceQuestnbtn.click();
		LoggerLoad.info("Practice Question link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickOnTryHereBtn() {

		tryHereBtn.click();
		LoggerLoad.info("Try Here btn clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickRunBtn() {

		pyEditor_runBtn.click();
		LoggerLoad.info("Run button clicked ...");
	}

	public void clickSubmitBtn() throws InterruptedException {

		pyEditor_SubmitBtn.click();
		LoggerLoad.info("Submit button clicked on practice question...");
		Thread.sleep(1000);
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
