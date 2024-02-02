package com.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_RegisterPage;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Register {

	POM_HomePage homePage ;
	POM_RegisterPage registerPage;
	ExcelReader reader;
	String userName;
	
	@Given("User is already on Register page")
	public void user_is_already_on_register_page() {
		homePage = new POM_HomePage(DriverFactory.getDriver());
		homePage.clickOnRegisterBtn();		
		registerPage = homePage.verifyUserRedirectedToRegisterPage();		
		String title = registerPage.getRegisterPageTitle();
		LoggerLoad.info("Register Page actual title is :-" + title);
		Assert.assertEquals(title, Constant.REGISTER_PAGE_TITLE); 
	}

	@When("User provides empty value to all input fields")
	public void User_provides_empty_value_to_all_input_fields() {
		registerPage.enterUserName(" ");
		registerPage.enterPassword(" ");
		registerPage.enterPasswordConfirmation(" ");
	}

	@When("User click on Register button")
	public void user_click_on_register_button() {
		registerPage.clickOnRegisterBtn();
	}

	@Then("User should get pop up message {string} below username {string} textbox.")
	public void user_should_get_pop_up_message_below_username_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank username." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below username field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	
	}

	@When("User provides Username with other input fields empty")
	public void user_provides_username_with_other_input_fields_empty() {
		registerPage.enterUserName("demotest12");
		registerPage.enterPassword(" ");
		registerPage.enterPasswordConfirmation(" ");
	}

	@Then("User should get pop up message {string} below password {string} textbox.")
	public void user_should_get_pop_up_message_below_password_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank password." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below password field..:-  "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	}

	@When("User provides Username and password with Password Confirmation input field empty")
	public void user_provides_username_and_password_with_password_confirmation_input_field_empty() {
		registerPage.enterUserName("demotest12");
		registerPage.enterPassword("test@1234");
		registerPage.enterPasswordConfirmation(" ");
	}

	@Then("User should get pop up message {string} below Password Confirmation {string} textbox")
	public void user_should_get_pop_up_message_below_password_confirmation_textbox(String expectedPopUpMsgOnUsername, String string2) {
		LoggerLoad.info("User should see expected PopUp msg for blank password confirmation." + expectedPopUpMsgOnUsername);		
		String actualPopUpText = registerPage.getPopUpTextOnBlankField();
		LoggerLoad.info("Actual PopUp msg below password confirmation field..:- "+actualPopUpText);
        Assert.assertEquals(actualPopUpText, expectedPopUpMsgOnUsername);
	}

	@When("User enter passwords in Password and Password Confirmation fields")
	public void user_enter_passwords_in_password_and_password_confirmation_fields() {
		registerPage.enterUserName("demotest12");
		registerPage.enterPassword("test@1234");
		registerPage.enterPasswordConfirmation("test@123");
	}

	@Then("System should display an password_mismatch error message {string}.")
	public void system_should_display_an_password_mismatch_error_message(String expectedErrorMsg) {
		String actualErrorMsg = registerPage.getPwdMismatchErrorText();
		LoggerLoad.info("Actual PopUp msg for password mismatch.:- "+actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	
	@When("User enters valid credential from the {string} and {int}")
	public void user_enters_valid_username_valid(String sheetName, int rowNum) throws IOException {
		reader = new ExcelReader();
		userName =reader.getTestDataFromSheet(sheetName).get(rowNum).get("username");
		registerPage.enterUserName(userName);
		String password =reader.getTestDataFromSheet(sheetName).get(rowNum).get("password");
		registerPage.enterPassword(password);
		String passwordConf =reader.getTestDataFromSheet(sheetName).get(rowNum).get("confirmpassword");
		registerPage.enterPasswordConfirmation(passwordConf);
	}

	@Then("User should be regirected to Home page with success message {string}.")
	public void user_should_be_regirected_to_home_page_with_success_message(String expetedSuccessMsg) {
		
		LoggerLoad.info("user creation expected SuccessMsg.:- "+expetedSuccessMsg);
	    homePage  = registerPage.verifyUserRedirectedToHomePage();
	   String userCreationSuccessMsg = homePage.getTextLoginSuccessMsg();
	   LoggerLoad.info("user creation actual SuccessMsg.:- "+userCreationSuccessMsg);
	   Assert.assertTrue(userCreationSuccessMsg.contains(userName));
	}

}
