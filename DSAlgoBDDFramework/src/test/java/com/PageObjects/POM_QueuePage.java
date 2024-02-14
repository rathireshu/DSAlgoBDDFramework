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

public class POM_QueuePage {

	
	
	WebDriver driver;

	public POM_QueuePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	WebElement dropdown;
	
	@FindBy(xpath = "(//a[contains(text(),'Queue')]")
	WebElement queueButton;
	
	@FindBy(xpath = "//a[contains(text(),'Implementation of Queue in Python')]")
	WebElement pythonQueueImplmentation;
	
	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryHerebtn;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement runBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Implementation using collections.deque')]")
	WebElement dequeImplmentation;
	
	@FindBy(xpath = "//a[contains(text(),'Implementation using array')]")
	WebElement arrayImplmentation;
	
	@FindBy(xpath = "//a[contains(text(),'Queue Operations')]")
	WebElement queueOperation;
	
	@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
	WebElement practiceQuestnbtn;
	
	@FindBy(xpath = "//pre[@id='output']")
	WebElement pyEditor_output;

	@FindBy(xpath = "//*[@id='answer_form']/div/div/div[1]/textarea")
	WebElement pyEditor_textarea;
	
	public String getQueuePageTitle() {
		return driver.getTitle();
	}
	
		
	public void clickOnPythonQueueImplementation() {

		
		ElementUtil.javaScriptScrollToElement(driver, pythonQueueImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.javaScriptClick(driver, pythonQueueImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//pythonQueueImplmentation.click();
		LoggerLoad.info("Queue Implementation in python link clicked ...");
		ElementUtil.waitForPageLoad(driver);

		
	}

		public void clickOnTryHereBtn() {

			tryHerebtn.click();
			LoggerLoad.info("Try Here btn clicked ...");
			ElementUtil.waitForPageLoad(driver);

	}

		public void clickRunBtn () {

			runBtn.click();
	}

		public void clickDeQueueImplementation() {

			ElementUtil.javaScriptScrollToElement(driver, dequeImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.javaScriptClick(driver, dequeImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//dequeImplmentation.click();
			LoggerLoad.info("Dequeue Implementation link clicked ...");
			ElementUtil.waitForPageLoad(driver);

	}

		public void clickArrayImplementation() {

			
			ElementUtil.javaScriptScrollToElement(driver, arrayImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.javaScriptClick(driver, arrayImplmentation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//arrayImplmentation.click();
			LoggerLoad.info("Array Implementation link clicked ...");
			ElementUtil.waitForPageLoad(driver);

	}


		public void clickQueueOperation() {

			ElementUtil.javaScriptScrollToElement(driver, queueOperation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.javaScriptClick(driver, queueOperation, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//queueOperation.click();
			LoggerLoad.info("Queue Operation link clicked ...");
			ElementUtil.waitForPageLoad(driver);

		}

		public void clickPracticeQuestion() {

			ElementUtil.javaScriptScrollToElement(driver, practiceQuestnbtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.javaScriptClick(driver, practiceQuestnbtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//practiceQuestnbtn.click();
			LoggerLoad.info("Practice Question link clicked ...");
			ElementUtil.waitForPageLoad(driver);

		}

		public String getPracticeQuestionsPageUrl() {

			return driver.getCurrentUrl();
		}

		public String getQueueImplementationPageUrl() {

			return driver.getCurrentUrl();
		}

		public String getDeQueueImplementationPageUrl() {

			return driver.getCurrentUrl();
		}
		
		public String getArrayImplementationPageUrl() {

			return driver.getCurrentUrl();
		}

		public String getQueueOperationPageUrl() {

			return driver.getCurrentUrl();
		}

		public String getPyEditorPageUrl() {

			return driver.getCurrentUrl();
		}

		public String getValidOutputText() {

			return pyEditor_output.getText();
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
