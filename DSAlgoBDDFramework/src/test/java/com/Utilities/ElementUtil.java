package com.Utilities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, long durationInSeconds) {
	
	WebElement webElement = null;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element "+element.toString() +" may not be visible. Exception is: "+e.getMessage());
		}		
		return webElement;
	}

public static WebElement waitForElementClickablity(WebDriver driver, WebElement element, long durationInSeconds) {
	
	WebElement webElement = null;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			LoggerLoad.error("waitForElementClickablity()::The element "+element.toString() +" may not be clickable. Exception is: "+e.getMessage());
		}		
		return webElement;
	}

public static void clickOnElement(WebDriver driver, WebElement element, long durationInSeconds) {
	
	WebElement webElement =null;
	try {
	webElement = waitForElementClickablity(driver, element, durationInSeconds);
	webElement.click();
	}catch(Exception e) {
	LoggerLoad.error("clickOnElement()::The element "+element.toString() +" not clicked.Exception is: "+e.getMessage());
    }
}

public static boolean isElementDisplayedStatus(WebDriver driver, WebElement element,long durationInSeconds) {
	WebElement webElement = null;
	boolean status = false;
	try {
		webElement = waitForElementVisibility(driver, element, durationInSeconds);
		status= webElement.isDisplayed();
	}catch(Exception e) {
		LoggerLoad.error("isElementDisplayedStatus()::The alert "+element.toString() +" may not be present. Exception is: "+e.getMessage());
	}	
		return status;
}
	
public static void typeInputIntoElement(WebDriver driver, WebElement element, String textToBeTyped, long durationInSeconds) {
	WebElement webElement = null;
	try {
    webElement = waitForElementClickablity(driver, element, durationInSeconds);
	webElement.clear();
	webElement.click();
	webElement.sendKeys(textToBeTyped);
	}catch(Exception e) {
		LoggerLoad.error("typeInputIntoElement()::Not able to send text in "+element.toString() +". Exception is: "+e.getMessage());
	}	
}
public static String getTextFromElement(WebDriver driver, WebElement element, long durationInSeconds) {
	
	WebElement webElement = null;
	try {
		 webElement = waitForElementVisibility(driver, element, durationInSeconds);
	}catch(Exception e) {
		LoggerLoad.error("getTextFromElement()::The element "+element.toString() +"is not visiable. Exception is: "+e.getMessage());
	}
	return webElement != null ? webElement.getText() : null;
	
}
public static void mouseOverElementandClick(WebDriver driver, WebElement element, long durationInSeconds) {
	
	WebElement webElement = waitForElementVisibility(driver, element, durationInSeconds);
	Actions action =new Actions(driver);
	action.moveToElement(webElement).click().build().perform();
	}

public static void selectDropDownOptionByVisibleText(WebDriver driver, WebElement element, String dropdownOption , long durationInSeconds) {
	
	WebElement webElement = waitForElementVisibility(driver, element, durationInSeconds);
	Select select = new Select(webElement);
	select.selectByVisibleText(dropdownOption);
}

public static Alert waitForAlert(WebDriver driver, long durationInSeconds) {
	Alert alert = null;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			LoggerLoad.error("waitForAlert()::The alert may not be present. Exception is: "+e.getMessage());
		}		
		return alert;
	}
	
public static void acceptAlert(WebDriver driver, long durationInSeconds) {
	
	Alert alert = null;
	try {
		alert= waitForAlert(driver, durationInSeconds);
		alert.accept();
	}catch(Exception e) {
		LoggerLoad.error("acceptAlert()::The alert may not be present. Exception is: "+e.getMessage());
	}	
}

public static void dismissAlert(WebDriver driver, long durationInSeconds) {
	
	Alert alert = null;
	try {
	 alert= waitForAlert(driver, durationInSeconds);
	 alert.dismiss();
	}catch(Exception e) {
		LoggerLoad.error("dismissAlert()::The alert may not be present. Exception is: "+e.getMessage());
	}
}

public void javaScriptClick(WebDriver driver,WebElement element,long durationInSeconds) {
	
	WebElement webElement=null;
	try {
    webElement = waitForElementVisibility(driver, element, durationInSeconds);
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].click();",webElement);
	}catch(Exception e) {
		LoggerLoad.error("javaScriptClick()::The element "+element.toString() +" may not be clickable. Exception is: "+e.getMessage());
	}	
}

public void javaScriptType(WebDriver driver, WebElement element,long durationInSeconds,String textToBeTyped) {
	
	WebElement webElement=null;
	try {
    webElement = waitForElementVisibility(driver, element, durationInSeconds);
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
	}catch(Exception e) {
		LoggerLoad.error("javaScriptType()::Not able to type text into "+element.toString() +". Exception is: "+e.getMessage());
	}	
}

}
