package com.StepDefinition;

import java.io.IOException;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import com.Utilities.PicoDependencyInjector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Register {

	PicoDependencyInjector picoDepInj;

	public StepDef_Register(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;
		
	}
		
	@Given("User is already on Register page")
	public void user_is_already_on_register_page() {
		picoDepInj.homePage = new POM_HomePage(DriverFactory.getDriver());
		picoDepInj.homePage.clickOnRegisterBtn();		
		picoDepInj.registerPage = picoDepInj.homePage.verifyUserRedirectedToRegisterPage();		
		String title = picoDepInj.registerPage.getRegisterPageTitle();
		LoggerLoad.info("Register Page actual title is :-" + title);
		Assert.assertEquals(title, Constant.REGISTER_PAGE_TITLE); 
	}

	@When("User provides empty value to all input fields")
	public void User_provides_empty_value_to_all_input_fields() {
		picoDepInj.registerPage.enterUserName(" ");
		picoDepInj.registerPage.enterPassword(" ");
		picoDepInj.registerPage.enterPasswordConfirmation(" ");
	}

	@When("User click on Register button")
	public void user_click_on_register_button() {
		picoDepInj.registerPage.clickOnRegisterBtn();
	}

	@Then("User should get pop up message {string} below username {string} textbox.")
	public void user_should_get_pop_up_message_below_username_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank username." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = picoDepInj.registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below username field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	
	}

	@When("User provides Username with other input fields empty")
	public void user_provides_username_with_other_input_fields_empty() {
		picoDepInj.registerPage.enterUserName("demotest12");
		picoDepInj.registerPage.enterPassword(" ");
		picoDepInj.registerPage.enterPasswordConfirmation(" ");
	}

	@Then("User should get pop up message {string} below password {string} textbox.")
	public void user_should_get_pop_up_message_below_password_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank password." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = picoDepInj.registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below password field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	}

	@When("User provides Username and password with Password Confirmation input field empty")
	public void user_provides_username_and_password_with_password_confirmation_input_field_empty() {
		picoDepInj.registerPage.enterUserName("demotest12");
		picoDepInj.registerPage.enterPassword("test@1234");
		picoDepInj.registerPage.enterPasswordConfirmation(" ");
	}

	@Then("User should get pop up message {string} below Password Confirmation {string} textbox")
	public void user_should_get_pop_up_message_below_password_confirmation_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank password confirmation." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = picoDepInj.registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below password confirmation field..:- "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	}

	@When("User enter passwords in Password and Password Confirmation fields")
	public void user_enter_passwords_in_password_and_password_confirmation_fields() {
		picoDepInj.registerPage.enterUserName("demotest12");
		picoDepInj.registerPage.enterPassword("test@1234");
		picoDepInj.registerPage.enterPasswordConfirmation("test@123");
	}

	@Then("System should display an password_mismatch error message {string}.")
	public void system_should_display_an_password_mismatch_error_message(String expectedErrorMsg) {
		String actualErrorMsg = picoDepInj.registerPage.getPwdMismatchErrorText();
		LoggerLoad.info("Actual PopUp msg for password mismatch.:- "+actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	
	@When("User enters valid credential from the {string} and {int}")
	public void user_enters_valid_username_valid(String sheetName, int rowNum) throws IOException {
		picoDepInj.excelreader = new ExcelReader();
		picoDepInj.registredUserName =picoDepInj.excelreader.getTestDataFromSheet(sheetName).get(rowNum).get("username");
		picoDepInj.registerPage.enterUserName(picoDepInj.registredUserName);
		String password =picoDepInj.excelreader.getTestDataFromSheet(sheetName).get(rowNum).get("password");
		picoDepInj.registerPage.enterPassword(password);
		String passwordConf =picoDepInj.excelreader.getTestDataFromSheet(sheetName).get(rowNum).get("confirmpassword");
		picoDepInj.registerPage.enterPasswordConfirmation(passwordConf);
	}

	@Then("User should be regirected to Home page with success message {string}.")
	public void user_should_be_regirected_to_home_page_with_success_message(String expetedSuccessMsg) {
		
	   LoggerLoad.info("user creation expected SuccessMsg.:- "+expetedSuccessMsg);
	   picoDepInj.homePage  = picoDepInj.registerPage.verifyUserRedirectedToHomePage();
	   String userCreationSuccessMsg = picoDepInj.homePage.getTextLoginSuccessMsg();
	   LoggerLoad.info("user creation actual SuccessMsg.:- "+userCreationSuccessMsg);
	   String homePageTitle = picoDepInj.homePage.getHomePageTitle();
	   Assert.assertTrue(homePageTitle.contains("NumpyNinja"));
	}

	@Then("registred username should be displayed along with Sign-out button on home page.")
	public void registered_username_should_be_displayed_along_with_Signout_button_on_home_page() {
	
		   LoggerLoad.info("registred User Name is:- "+picoDepInj.registredUserName);
		   String userNameText = picoDepInj.registerPage.getRegisteredUserName();		   
		   Assert.assertEquals(userNameText, picoDepInj.registredUserName);
	}
		

	 
}
