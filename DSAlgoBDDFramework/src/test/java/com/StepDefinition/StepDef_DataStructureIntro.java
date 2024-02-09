package com.StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import com.Utilities.PicoDependencyInjector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_DataStructureIntro {

	
	PicoDependencyInjector picoDepInj;

	public StepDef_DataStructureIntro(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("user click on Data Structures-Introduction GetStarted button")
	public void user_click_on_data_structures_introduction_get_started_button() {
	    
		picoDepInj.homePage.clickOnDataStrIntoGetStartedBtn();
	}

	@Then("user should be redirected to Data Structures-Introduction home page.")
	public void user_should_be_redirected_to_data_structures_introduction_home_page() {
	    
		picoDepInj.dataStrIntroPage = picoDepInj.homePage.verifyUserRedirectedToDataStrIntroPage();
		String dataStrIntroPageTitle = picoDepInj.dataStrIntroPage.getDataStrucIntroPageTitle();
		LoggerLoad.info("Queue Page title :--" + dataStrIntroPageTitle);
		Assert.assertEquals(Constant.DATA_STRUCTURES_INTRO_PAGE_TITLE, dataStrIntroPageTitle);
	}

	@When("user clicks on Time Complexity link on Data Structures-Introduction home page")
	public void user_clicks_on_time_complexity_link_on_data_structures_introduction_home_page() {
		
		picoDepInj.dataStrIntroPage.clickOnTimeComplexityLink();
		
	}

	@Then("user should be redirected to Time Complexity option page.")
	public void user_should_be_redirected_to_time_complexity_option_page() {
	    
		String timeComplexityPageUrl = picoDepInj.dataStrIntroPage.getTimeComplexityPageUrl();
		LoggerLoad.info("User redirected to queue Implementation Page :--" + timeComplexityPageUrl);
		Assert.assertTrue(timeComplexityPageUrl.contains("/time-complexity/"));
		
	}

	@When("user clicks on TryHere button from Time Complexity page")
	public void user_clicks_on_try_here_button_from_time_complexity_page() {
		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.dataStrIntroPage.clickOnTryHereBtn();
	}

	@Then("user should be redirected to python Editor page from Time Complexity page")
	public void user_should_be_redirected_to_python_editor_page_from_time_complexity_page() {
	    
		String editorPageUrl =  picoDepInj.dataStrIntroPage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
		
	}

	@When("user enters the invalid input {string} in Time Complexity editor")
	public void user_enters_the_invalid_input_in_time_complexity_editor(String invalidInput) {
	    
		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.dataStrIntroPage.sendInvalidInputIntoPyEditor(invalidInput);
	}

	@When("user click on RUN button for Time Complexity")
	public void user_click_on_run_button_for_time_complexity() {
		
		picoDepInj.dataStrIntroPage.clickRunBtn();
	}

	@Then("an Alert with error Message for Time Complexity will appears")
	public void an_alert_with_error_message_for_time_complexity_will_appears() {
	    
		Alert alert =   picoDepInj.dataStrIntroPage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.dataStrIntroPage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("SyntaxError: bad input on line 1"));
	
	}

	@Then("user click on OK button for Time Complexity alert")
	public void user_click_on_ok_button_for_time_complexity_alert() throws InterruptedException {
	    
		LoggerLoad.info("User accepting alert.");
		picoDepInj.dataStrIntroPage.acceptAlert();
	}

	@When("for Time Complexity user enters valid python code from test sheet {string} and {int}")
	public void for_time_complexity_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {
	    
		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");//hello
		picoDepInj.dataStrIntroPage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}

	@Then("for Time Complexity flow console should display result {string}")
	public void for_time_complexity_flow_console_should_display_result(String ecpectedOutput) {
	    
		String actualOutput = picoDepInj.dataStrIntroPage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}


}
