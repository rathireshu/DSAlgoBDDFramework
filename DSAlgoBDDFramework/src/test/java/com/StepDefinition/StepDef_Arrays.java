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

public class StepDef_Arrays {

	
	PicoDependencyInjector picoDepInj;

	public StepDef_Arrays(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	
	@When("user click on the arrays menu {string} from drop down")
	public void user_click_on_the_arrays_menu_from_drop_down(String DropDownMenuName) {
		
		picoDepInj.homePage.clickOnGivenDSDropDownMenu(DropDownMenuName);
		LoggerLoad.info("user selected arrays from drop down menu.");
	}

	@Then("user should redirect to arrays page")
	public void user_should_redirect_to_arrays_page() {
		
		picoDepInj.arraysPage = picoDepInj.homePage.verifyUserRedirectedToArraysPage();
		String arraysPageTitle = picoDepInj.arraysPage.getArraysPageTitle();
		LoggerLoad.info("array Page title :--" + arraysPageTitle);
		Assert.assertEquals(Constant.ARRAYS_PAGE_TITLE, arraysPageTitle);
	}

	@When("user click on Array in python link")
	public void user_click_on_array_in_python_link() {

		picoDepInj.arraysPage.clickOnArraysInPythonLink();
		LoggerLoad.info("User clicked on Arrays In Python Link :--");
	}

	@Then("user should redirect to Array in python page")
	public void user_should_redirect_to_array_in_python_page() {

		String arraysInPyPageUrl = picoDepInj.arraysPage.getArraysInPythonPageUrl();
		LoggerLoad.info("User redirected to Arrays In Python Page :--" + arraysInPyPageUrl);
		Assert.assertTrue(arraysInPyPageUrl.contains("array/arrays-in-python/"));
	}

	@When("user clicks on TryHere button for arrays flow")
	public void user_clicks_on_try_here_button_for_arrays_flow() {
		
		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.arraysPage.clickOnTryHereBtn();
		
	}

	@Then("user should be redirect to the python editor for arrays flow")
	public void user_should_be_redirect_to_the_python_editor_for_arrays_flow() {

		String editorPageUrl =  picoDepInj.arraysPage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
	}
	
	 @Then("user should be redirect to the python editor for question flow")
		public void user_should_be_redirect_to_the_python_editor_for_question_flow() {

			String questionEditorPageUrl =  picoDepInj.arraysPage.getPyEditorPageUrl();
			LoggerLoad.info("User redirected to question python editor Page :--" + questionEditorPageUrl);
			Assert.assertTrue(questionEditorPageUrl.contains("question/"));
		}
	
	
	@When("user enters the invalid input {string} python editor for Arrays flow")
	public void user_enters_the_invalid_input_python_editor_for_arrays_flow(String invalidInput) {

		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.arraysPage.sendInvalidInputIntoPyEditor(invalidInput);
	}

	@When("user click on RUN button for Arrays flow")
	public void user_click_on_run_button_for_arrays_flow() {

		LoggerLoad.info("user clicking on run btn ");
		picoDepInj.arraysPage.clickRunBtn();
	}

	@Then("an Alert with error Message for Arrays flow will appears")
	public void an_alert_with_error_message_for_arrays_flow_will_appears() {
		
		Alert alert =   picoDepInj.arraysPage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.arraysPage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
		//NameError: name 'SearchInArrays12345' is not defined on line 1
	}

	@Then("user click on OK button of Arrays flow alert")
	public void user_click_on_ok_button_of_arrays_flow_alert() throws InterruptedException {
		 
		LoggerLoad.info("User accepting alert.");
		 picoDepInj.arraysPage.acceptAlert();
	}

	@When("for arrays user enters valid python code from test sheet {string} and {int}")
	public void for_arrays_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");//hello
		picoDepInj.arraysPage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}

	@Then("for Arrays flow console should display result {string}")
	public void for_arrays_flow_console_should_display_result(String ecpectedOutput) {
		
		String actualOutput = picoDepInj.arraysPage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@When("user click on Arrays Using List link")
	public void user_click_on_arrays_using_list_link() {

		picoDepInj.arraysPage.clickOnArraysUsingListLink();
	}

	@Then("user should redirect to Arrays Using List page")
	public void user_should_redirect_to_arrays_using_list_page() {

		String ArraysUsingListPageUrl = picoDepInj.arraysPage.getArraysUsingListPageUrl();
		LoggerLoad.info("User redirected to Arrays Using List Page :--" + ArraysUsingListPageUrl);
		Assert.assertTrue(ArraysUsingListPageUrl.contains("array/arrays-using-list/"));
	}


	@When("user click on Basic Operations in Lists link")
	public void user_click_on_basic_operations_in_lists_link() {
		
		picoDepInj.arraysPage.clickOnBasicOperInListsLink();
	}

	@Then("user should redirect to Basic Operations in Lists page")
	public void user_should_redirect_to_basic_operations_in_lists_page() {

		String basicOperInListsPageUrl = picoDepInj.arraysPage.getBasicOperInListsPageUrl();
		LoggerLoad.info("User redirected to Basic Operations in Lists Page :--" + basicOperInListsPageUrl);
		Assert.assertTrue(basicOperInListsPageUrl.contains("array/basic-operations-in-lists/"));
	}
	
	@When("user click on Applications of Array link")
	public void user_click_on_applications_of_array_link() {
		
		picoDepInj.arraysPage.clickOnApplicationsOfArrayLink();
	}

	@Then("user should redirect to Applications of Array page")
	public void user_should_redirect_to_applications_of_array_page() {

		String AppliofArrayPageUrl = picoDepInj.arraysPage.getApplicationsOfArrayPageUrl();
		LoggerLoad.info("User redirected to Applications of Array Page :--" + AppliofArrayPageUrl);
		Assert.assertTrue(AppliofArrayPageUrl.contains("array/applications-of-array/"));
	}

	@When("user clicks on practice question link for arrays flow")
	public void user_clicks_on_practice_question_link_for_arrays_flow() {

		picoDepInj.arraysPage.clickPracticeQuestion();
		LoggerLoad.info("practice question link clicked");
	}

	@Then("user should be redirect to the practice question home page")
	public void user_should_be_redirect_to_the_practice_question_home_page() {

		String practiceQuePageUrl = picoDepInj.arraysPage.getPracticeQuestionsPageUrl();
		LoggerLoad.info("User redirected to practice question Page :--" + practiceQuePageUrl);
		Assert.assertTrue(practiceQuePageUrl.contains("/array/practice"));
	}

	@When("user click on first question search in array link")
	public void user_click_on_first_question_search_in_array_link() {
		
		picoDepInj.arraysPage.clickOnSearchTheArrayLink();
		LoggerLoad.info("User clicked on search the array link");
	}

	@When("user click on RUN button for Arrays question flow")
	public void user_click_on_run_button_for_arrays_question_flow() {
		
		picoDepInj.arraysPage.clickRunBtn();
		LoggerLoad.info("User clicked on run btn for practice question");
	}

	@Then("an Alert with error Message for question flow will appears")
	public void an_alert_with_error_message_for_question_flow_will_appears() {

		Alert alert =   picoDepInj.arraysPage.isAlertPresent();
		LoggerLoad.info("Alert is present on practice question :--" + alert);
		String alertErrorMsgText = picoDepInj.arraysPage.alertErrorMsgText();
		LoggerLoad.info("system displaying syntex error alert:--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("SyntaxError: bad input"));
	
	}

	@Then("user click on OK button of question flow alert")
	public void user_click_on_ok_button_of_question_flow_alert() throws InterruptedException {
		 
		LoggerLoad.info("User accepting alert for practice question");
		 picoDepInj.arraysPage.acceptAlert();
	}

	@When("for arrays question user enters valid python code from test sheet {string} and {int}")
	public void for_arrays_question_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");
		picoDepInj.arraysPage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid question input to editor");
	}

	@Then("for Arrays question flow console should display result {string}")
	public void for_arrays_question_flow_console_should_display_result(String ecpectedOutput) {

		String actualOutput = picoDepInj.arraysPage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output for practice question--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@When("user click on Submit button for Arrays question flow")
	public void user_click_on_submit_button_for_arrays_question_flow() throws InterruptedException {
		
		picoDepInj.arraysPage.clickSubmitBtn();
	}

	@When("user click on second question Max Consecutive Ones link")
	public void user_click_on_second_question_max_consecutive_ones_link() {
		
		picoDepInj.arraysPage.clickOnMaxConsOnesLink();
	}

	@When("user click on third question Find Numbers with Even Number of Digits link")
	public void user_click_on_third_question_find_numbers_with_even_number_of_digits_link() {
		
		picoDepInj.arraysPage.clickOnFindNumWithEvenDigLink();
	}

	@When("user click on fourth question Squares of a Sorted Array link")
	public void user_click_on_fourth_question_squares_of_a_sorted_array_link() {

		picoDepInj.arraysPage.clickOnSquareOfSortedArrayLink();
		
	}

}
