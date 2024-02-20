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

public class StepDef_Tree {

	PicoDependencyInjector picoDepInj;

	public StepDef_Tree(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	
	@When("user click on the Tree menu {string} from drop down")
	public void user_click_on_the_tree_menu_from_drop_down(String DropDownMenuName) {

		picoDepInj.homePage.clickOnGivenDSDropDownMenu(DropDownMenuName);
		LoggerLoad.info("user selected tree from drop down menu.");
	}

	@Then("user should redirect to Tree home page")
	public void user_should_redirect_to_tree_home_page() {

		picoDepInj.treePage = picoDepInj.homePage.verifyUserRedirectedToTreePage();
		String treePageTitle = picoDepInj.treePage.getTreePageTitle();
		LoggerLoad.info("Tree Page title :--" + treePageTitle);
		Assert.assertEquals(Constant.TREE_PAGE_TITLE, treePageTitle);
	}

	@When("user click on Overview of Trees link")
	public void user_click_on_overview_of_trees_link() {
		
		picoDepInj.treePage.clickOnOverviewOfTreesLink();;
		LoggerLoad.info("Overview of Trees link clicked");
	}

	@Then("user should redirect to Overview of Trees page")
	public void user_should_redirect_to_overview_of_trees_page() {

		String overviewOfTreesPageUrl = picoDepInj.treePage.getOverviewOfTreesPageUrl();
		LoggerLoad.info("User redirected to overview Of Trees Page :--" + overviewOfTreesPageUrl);
		Assert.assertTrue(overviewOfTreesPageUrl.contains("/tree/overview-of-trees/"));
	}

	@When("user clicks on TryHere button for tree flow")
	public void user_clicks_on_try_here_button_for_tree_flow() {
		
		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.treePage.clickOnTryHereBtn();
	}

	@Then("user should be redirect to the python editor for tree flow")
	public void user_should_be_redirect_to_the_python_editor_for_tree_flow() {
		
		String editorPageUrl =  picoDepInj.treePage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
	}

	@When("user enters the invalid input {string} python editor for tree flow")
	public void user_enters_the_invalid_input_python_editor_for_tree_flow(String invalidInput) {
		
		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.treePage.sendInvalidInputIntoPyEditor(invalidInput);//test123
	}

	@When("user click on RUN button for tree flow")
	public void user_click_on_run_button_for_tree_flow() throws InterruptedException {
		LoggerLoad.info("user clicking on run btn ");
		picoDepInj.treePage.clickRunBtn();
	}

	@Then("an Alert with error Message for tree flow will appears")
	public void an_alert_with_error_message_for_tree_flow_will_appears() {
		Alert alert =   picoDepInj.treePage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.treePage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
	}

	@Then("user click on OK button of tree flow alert")
	public void user_click_on_ok_button_of_tree_flow_alert() throws InterruptedException {
		 
		  LoggerLoad.info("User accepting alert.");
		  picoDepInj.treePage.acceptAlert();
	}

	@When("for tree user enters valid python code from test sheet {string} and {int}")
	public void for_tree_user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum) throws IOException {

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");
		picoDepInj.treePage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}

	@Then("for tree flow console should display result {string}")
	public void for_tree_flow_console_should_display_result(String ecpectedOutput) {

		String actualOutput = picoDepInj.treePage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@When("user click on Terminologies link")
	public void user_click_on_terminologies_link() {
		
		picoDepInj.treePage.clickOnTerminologiesLink();
	}

	@Then("user should redirect to Terminologies page")
	public void user_should_redirect_to_terminologies_page() {
		
		String terminologiesPageUrl = picoDepInj.treePage.getTerminologiesPageUrl();
		LoggerLoad.info("User redirected to terminologies Page :--" + terminologiesPageUrl);
		Assert.assertTrue(terminologiesPageUrl.contains("/tree/terminologies/"));
		
	}

	@When("user click on Types of Trees link")
	public void user_click_on_types_of_trees_link() {
		picoDepInj.treePage.clickOnTypeOfTreesLink();
	}

	@Then("user should redirect to Types of Trees page")
	public void user_should_redirect_to_types_of_trees_page() {
		
		String typeOfTreesPageUrl = picoDepInj.treePage.getTypeOfTreesPageUrl();
		LoggerLoad.info("User redirected to Types of Trees Page :--" + typeOfTreesPageUrl);
		Assert.assertTrue(typeOfTreesPageUrl.contains("/tree/types-of-trees/"));
	}

	@When("user click on Tree Traversals link")
	public void user_click_on_tree_traversals_link() {
		picoDepInj.treePage.clickOnTreeTraversalsLink();
	}

	@Then("user should redirect to Tree Traversals page")
	public void user_should_redirect_to_tree_traversals_page() {
		
		String treeTraversalsPageUrl = picoDepInj.treePage.getTreeTraversalsPageUrl();
		LoggerLoad.info("User redirected to tree traversals Page :--" + treeTraversalsPageUrl);
		Assert.assertTrue(treeTraversalsPageUrl.contains("/tree/tree-traversals/"));
	}

	@When("user click on Traversals-Illustration link")
	public void user_click_on_traversals_illustration_link() {
		picoDepInj.treePage.clickOnTraversalsIllustrationLink();
	}

	@Then("user should redirect to Traversals-Illustration page")
	public void user_should_redirect_to_traversals_illustration_page() {

		String traversalsIllusPageUrl = picoDepInj.treePage.getTraversalsIllustrationPageUrl();
		LoggerLoad.info("User redirected to Traversals-Illustration Page :--" + traversalsIllusPageUrl);
		Assert.assertTrue(traversalsIllusPageUrl.contains("/tree/traversals-illustration/"));
	}

	@When("user click on Binary Trees link")
	public void user_click_on_binary_trees_link() {
		picoDepInj.treePage.clickOnBinaryTreesLink();
	}

	@Then("user should redirect to Binary Trees page")
	public void user_should_redirect_to_binary_trees_page() {

		String binaryTreesPageUrl = picoDepInj.treePage.getBinaryTreesPageUrl();
		LoggerLoad.info("User redirected to Binary Trees Page :--" + binaryTreesPageUrl);
		Assert.assertTrue(binaryTreesPageUrl.contains("/tree/binary-trees/"));
	}

	@When("user click on Types of Binary Trees link")
	public void user_click_on_types_of_binary_trees_link() {
		picoDepInj.treePage.clickOnTypesOfBinaryTreesLink();
	}

	@Then("user should redirect to Types of Binary Trees page")
	public void user_should_redirect_to_types_of_binary_trees_page() {
		
		String TypesOfBinaryTreesPageUrl = picoDepInj.treePage.getTypesOfBinaryTreesPageUrl();
		LoggerLoad.info("User redirected to Types Of Binary Trees Page :--" + TypesOfBinaryTreesPageUrl);
		Assert.assertTrue(TypesOfBinaryTreesPageUrl.contains("/tree/types-of-binary-trees/"));
	}

	@When("user clicks to the Practice Questions link for Tree flow")
	public void user_clicks_to_the_practice_questions_link_for_tree_flow() {
		picoDepInj.treePage.clickOnPracticeQuestionsLink();
	}

	@Then("user redirected to the practice questions page for Tree flow")
	public void user_redirected_to_the_practice_questions_page_for_tree_flow() {
		
		String practiceQuestionsPageUrl = picoDepInj.treePage.getPracticeQuestionsPageUrl();
		LoggerLoad.info("User redirected to practice questions Page :--" + practiceQuestionsPageUrl);
		Assert.assertTrue(practiceQuestionsPageUrl.contains("/tree/practice"));
		
	}

}
