package com.Utilities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, long durationInSeconds) {
	//explicit wait
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
  public static void implicitPageWait(WebDriver driver) {	

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));//10sec

     }
	public static void waitForPageLoad(WebDriver driver) {
	
		String pageLoadStatus =null;
		do {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		pageLoadStatus = (String)js.executeScript("return document.readyState");

	    } while ( !pageLoadStatus.equals("complete") );

	          System.out.println("Page Loaded.");
	}

	public static void checkPageIsLoaded(WebDriver driver) {

		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded...");
		   return; 
		  } 
		  //This loop will rotate for 10 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			   System.out.println("Page Is loaded.");
		    break; 
		   }   
		  }
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

public static void pythonTextIndentation(WebDriver driver, WebElement pythonElement, int row, int space,boolean flag) {
		 
	   Actions action = new Actions(driver);	
	      for(int i=1;i<=row;i++) 
	      {
		      action.sendKeys(Keys.ARROW_UP).keyUp(Keys.SHIFT).perform();
		       for(int j=1;j<=space;j++) 
		       {
	            if(i==1 && flag)
	            	action.sendKeys(Keys.BACK_SPACE).perform();
	            
	            else action.sendKeys(Keys.DELETE).perform();
			   }
		}
	}



//TextIndentation(driver,pythonElement,3,6,true);	
//TextIndentation(driver,pythonElement,1,4,false);



public static Alert isAlertPresent(WebDriver driver, long durationInSeconds) {
	Alert alert = null;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			LoggerLoad.error("waitForAlert()::The alert may not be present. Exception is: "+e.getMessage());
		}		
		return alert;
	}
	
public static String getAlertText(WebDriver driver, long durationInSeconds) {
	Alert alert = null;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		
		}catch(Exception e) {
			LoggerLoad.error("waitForAlert()::The alert may not be present. Exception is: "+e.getMessage());
		}		
	return alert.getText();
	}
public static void acceptAlert(WebDriver driver, long durationInSeconds) {
	
	Alert alert = null;
	try {
		alert= isAlertPresent(driver, durationInSeconds);
		alert.accept();
	}catch(Exception e) {
		LoggerLoad.error("acceptAlert()::The alert may not be present. Exception is: "+e.getMessage());
	}	
}

public static void dismissAlert(WebDriver driver, long durationInSeconds) {
	
	Alert alert = null;
	try {
	 alert= isAlertPresent(driver, durationInSeconds);
	 alert.dismiss();
	}catch(Exception e) {
		LoggerLoad.error("dismissAlert()::The alert may not be present. Exception is: "+e.getMessage());
	}
}

public static void javaScriptClick(WebDriver driver,WebElement element,long durationInSeconds) {
	
	WebElement webElement=null;
	try {
    webElement = waitForElementVisibility(driver, element, durationInSeconds);
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].click();",webElement);
	}catch(Exception e) {
		LoggerLoad.error("javaScriptClick()::The element "+element.toString() +" may not be clickable. Exception is: "+e.getMessage());
	}	
}

public static void javaScriptScrollToElement(WebDriver driver,WebElement element,long durationInSeconds) {
	
	WebElement webElement=null;
	try {
    webElement = waitForElementVisibility(driver, element, durationInSeconds);
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true);",webElement);
	}catch(Exception e) {
		LoggerLoad.error("javaScriptScrollToElement()::The element "+element.toString() +" may not scrolled to element. Exception is: "+e.getMessage());
	}	
}

public static void javaScriptType(WebDriver driver, WebElement element,long durationInSeconds,String textToBeTyped) {
	
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
