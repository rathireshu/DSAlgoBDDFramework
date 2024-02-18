 package com.StepDefinition;

import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.PageObjects.POM_HomePage;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.PicoDependencyInjector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Home {

	PicoDependencyInjector picoDepInj;

	public StepDef_Home(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;
	}
	
	@Given("user is already on dsportalapp home page")
	public void user_is_already_on_dsportalapp_home_page_and_not_sign_in() {		
		picoDepInj.homePage = new POM_HomePage(DriverFactory.getDriver());		
		String title = picoDepInj.homePage.getHomePageTitle();
		LoggerLoad.info("Home Page title is :-"+title);
		Assert.assertEquals(title, Constant.HOME_PAGE_TITLE);
	}
	@Given("User is not signed in already")
	public void User_is_not_signed_in_already() {
		LoggerLoad.info("user is not signed in already as register and sign in button is displayed on home page.");
		
		Assert.assertTrue(picoDepInj.homePage.verifySignInBtnPresent());
		Assert.assertTrue(picoDepInj.homePage.verifyRegisterBtnPresent());
		
	}
	
	@Then("User should not get warning message by default")
	public void User_should_not_get_warning_message_by_default() {		
		Assert.assertEquals(picoDepInj.homePage.verifyNotSignInMsgNotPresent(), 0);
		LoggerLoad.info("Not sign in warning message is not present by default");
	}

	@When("User verify Register and Sign-In buttons are displayed")
	public void user_verify_register_and_sign_in_buttons_are_displayed() {
		Assert.assertTrue(picoDepInj.homePage.verifySignInBtnPresent());
		Assert.assertTrue(picoDepInj.homePage.verifyRegisterBtnPresent());
		LoggerLoad.info("Register and sign in btns are present");
	}

	@Then("verify Register and Sign-In buttons should be clickable")
	public void verify_register_and_sign_in_buttons_should_be_clickable() {
		Assert.assertTrue(picoDepInj.homePage.verifyRegisterBtnEnable());
		Assert.assertTrue(picoDepInj.homePage.verifySignInBtnEnable());
	}

	@When("User click on GetStarted button")
	public void user_click_on_get_started_button() {
		picoDepInj.homePage.clickOnGetStartedBtn();
	}

	@Then("User should get user is not Sign-In warning message")
	public void user_should_get_user_not_sign_in_warning_message() {
		
		Assert.assertEquals(picoDepInj.homePage.verifyNotSignInMsgNotPresent(), 1);
	}

	@When("User click on data structure drop down")
	public void user_click_on_data_structure_drop_down() {
		picoDepInj.homePage.clickDataStructureDD();
	}
	
	@When("user click on Graph data structure from drop down menu {string}")
	public void user_click_on_graph_data_structure_from_drop_down_menu(String dropDownMenu) {
	    
		picoDepInj.homePage.clickOnGivenDSDropDownMenu(dropDownMenu);
		
	}

	@Then("User should see six data structure options in list")
	public void user_should_see_seven_data_structure_options_in_list() {
	    int dsListOptions = picoDepInj.homePage.verifyDataStrDDListCount();
	    Assert.assertEquals(dsListOptions, 6);	    
	}
	@When("User click on Sign-In buttons")	  
	public void User_click_on_SignIn_buttons(){
		picoDepInj.homePage.clickOnSignInBtn();
		LoggerLoad.info("SignIn btn clicked successfully. ");
		
	}	
    @Then("User should be redirected to login page")
    public void User_should_be_redirected_to_login_page() {
    	
    	picoDepInj.signInPage = picoDepInj.homePage.verifyUserRedirectedToSignInPage();//this method will return signin page object    	 
    	String title = picoDepInj.signInPage.getSignInPageTitle();
		LoggerLoad.info("SignIn Page actual title is :-"+title);
		Assert.assertEquals(title, Constant.SIGN_IN_PAGE_TITLE);    
    }

    @When("User click on Register buttons")	  
	public void User_click_on_Register_buttons(){
    	
    	picoDepInj.homePage.clickOnRegisterBtn();
    	LoggerLoad.info("Register btn clicked successfully. ");
	}
    
    @Then("User should be redirected to Register page")
    public void User_should_be_redirected_to_Register_page() {
    	
    	picoDepInj.registerPage = picoDepInj.homePage.verifyUserRedirectedToRegisterPage();
    	String title = picoDepInj.registerPage.getRegisterPageTitle();
		LoggerLoad.info("Register Page actual title is :-"+title);
		Assert.assertEquals(title, Constant.REGISTER_PAGE_TITLE);    
    }
    
    
}