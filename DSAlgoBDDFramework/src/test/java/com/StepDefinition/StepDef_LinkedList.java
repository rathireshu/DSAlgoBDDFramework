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



public class StepDef_LinkedList {
	
	PicoDependencyInjector picoDepInj;

	public StepDef_LinkedList(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

		
	}	
		@When("user click on the Linked List menu {string} from drop down")
		public void click_linked_list_menu_from_drop_down(String DropDownMenuName) {
			
			picoDepInj.homePage.clickOnGivenDSDropDownMenu(DropDownMenuName);
			LoggerLoad.info("user selected linked list from drop down menu.");
		}

		@Then("user should redirect to Linked List home page")
		public void user_should_redirect_to_linked_list_home_page() {
			
			picoDepInj.linkedListPage = picoDepInj.homePage.verifyUserRedirectedToLinkedListPage();
			String linkedListPageTitle = picoDepInj.linkedListPage.getLinkedListPageTitle();
			LoggerLoad.info("linked List Page title :--" + linkedListPageTitle);
			Assert.assertEquals(Constant.LINKED_LIST_PAGE_TITLE, linkedListPageTitle);
		}

		@When("user click on LL Introduction link")
		public void user_click_on_ll_introduction_link()  {
			
			picoDepInj.linkedListPage.clickOnIntroductionLink();;
			LoggerLoad.info("User clicked on linked list introduction Link :--");
		}

		@Then("user should redirect to LL Introduction page")
		public void user_should_redirect_to_ll_introduction_page() {
			
			String introductionPageUrl = picoDepInj.linkedListPage.getIntroductionPageUrl();
			LoggerLoad.info("User redirected to introduction Page :--" + introductionPageUrl);
			Assert.assertTrue(introductionPageUrl.contains("/linked-list/introduction/")); 
		}

		@When("user clicks on TryHere button for lined list flow")
		public void user_clicks_on_try_here_button_for_lined_list_flow() {

			LoggerLoad.info("User is clicking on try here button :--");
			picoDepInj.linkedListPage.clickOnTryHereBtn();//failing
			
		}

		@Then("user should be redirect to the python editor for lined list flow")
		public void user_should_be_redirect_to_the_python_editor_for_lined_list_flow() {
			
			String editorPageUrl =  picoDepInj.linkedListPage.getPyEditorPageUrl();
			LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
			Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
		}

		@When("user enters the invalid input {string} python editor for lined list flow")
		public void user_enters_the_invalid_input_python_editor_for_lined_list_flow(String invalidInput) {
			
			LoggerLoad.info("Sending invalid input into editor" );
			picoDepInj.linkedListPage.sendInvalidInputIntoPyEditor(invalidInput);
		}

		@When("user click on RUN button for lined list flow")
		public void user_click_on_run_button_for_lined_list_flow() {
			
			LoggerLoad.info("user clicking on run btn ");
			picoDepInj.linkedListPage.clickRunBtn();
		}

		@Then("an Alert with error Message for lined list flow will appears")
		public void an_alert_with_error_message_for_lined_list_flow_will_appears() {
			
			Alert alert =   picoDepInj.linkedListPage.isAlertPresent();
			LoggerLoad.info("Alert is present :--" + alert);
			String alertErrorMsgText = picoDepInj.linkedListPage.alertErrorMsgText();
			LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
			Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
		}

		@Then("user click on OK button of lined list flow alert")
		public void user_click_on_ok_button_of_lined_list_flow_alert() throws InterruptedException {
			 LoggerLoad.info("User accepting alert.");
			 picoDepInj.linkedListPage.acceptAlert();
		}

		@When("for lined list user enters valid python code from test sheet {string} and {int}")
		public void for_lined_list_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {
			
			ExcelReader excelReader = new ExcelReader();
			List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
			String inputCode = testdata.get(rowNum).get("pythonCode");//hello
			picoDepInj.linkedListPage.sendValidInputIntoPyEditor(inputCode);
			LoggerLoad.info("sending valid input to editor");
		}

		@Then("for lined list flow console should display result {string}")
		public void for_lined_list_flow_console_should_display_result(String ecpectedOutput) {
			
			String actualOutput = picoDepInj.linkedListPage.getValidOutputText();
			LoggerLoad.info("Editor showing valid output--" + actualOutput);
			Assert.assertEquals(actualOutput, ecpectedOutput);
		}

		@When("user click on LL Creating Linked List link")
		public void user_click_on_ll_creating_linked_list_link() {
			
			picoDepInj.linkedListPage.clickOnCreatingLinkedListLink();
		}

		@Then("user should redirect to LL Creating Linked List page")
		public void user_should_redirect_to_ll_creating_linked_list_page() {
			
			String creatingLinkedListPageUrl = picoDepInj.linkedListPage.getCreatingLinkedListPageUrl();
			LoggerLoad.info("User redirected to creating LinkedList Page :--" + creatingLinkedListPageUrl);
			Assert.assertTrue(creatingLinkedListPageUrl.contains("/linked-list/creating-linked-list/"));
		}
		@When("user click on LL Types of Linked List link")
		public void user_click_on_ll_types_of_linked_list_link() {
			
			picoDepInj.linkedListPage.clickOnTypesOfLinkedListLink();
			
		}

		@Then("user should redirect to LL Types of Linked List page")
		public void user_should_redirect_to_ll_types_of_linked_list_page() {

			String typesOfLinkedListPageUrl = picoDepInj.linkedListPage.getTypesOfLinkedListPageUrl();
			LoggerLoad.info("User redirected to Types of Linked List Page :--" + typesOfLinkedListPageUrl);
			Assert.assertTrue(typesOfLinkedListPageUrl.contains("/linked-list/types-of-linked-list/"));
		}

		@When("user click on LL Implement Linked List in Python link")
		public void user_click_on_ll_implement_linked_list_in_python_link() {
			
			picoDepInj.linkedListPage.clickOnImplementLinkedListInPythonLink();
		}

		@Then("user should redirect to LL Implement Linked List in Python page")
		public void user_should_redirect_to_ll_implement_linked_list_in_python_page() {
			
			String impleLinkedListPageUrl = picoDepInj.linkedListPage.getImplementLinkedListInPythonPageUrl();
			LoggerLoad.info("User redirected to Implement LinkedList In Python Page :--" + impleLinkedListPageUrl);
			Assert.assertTrue(impleLinkedListPageUrl.contains("/linked-list/implement-linked-list-in-python/"));
		}

		@When("user click on LL Traversal link")
		public void user_click_on_linkedlist_traversal_link() {
			
			picoDepInj.linkedListPage.clickOnTraversalLink();
		}
	    
		@Then("user should redirect to LL Traversal page")
		public void user_should_redirect_to_ll_traversal_page() {
			
			String traversalPageUrl = picoDepInj.linkedListPage.getTraversalPageUrl();
			LoggerLoad.info("User redirected to Traversal Page :--" + traversalPageUrl);
			Assert.assertTrue(traversalPageUrl.contains("/linked-list/traversal/"));
		
		}

		@When("user click on LL Insertion link")
		public void user_click_on_ll_insertion_link() {

			picoDepInj.linkedListPage.clickOnInsertionLink();
		}

		@Then("user should redirect to LL Insertion page")
		public void user_should_redirect_to_ll_insertion_page() {
			
			String insertionPageUrl = picoDepInj.linkedListPage.getInsertionPageUrl();
			LoggerLoad.info("User redirected to Insertion Page :--" + insertionPageUrl);
			Assert.assertTrue(insertionPageUrl.contains("/linked-list/insertion-in-linked-list/"));
		
		}

		@When("user click on LL Deletion link")
		public void user_click_on_ll_deletion_link() {
			
			picoDepInj.linkedListPage.clickOnDeletionLink();
		}

		@Then("user should redirect to LL Deletion page")
		public void user_should_redirect_to_ll_deletion_page() {
			
			String deletionPageUrl = picoDepInj.linkedListPage.getDeletionPageUrl();
			LoggerLoad.info("User redirected to deletion Page :--" + deletionPageUrl);
			Assert.assertTrue(deletionPageUrl.contains("/linked-list/deletion-in-linked-list/"));
		
		}
				
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	