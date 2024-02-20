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

public class POM_TreePage {

	WebDriver driver;

	public POM_TreePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//a[text()='Overview of Trees']")
	WebElement overviewOfTreesLink;	
	
	@FindBy(xpath = "//a[text()='Terminologies']")
	WebElement terminologiesLink;
	
	@FindBy(xpath = "//a[text()='Types of Trees']")
	WebElement typesOfTreesLink;	
	
	@FindBy(xpath = "//a[text()='Tree Traversals']")
	WebElement treeTraversalsLink;	
	
	@FindBy(xpath = "//a[text()='Traversals-Illustration']")
	WebElement traversalsIllustrationLink;	
	
	@FindBy(xpath = "//a[text()='Binary Trees']")
	WebElement binaryTreesLink;	
	
	@FindBy(xpath = "//a[text()='Types of Binary Trees']")
	WebElement typesOfBinaryTreesLink;
	
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

	public String getTreePageTitle() {

		return driver.getTitle();
	}

	public void clickOnOverviewOfTreesLink() {

		ElementUtil.javaScriptScrollToElement(driver, overviewOfTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, overviewOfTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Overview Of Trees link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}

	public void clickOnTerminologiesLink() {

		ElementUtil.javaScriptScrollToElement(driver, terminologiesLink,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, terminologiesLink,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Terminologies link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnTypeOfTreesLink() {

		ElementUtil.javaScriptScrollToElement(driver, typesOfTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, typesOfTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("types Of Trees link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnTreeTraversalsLink() {

		ElementUtil.javaScriptScrollToElement(driver, treeTraversalsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, treeTraversalsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Tree Traversals Link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnTraversalsIllustrationLink() {

		ElementUtil.javaScriptScrollToElement(driver, traversalsIllustrationLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, traversalsIllustrationLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("traversals-Illustration Link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnBinaryTreesLink() {

		ElementUtil.javaScriptScrollToElement(driver, binaryTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, binaryTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Binary Trees Link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnTypesOfBinaryTreesLink() {

		ElementUtil.javaScriptScrollToElement(driver, typesOfBinaryTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, typesOfBinaryTreesLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Types Of Binary Trees Link clicked ...");
		ElementUtil.waitForPageLoad(driver);

	}
	
	public void clickOnPracticeQuestionsLink() {

		ElementUtil.clickOnElement(driver, practiceQuestionsLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Practice Questions link clicked on tree page...");
		ElementUtil.waitForPageLoad(driver);

	}

	public String getPracticeQuestionsPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getOverviewOfTreesPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getTerminologiesPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
	public String getTypeOfTreesPageUrl() {

		return driver.getCurrentUrl();
	}
	
	public String getTreeTraversalsPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
	public String getTraversalsIllustrationPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
	public String getBinaryTreesPageUrl() {

		return driver.getCurrentUrl();
	}
	
	
	public String getTypesOfBinaryTreesPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getPyEditorPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getValidOutputText() {

		return pyEditor_output.getText();
	}

	public void clickOnTryHereBtn() {

		ElementUtil.javaScriptScrollToElement(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, tryHereBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
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
