package com.StepDefinition;

import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_RegisterPage;
import com.PageObjects.POM_SignInPage;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Def_Home {

	POM_HomePage homePage ;
	POM_SignInPage signInPage;
	POM_RegisterPage registerPage;
	
	
	@Given("User is already on dsportalapp home page")
	public void user_is_already_on_dsportalapp_home_page_and_not_sign_in() {
		
		homePage = new POM_HomePage(DriverFactory.getDriver());		
		String tittle = homePage.getHomePageTitle();
		LoggerLoad.info("Home Page tittle is :-"+tittle);
		Assert.assertEquals(tittle, Constant.HOME_PAGE_TITTLE);
	}
	@Given("User is not signed in already")
	public void User_is_not_signed_in_already() {
		LoggerLoad.info("user is not signed in already");
		
	}
	
	@Then("User should not get warning message by default")
	public void User_should_not_get_warning_message_by_default() {		
		Assert.assertEquals(homePage.verifyNotSignInMsgNotPresent(), 0);
		LoggerLoad.info("Not sign in warning message is not present by default");
	}

	@When("User verify Register and Sign-In buttons are displayed")
	public void user_verify_register_and_sign_in_buttons_are_displayed() {
		Assert.assertTrue(homePage.verifySignInBtnPresent());
		Assert.assertTrue(homePage.verifyRegisterBtnPresent());
		LoggerLoad.info("Register and sign in btns are present");
	}

	@Then("verify Register and Sign-In buttons should be enabled")
	public void verify_register_and_sign_in_buttons_should_be_enabled() {
		Assert.assertTrue(homePage.verifyRegisterBtnEnable());
		Assert.assertTrue(homePage.verifySignInBtnEnable());
	}

	@When("User click on GetStarted button")
	public void user_click_on_get_started_button() {
	   homePage.clickOnGetStartedBtn();
	}

	@Then("User should get user is not Sign-In warning message")
	public void user_should_get_user_not_sign_in_warning_message() {
		
		Assert.assertEquals(homePage.verifyNotSignInMsgNotPresent(), 1);
	}

	@When("User click on data structure drop down")
	public void user_click_on_data_structure_drop_down() {
		homePage.clickDataStructureDD();
	}

	@Then("User should see six data structure options in list")
	public void user_should_see_seven_data_structure_options_in_list() {
	    int dsListOptions = homePage.verifyDataStrDDListCount();
	    Assert.assertEquals(dsListOptions, 6);	    
	}
	@When("User click on Sign-In buttons")	  
	public void User_click_on_SignIn_buttons(){
		homePage.clickOnSignInBtn();
		LoggerLoad.info("SignIn btn clicked successfully. ");
		
	}	
    @Then("User should be redirected to login page")
    public void User_should_be_redirected_to_login_page() {
    	
    	signInPage = homePage.verifyUserRedirectedToSignInPage();//this method will return signin page object    	 
    	String tittle = signInPage.getSignInPageTitle();
		LoggerLoad.info("SignIn Page actual tittle is :-"+tittle);
		Assert.assertEquals(tittle, Constant.SIGN_IN_PAGE_TITTLE);    
    }

    @When("User click on Register buttons")	  
	public void User_click_on_Register_buttons(){
    	
    	homePage.clickOnRegisterBtn();
    	LoggerLoad.info("Register btn clicked successfully. ");
	}
    
    @Then("User should be redirected to Register page")
    public void User_should_be_redirected_to_Register_page() {
    	
    	registerPage = homePage.verifyUserRedirectedToRegisterPage();
    	String tittle = registerPage.getRegisterPageTittle();
		LoggerLoad.info("Register Page actual tittle is :-"+tittle);
		Assert.assertEquals(tittle, Constant.REGISTER_PAGE_TITTLE);    
    }
    
    
}