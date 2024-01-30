package com.StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_SignInPage;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_SignIn {

	ExcelReader excelreader;
	POM_HomePage homePage;
	POM_SignInPage signInPage;

	@Given("User is already on SignIn page")
	public void user_is_already_on_sign_in_page() {

		homePage = new POM_HomePage(DriverFactory.getDriver());
		homePage.clickOnSignInBtn();
		signInPage = homePage.verifyUserRedirectedToSignInPage();
		String tittle = signInPage.getSignInPageTitle();
		LoggerLoad.info("SignIn Page actual tittle is :-" + tittle);
		Assert.assertEquals(tittle, Constant.SIGN_IN_PAGE_TITTLE);
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String userName, String pwd) {
		signInPage.enterValidCredentials(userName, pwd);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		signInPage.clickOnLoginBtn();
	}

	@Then("User should be regirected to Home page with success message {string}")
	public void user_should_be_regirected_to_home_page_with_success_message(String loginSuccessMsg) {

		LoggerLoad.info("Home Page tittle is :-" + homePage.getHomePageTitle());

		Assert.assertEquals(homePage.getHomePageTitle(), Constant.HOME_PAGE_TITTLE);
		Assert.assertEquals(homePage.getTextLoginSuccessMsg(), loginSuccessMsg);
	}

	@Then("Username should be displayed along with Sign-out button on home page.")
	public void username_should_be_displayed_along_with_sign_out_button_on_home_page() {

	}

	@When("User enters the {string} and {int}")
	public void user_enters_the_and(String sheetName, int rowNum) throws IOException {
		excelreader = new ExcelReader();
		List<Map<String, String>> testData = excelreader.getTestDataFromSheet(sheetName);
		String testUsername = testData.get(rowNum).get("username");
		String testPassword = testData.get(rowNum).get("password");
		LoggerLoad.info("user enter invalid username as : "+testUsername+" and invalid password as : "+testPassword);

		if (testUsername != null || testPassword != null) {
			signInPage.enterValidCredentials(testUsername, testPassword);
		}
	}

	@Then("Application should display error message {string}")
	public void application_should_display_error_message(String loginErrorMsg) {

		String invalidAlertMsg = signInPage.getInvalidLoginErrorMsgText();
		LoggerLoad.info("Login failed as user entered invalid login credentials." + loginErrorMsg);		
		Assert.assertEquals(invalidAlertMsg, loginErrorMsg);
				
	}
	
	@When("Either username {string} or password {string} is blank.")
	public void either_username_or_password_is_blank(String Uname, String pwd) {	
		
		signInPage.enterValidCredentials(Uname, pwd);	
		LoggerLoad.info("user enter username as : "+Uname+" and password as : "+pwd);
	}

	@Then("User should get alert message {string}")
	public void user_should_get_alert_message(String alertMsg) {
	    
		LoggerLoad.info("User should see alert msg." + alertMsg);		
		//Assert.assertTrue(signInPage.verifyBlankFeildErrorMsgSize()>0);
	}


}
