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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Queue {

	
	PicoDependencyInjector picoDepInj;

	public StepDef_Queue(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("user navigate to data-structures dropdown")
	public void user_navigate_to_data_structures_dropdown() {
	    
		picoDepInj.homePage.clickDataStructureDD();
		
	}
	
	@When("user click the queue menu {string} from drop down")
	public void user_click_the_queue_menu_from_drop_down(String DropDownMenuName) {
	   
		picoDepInj.homePage.clickOnGivenDSDropDownMenu(DropDownMenuName);
		LoggerLoad.info("user selected queue from drop down menu.");
	}

	@Then("user should redirect to Queue page")
	public void user_should_redirect_to_queue_page() {
	    
		picoDepInj.queuePage = picoDepInj.homePage.verifyUserRedirectedToQueuePage();
		String queuePageTitle = picoDepInj.queuePage.getQueuePageTitle();
		LoggerLoad.info("Queue Page title :--" + queuePageTitle);
		Assert.assertEquals(Constant.QUEUE_PAGE_TITLE, queuePageTitle);
	}

	@When("user click the queue GetStarted button")
	public void user_click_the_queue_get_started_button() {
	    
		picoDepInj.homePage.clickOnQueueGetStartedBtn();
		
	}

	@Given("user is already on Queue page")
	public void user_is_already_on_queue_page() {
	    
		String queuePageTitle = picoDepInj.queuePage.getQueuePageTitle();
		LoggerLoad.info("Queue Page title :--" + queuePageTitle);
		Assert.assertEquals(Constant.QUEUE_PAGE_TITLE, queuePageTitle);
	}

	@When("user click on Implementation of Queue in Python link")
	public void user_click_on_implementation_of_queue_in_python_link() {
	    
		picoDepInj.queuePage.clickOnPythonQueueImplementation();
		LoggerLoad.info("Implementation of Queue link clicked");
	}

	@Then("user should redirect to Implementation of Queue in Python page")
	public void user_should_redirect_to_implementation_of_queue_in_python_page() {

		String queueImplementationPageUrl = picoDepInj.queuePage.getQueueImplementationPageUrl();
		LoggerLoad.info("User redirected to queue Implementation Page :--" + queueImplementationPageUrl);
		Assert.assertTrue(queueImplementationPageUrl.contains("queue/implementation-lists/"));
		
	}
	
	@When("user clicks on TryHere button from queue")
	public void user_clicks_on_try_here_button_from_queue() {

		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.queuePage.clickOnTryHereBtn();
	}
	
	@Then("user should be redirect to the python editor page")
	public void user_should_be_redirect_to_the_python_editor_page() {
	   
		String editorPageUrl =  picoDepInj.queuePage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
		
	}

	@When("user enters the invalid input {string} in the editor")
	public void user_enters_the_invalid_input_in_the_editor(String invalidInput) {
	    
		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.queuePage.sendInvalidInputIntoPyEditor(invalidInput);//test123
	}
	
	@When("user click on RUN button for queue")
	public void user_click_on_run_button_for_queue() throws InterruptedException {
		
		LoggerLoad.info("user clicking on run btn ");
		picoDepInj.queuePage.clickRunBtn();
	}
	
	@Then("user should get an Alert with error Message")
	public void user_should_get_an_alert_with_error_message() {
	   
		Alert alert =   picoDepInj.queuePage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.queuePage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
	
	}

	@Then("user click the alert OK button")
	public void user_click_the_alert_OK_button() throws InterruptedException {
		 LoggerLoad.info("User accepting alert.");
		 picoDepInj.queuePage.acceptAlert();
	}
		
	@When("for queue user enters valid python code from test sheet {string} and {int}")
	public void user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum)
			throws IOException, InterruptedException {

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");//hello
		picoDepInj.queuePage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}

	@Then("for queue flow console should display result {string}")
	public void console_should_display_result(String ecpectedOutput) {

		String actualOutput = picoDepInj.queuePage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@When("user click on Implementation using collections.deque link")
	public void user_click_on_implementation_using_collections_deque_link() {
		picoDepInj.queuePage.clickDeQueueImplementation();
	}

	@Then("user should redirect to Implementation using collections.deque Page")
	public void user_should_redirect_to_implementation_using_collections_deque_page() {
	    
		String dequeueImplePageUrl = picoDepInj.queuePage.getDeQueueImplementationPageUrl();
		LoggerLoad.info("User redirected to queue Implementation using collections.deque Page :--" + dequeueImplePageUrl);
		Assert.assertTrue(dequeueImplePageUrl.contains("queue/implementation-collections/"));
		
	}

	@When("user click on Implementation using Array")
	public void user_click_on_implementation_using_array() {
	    
		picoDepInj.queuePage.clickArrayImplementation();
	}

	@Then("user should redirect to Implementation using Array page")
	public void user_should_redirect_to_implementation_using_array_page() {
	    
		String arrayImplePageUrl = picoDepInj.queuePage.getArrayImplementationPageUrl();
		LoggerLoad.info("User redirected to Implementation using Array Page :--" + arrayImplePageUrl);
		Assert.assertTrue(arrayImplePageUrl.contains("/Implementation-array/"));
		
	}

	@When("user clicks on Queue Operations")
	public void user_clicks_on_queue_operations() {
		
		picoDepInj.queuePage.clickQueueOperation();
	}

	@Then("user should land on Queue Operations")
	public void user_should_land_on_queue_operations() {
	    
		String queueOperationsPageUrl = picoDepInj.queuePage.getQueueOperationPageUrl();
		LoggerLoad.info("User redirected to Queue Operations Page :--" + queueOperationsPageUrl);
		Assert.assertTrue(queueOperationsPageUrl.contains("/QueueOp/"));
		
	}

	@When("user clicks to the Practice Questions link")
	public void user_clicks_to_the_practice_questions_link() {
		
		picoDepInj.queuePage.clickOnPythonQueueImplementation();
		picoDepInj.queuePage.clickPracticeQuestion();
		LoggerLoad.info("User clicked on practice questions link ");
	}

	@Then("user redirected to the practice questions page")
	public void user_redirected_to_the_practice_questions_page() {
	    
		String practiceQuestionsPageUrl = picoDepInj.queuePage.getPracticeQuestionsPageUrl();
		LoggerLoad.info("User redirected to practice questions  Page :--" + practiceQuestionsPageUrl);
		Assert.assertTrue(practiceQuestionsPageUrl.contains("queue/practice"));
		
	}

}
