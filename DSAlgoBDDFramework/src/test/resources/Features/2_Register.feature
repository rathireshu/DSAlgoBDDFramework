@Register
Feature: Register Page validation feature
 
 @PopUpForAllFieldEmpty
  Scenario: Username pop up verification with all input field empty
  
    Given User is already on Register page
    When User provides empty value to all input fields
    And User click on Register button
    Then User should get pop up message "Please fill out this field." below username "username" textbox.
 
@PasswordPopUpForEmptyPwd
  Scenario: Password pop up verification  with both password fields empty
  
    Given User is already on Register page
    When User provides Username with other input fields empty
    And User click on Register button
    Then User should get pop up message "Please fill out this field." below password "Password" textbox.
  
  @PasswordConfPopUpForEmptyPwdConf
  Scenario: Password Confirmation pop up verification with only Password Confirmation field empty
  
    Given User is already on Register page
    When User provides Username and password with Password Confirmation input field empty
    And User click on Register button
    Then User should get pop up message "Please fill out this field." below Password Confirmation "Password Confirmation" textbox

 @PasswordMismatch
  Scenario: Password Mismatch verification for diffrent passwords in both password fields
  
    Given User is already on Register page
    When User enter passwords in Password and Password Confirmation fields 
    And User click on Register button
    Then System should display an password_mismatch error message "password_mismatch:The two password fields didn’t match.".
    
    @SuccessfullyRegistration
  Scenario Outline: Verify successfully Registration.
  
    Given User is already on Register page
    When User enters valid credential from the "<SheetName>" and <RowNumber>    
    And User click on Register button 
    Then User should be regirected to Home page with success message "<SuccessMessage>".
    And registred username should be displayed along with Sign-out button on home page.
 
 Examples: 
      | SheetName     | RowNumber | SuccessMessage   |
      | registerData  |     0     |New Account Created. You are logged in as username |
 
  
        