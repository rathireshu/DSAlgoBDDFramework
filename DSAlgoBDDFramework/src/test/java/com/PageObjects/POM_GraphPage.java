package com.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.Constant;
import com.Utilities.ElementUtil;
import com.Utilities.LoggerLoad;
import org.openqa.selenium.Keys;

public class POM_GraphPage {

	WebDriver driver;

	public POM_GraphPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@class='list-group-item'])[1]")
	WebElement graphPage_graphLinkOption;

	@FindBy(xpath = "//a[text()='Graph Representations']")
	WebElement graphPage_graphRepresentationsLinkOption;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement graphPage_practiceQuestionsLink;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement graphPage_tryHereBtn;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement pyEditor_runBtn;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	WebElement pyEditor_textarea;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement pyEditor_output;

	public String getGraphPageTitle() {

		return driver.getTitle();
	}

	public void clickOnGraphLink() {

		ElementUtil.javaScriptScrollToElement(driver, graphPage_graphLinkOption, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, graphPage_graphLinkOption, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Graph link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickOnGraphRepresLink() {

		ElementUtil.javaScriptScrollToElement(driver, graphPage_graphRepresentationsLinkOption,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, graphPage_graphRepresentationsLinkOption,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Graph Representations link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickOnPracticeQuestionsLink() {

		ElementUtil.clickOnElement(driver, graphPage_practiceQuestionsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Practice Questions link clicked on graph Representations page...");
		ElementUtil.waitForPageLoad(driver);

	}

	public String getPracticeQuestionsPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getGraphOptionPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getGraphReprPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getPyEditorPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getValidOutputText() {

		return pyEditor_output.getText();
	}

	public void clickOnTryHereBtn() {

		ElementUtil.javaScriptScrollToElement(driver, graphPage_tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, graphPage_tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("TryHere button clicked ...");
	}

	public boolean verifyPythonEditorPageUI() {

		return pyEditor_runBtn.isDisplayed();

	}

	public void sendValidInputIntoPyEditor(String input) {
		
		String[] lines = input.split("\n");
		for (String line : lines)
		{

			if (line.equals("\\b")) 
			{
				pyEditor_textarea.sendKeys(Keys.BACK_SPACE);
			} else {
				pyEditor_textarea.sendKeys(line);
				pyEditor_textarea.sendKeys(Keys.ENTER);
			}
		}

	}

	public void sendInvalidInputIntoPyEditor(String input) {

		pyEditor_textarea.sendKeys(input);
	}

	public void clickRunBtn() throws InterruptedException {

		pyEditor_runBtn.click();
		//Thread.sleep(3000);
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
		LoggerLoad.info("Alert accepted by user ...");
	
	}

}
