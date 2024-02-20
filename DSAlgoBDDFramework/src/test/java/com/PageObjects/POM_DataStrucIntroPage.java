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

public class POM_DataStrucIntroPage {

	
	WebDriver driver;

	public POM_DataStrucIntroPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuestionsLink;
	
	@FindBy(xpath = "//a[text()='Time Complexity']")
	WebElement timeComplexityLink;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereBtn;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement pyEditor_runBtn;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	WebElement pyEditor_textarea;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement pyEditor_output;

	public String getDataStrucIntroPageTitle() {

		return driver.getTitle();
	}

	
	 public void clickOnTimeComplexityLink() {
			
		 ElementUtil.clickOnElement(driver, timeComplexityLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	 public String getTimeComplexityPageUrl() {

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
			//practiceQuestnbtn.click();
			LoggerLoad.info("Practice Question link clicked ...");
			ElementUtil.waitForPageLoad(driver);

		}
		
		public void clickOnTryHereBtn() {

			tryHereBtn.click();
			LoggerLoad.info("Try Here btn clicked ...");
			ElementUtil.waitForPageLoad(driver);

	}

		public void clickRunBtn () {

			pyEditor_runBtn.click();
			LoggerLoad.info("Run button clicked ...");
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
