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

public class StepDef_Stack {

	
	PicoDependencyInjector picoDepInj;

	public StepDef_Stack(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("user click on the stack menu {string} from drop down")
	public void user_click_the_stack_menu_from_drop_down(String DropDownMenuName) {
	   
		picoDepInj.homePage.clickOnGivenDSDropDownMenu(DropDownMenuName);
		LoggerLoad.info("user selected stack from drop down menu.");
	}

	
	@Then("user should redirect to Stack page")
	public void user_should_redirect_to_stack_page() {
		
		picoDepInj.stackPage = picoDepInj.homePage.verifyUserRedirectedToStackPage();
		String stackPageTitle = picoDepInj.stackPage.getStackPageTitle();
		LoggerLoad.info("stack Page title :--" + stackPageTitle);
		Assert.assertEquals(Constant.STACK_PAGE_TITLE, stackPageTitle);
	}

	@When("user click on Operations in Stack link")
	public void user_click_on_operations_in_stack_link() {
		
		picoDepInj.stackPage.clickOnOperationsInStackLink();
	}

	@Then("user should redirect to Operations in Stack page")
	public void user_should_redirect_to_operations_in_stack_page() {
	    
		String operationsInStackPageUrl = picoDepInj.stackPage.getOperationsInStackLinkPageUrl();
		LoggerLoad.info("User redirected to operations in stack Page :--" + operationsInStackPageUrl);
		Assert.assertTrue(operationsInStackPageUrl.contains("stack/operations-in-stack/"));
	}

	@When("user clicks on TryHere button for Stack flow")
	public void user_clicks_on_try_here_button_for_stack_flow() {
	    
		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.stackPage.clickOnTryHereBtn();
	}

	@Then("user should be redirect to the python editor for Stack flow")
	public void user_should_be_redirect_to_the_python_editor_for_stack_flow() {
	    
		String editorPageUrl =  picoDepInj.stackPage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
	}
	

	@When("user enters the invalid input {string} python editor for Stack flow")
	public void user_enters_the_invalid_input_python_editor_for_stack_flow(String invalidInput) {
	    
		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.stackPage.sendInvalidInputIntoPyEditor(invalidInput);//test123
	}

	@When("user click on RUN button for Stack flow")
	public void user_click_on_run_button_for_stack_flow() {
	    
		LoggerLoad.info("user clicking on run btn ");
		picoDepInj.stackPage.clickRunBtn();
	}

	@Then("an Alert with error Message for Stack flow will appears")
	public void an_alert_with_error_message_for_stack_flow_will_appears() {
	    
		Alert alert =   picoDepInj.stackPage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.stackPage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
	}

	@Then("user click on OK button for Stack flow alert")
	public void user_click_on_ok_button_for_stack_flow_alert() throws InterruptedException {
	    
		LoggerLoad.info("User accepting alert.");
		 picoDepInj.stackPage.acceptAlert();
	}

	@When("for Stack user enters valid python code from test sheet {string} and {int}")
	public void for_stack_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {
	    
		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");//hello
		picoDepInj.stackPage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}


	@Then("for Stack flow console should display result {string}")
	public void for_stack_flow_console_should_display_result(String ecpectedOutput) {
	    
		String actualOutput = picoDepInj.stackPage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@When("user click on Implementation link")
	public void user_click_on_implementation_link() {
		
		picoDepInj.stackPage.clickOnImplementationLink();
		
	}

	@Then("user should redirect to Implementation page")
	public void user_should_redirect_to_implementation_page() {
		
		String implementationPageUrl = picoDepInj.stackPage.getImplementationLinkPageUrl();
		LoggerLoad.info("User redirected to implementation Page :--" + implementationPageUrl);
		Assert.assertTrue(implementationPageUrl.contains("stack/implementation/"));
	}

	@When("user click on Applications link")
	public void user_click_on_applications_link() {
	    
		picoDepInj.stackPage.clickOnApplicationsLink();
	}

	@Then("user should redirect to Applications page")
	public void user_should_redirect_to_applications_page() {
	    
		String applicationsPageUrl = picoDepInj.stackPage.getApplicationsLinkPageUrl();
		LoggerLoad.info("User redirected to applications Page :--" + applicationsPageUrl);
		Assert.assertTrue(applicationsPageUrl.contains("/stack-applications/"));
	}

	
	
	
}
