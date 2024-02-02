package com.StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_RegisterPage;
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
	POM_SignInPage signInPage ;	
	String validUsername;
	String validPassword;
	String loggedInUsername;
	
	
	@Given("User is already on SignIn page")
	public void user_is_already_on_sign_in_page() {

		homePage = new POM_HomePage(DriverFactory.getDriver());
		Assert.assertEquals(homePage.getHomePageTitle(), "NumpyNinja");
		homePage.clickOnSignInBtn();
		signInPage = homePage.verifyUserRedirectedToSignInPage();
		String title = signInPage.getSignInPageTitle();
		LoggerLoad.info("SignIn Page actual title is :-" + title);
		Assert.assertEquals(title, Constant.SIGN_IN_PAGE_TITLE);
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String userName, String pwd) {		
		validUsername = userName;
		validPassword = pwd;		
		signInPage.enterValidCredentials(validUsername, validPassword);
	}

	@When("User click on login button")
	public void user_click_on_login_button() throws InterruptedException {
		signInPage.clickOnLoginBtn();
		
	}

	@Then("User should be redirected to Home page with success message {string}")
	public void user_should_be_regirected_to_home_page_with_success_message(String loginSuccessMsg) {

		homePage = signInPage.verifyUserRedirectedToHomePage();	
	    String pageTitle =	homePage.getHomePageTitle();
		LoggerLoad.info("Home Page title is :-" + pageTitle);
		Assert.assertEquals(homePage.getHomePageTitle(), Constant.HOME_PAGE_TITLE);
		Assert.assertEquals(homePage.getTextLoginSuccessMsg(), loginSuccessMsg);
	}

	@Then("Username should be displayed along with Sign-out button on home page.")
	public void username_should_be_displayed_along_with_sign_out_button_on_home_page() {
		
		homePage.verifyloggedInUserNameLinkPresent();
		loggedInUsername = homePage.getloggedInUserNameLinkText();
		LoggerLoad.info("User signed In with valid username :--"+loggedInUsername );
		Assert.assertTrue(loggedInUsername.equalsIgnoreCase(validUsername));
	}
	
	
	@Given("User is already Signed-In into application")
	public void user_is_already_signed_in_into_application() {
	   
		 homePage = new POM_HomePage(DriverFactory.getDriver());
		 homePage.clickOnSignInBtn(); 
		 signInPage = homePage.verifyUserRedirectedToSignInPage();
		 signInPage.enterValidCredentials(validUsername, validPassword);
		 signInPage.clickOnLoginBtn(); 
		 loggedInUsername = homePage.getloggedInUserNameLinkText();
		 LoggerLoad.info("User signed In with valid username :--"+loggedInUsername );
		 Assert.assertTrue(loggedInUsername.equalsIgnoreCase(validUsername));
	}

	@When("User click on Sign-out button")
	public void user_click_on_sign_out_button() {
		homePage.clickOnSignOutBtn(); 
	}

	@Then("User should get Signout alert message {string} on home page.")
	public void user_should_get_Signout_alert_message_on_home_page(String SignOutAlertMsg) {
		
		LoggerLoad.info("Home Page title is :-" + homePage.getHomePageTitle());
		String signOutSuccessAlert = homePage.getTextSignOutSuccessMsg();
		Assert.assertEquals(signOutSuccessAlert,SignOutAlertMsg);
		
	}

	@Then("SignIn button should displayed along with Register button on home page.")
	public void sign_in_button_should_displayed_along_with_register_button_on_home_page() {
		
	    Assert.assertTrue(homePage.verifySignInBtnPresent());
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

	@When("User provides username {string} and password {string}")
	public void user_provides_blank_username(String username, String pwd) {
		LoggerLoad.info("user is entering blank username...");
		signInPage.enterValidCredentials(username, pwd);
	}

	@Then("User should get alert message {string} below username {string} field.")
	public void user_should_get_alert_message_below_username_field(String expectedPopUpTextUserName, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank username." + expectedPopUpTextUserName);		
		String actualPopUpText = signInPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below username field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpTextUserName);
	}

	@When("User provides username {string} and password {string}.")
	public void user_provides_blank_password(String username, String pwd) {
		LoggerLoad.info("user is entering blank password...");
		signInPage.enterValidCredentials(username, pwd);
	}

	@Then("User should get alert message {string} below password {string} field.")
	public void user_should_get_alert_message_below_password_field(String expectedPopUpTextPassword, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank password." + expectedPopUpTextPassword);		
		String actualPopUpText = signInPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below password field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpTextPassword);
	}
	
	@When("User click on Register link below input fields on SignIn page")
	public void user_click_on_Register_link_on_SignIn_page() {
		LoggerLoad.info("User clicked on register link below input fields from sign in page...");
		signInPage.clickOnRegisterLink();
	}
	
	
	@Then("User should be redirected to Register page from SignIn page")
    public void User_should_be_redirected_to_Register_page_from_SignIn_page() {
    	
		POM_RegisterPage  registerPage = homePage.verifyUserRedirectedToRegisterPage();
    	String title = registerPage.getRegisterPageTitle();
		LoggerLoad.info("Register Page actual title is :-"+title);
		Assert.assertEquals(title, Constant.REGISTER_PAGE_TITLE);    
    }
}

