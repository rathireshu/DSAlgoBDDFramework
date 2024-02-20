package com.StepDefinition;

import com.Utilities.ConfigReader;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import com.Utilities.PicoDependencyInjector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;

public class StepDef_Graph {

	PicoDependencyInjector picoDepInj;

	public StepDef_Graph(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}

	@When("user is already signed in into dsportalapp")
	public void user_is_already_signed_in_into_dsportalapp() {

		picoDepInj.homePage = new POM_HomePage(DriverFactory.getDriver());
		picoDepInj.homePage.clickOnSignInBtn();
		picoDepInj.signInPage = picoDepInj.homePage.verifyUserRedirectedToSignInPage();
		picoDepInj.signInPage.enterValidCredentials(ConfigReader.getPropertyObject().getProperty("username"),
				ConfigReader.getPropertyObject().getProperty("password"));
		picoDepInj.signInPage.clickOnLoginBtn();
		picoDepInj.homePage = picoDepInj.signInPage.verifyUserRedirectedToHomePage();
		String homePageTitle = picoDepInj.homePage.getHomePageTitle();
		LoggerLoad.info("Home page title after user sign in successfully into app :" + homePageTitle);
		Assert.assertEquals(Constant.HOME_PAGE_TITLE, homePageTitle);

	}

	@When("user click on Graph GetStarted button")
	public void user_click_on_graph_get_started_button() {
	    
		picoDepInj.homePage.clickOnGraphGetStartedBtn();
	}

	@Then("user should be redirected to Graph home page.")
	public void user_should_be_redirected_to_graph_home_page() {

		picoDepInj.graphPage = picoDepInj.homePage.verifyUserRedirectedToGraphPage();
		String graphPageTitle = picoDepInj.graphPage.getGraphPageTitle();
		LoggerLoad.info("Graph Page title :--" + graphPageTitle);
		Assert.assertEquals(Constant.GRAPH_PAGE_TITLE, graphPageTitle);
	}

	@When("user clicks on Graph link option on graph home page")
	public void user_clicks_on_graph_link_option_on_graph_home_page() {

		LoggerLoad.info("Graph Page title :--" + picoDepInj.graphPage.getGraphPageTitle());
		picoDepInj.graphPage.clickOnGraphLink();
	}

	@Then("user should be redirected to Graph option page.")
	public void user_should_be_redirected_to_graph_option_page() {

		String graphOptionPageUrl = picoDepInj.graphPage.getGraphOptionPageUrl();
		LoggerLoad.info("User redirected to Graph option Page :--" + graphOptionPageUrl);
		Assert.assertTrue(graphOptionPageUrl.contains("graph/graph/"));
	}

	@When("user clicks on TryHere button")
	public void user_clicks_on_try_here_button() {

		LoggerLoad.info("User is clicking on try here button :--");
		picoDepInj.graphPage.clickOnTryHereBtn();
	}

	@Then("user should be redirected to python Editor page with Run button")
	public void user_should_be_redirected_to_python_editor_page_with_run_button() {

		String editorPageUrl = picoDepInj.graphPage.getPyEditorPageUrl();
		LoggerLoad.info("User redirected to python editor Page :--" + editorPageUrl);
		Assert.assertTrue(editorPageUrl.contains("/tryEditor"));
		picoDepInj.graphPage.verifyPythonEditorPageUI();
		LoggerLoad.info("User can see python editor run btn ");
	}

		
	@When("user enters blank input python code {string} in editor")
	public void user_enters_blank_input_python_code_in_editor(String emptyInput) {
	    
		LoggerLoad.info("Sending blank input into editor" );
		picoDepInj.graphPage.sendInvalidInputIntoPyEditor(emptyInput);
	}

	@When("user click on RUN button")
	public void user_click_on_run_button() throws InterruptedException {
		picoDepInj.graphPage.clickRunBtn();
	}

	@Then("no error message should displayed on console")
	public void no_error_message_should_displayed_on_console() {

	}

	@When("user provides invalid input python code {string} in editor")
	public void user_provides_invalid_input_python_code_in_editor(String invalidInput) throws InterruptedException {
	    
		LoggerLoad.info("Sending invalid input into editor" );
		picoDepInj.graphPage.sendInvalidInputIntoPyEditor(invalidInput);//test123
	}


	@Then("system should display a alert window with error message")
	public void system_should_display_a_alert_window_with_error_message() throws InterruptedException {

		Alert alert =   picoDepInj.graphPage.isAlertPresent();
		LoggerLoad.info("Alert is present :--" + alert);
		String alertErrorMsgText = picoDepInj.graphPage.alertErrorMsgText();
		LoggerLoad.info("system displaying alert with error msg :--" + alertErrorMsgText);
		Assert.assertTrue(alertErrorMsgText.contains("NameError: name"));
		
	}

	@Then("user click the OK button in the alert window")
	public void user_click_the_ok_button_in_the_alert_window() throws InterruptedException {
		 LoggerLoad.info("User accepting alert.");
		 picoDepInj.graphPage.acceptAlert();
	}

	
	@When("user enters valid python code from test sheet {string} and {int}")
	public void user_enters_valid_python_code_from_test_sheet_and(String sheetName, Integer rowNum)
			throws IOException, InterruptedException {

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testdata = excelReader.getTestDataFromSheet(sheetName);
		String inputCode = testdata.get(rowNum).get("pythonCode");//hello
		picoDepInj.graphPage.sendValidInputIntoPyEditor(inputCode);
		LoggerLoad.info("sending valid input to editor");
	}

	@Then("console should display result {string}")
	public void console_should_display_result(String ecpectedOutput) {

		String actualOutput = picoDepInj.graphPage.getValidOutputText();
		LoggerLoad.info("Editor showing valid output--" + actualOutput);
		Assert.assertEquals(actualOutput, ecpectedOutput);
	}

	@Then("user should be redirected to Graph Representations page.")
	public void user_should_be_redirected_to_graph_representations_page() {

		String graphReprPageUrl = picoDepInj.graphPage.getGraphReprPageUrl();
		LoggerLoad.info("User redirected to Graph Representations Page :--" + graphReprPageUrl);
		Assert.assertTrue(graphReprPageUrl.contains("graph/graph-representations/"));
	}

	@Given("user clicks on Graph Representations link option on graph home page")
	public void user_clicks_on_graph_representations_link_option_on_graph_home_page() {

		picoDepInj.graphPage.clickOnGraphRepresLink();
	}

	@When("user clicks Practice Questions link on Graph Representations page")
	public void user_clicks_practice_questions_link_on_graph_representations_page() {

		picoDepInj.graphPage.clickOnPracticeQuestionsLink();
		
	}

	@Then("user should be redirected to Practice Questions page.")
	public void user_should_be_redirected_to_practice_questions_page() {

		String practiceQuePageUrl = picoDepInj.graphPage.getPracticeQuestionsPageUrl();
		LoggerLoad.info("User redirected to Graph Representations Page :--" + practiceQuePageUrl);
		Assert.assertTrue(practiceQuePageUrl.contains("/graph/practice"));
	}

}
