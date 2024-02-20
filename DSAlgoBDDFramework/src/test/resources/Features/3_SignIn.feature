@SignIn
Feature: SignIn and SignOut validation feature
 
 
 @ValidSignIn
  Scenario: Sign-in with valid user name and valid passwrod
    Given User is already on SignIn page
    When User enters valid "sdetwarriors" and valid "sdet@146"
    And User click on login button
    Then User should be redirected to Home page with success message "You are logged in" 
    And Username should be displayed along with Sign-out button on home page.
    When User click on Sign-out button
    Then User should get Signout alert message "Logged out successfully" on home page.

  @InValidSignIn
  Scenario Outline: Sign-in with invalid username and passwrod 
    Given User is already on SignIn page
    When User enters the "<SheetName>" and <RowNumber>
    And User click on login button
    Then Application should display error message "<InvalidCredentialsMsg>" 

    Examples: 
      | SheetName  | RowNumber | InvalidCredentialsMsg |
      | loginData  |     0     | Invalid Username and Password|
      | loginData  |     1     | Invalid Username and Password|
      | loginData  |     2     | Invalid Username and Password|
  
 @BlankUserNameOnSignIn
  Scenario: Verification for PopUp message appears for blank username 
    Given User is already on SignIn page
    When User provides username " " and password "test@123"
    And User click on login button
    Then User should get alert message "Please fill out this field." below username "username" field.
    
 @BlankPasswordOnSignIn
  Scenario: Verification for PopUp message appears for blank password 
    Given User is already on SignIn page
    When User provides username "test123" and password " ".
    And User click on login button
    Then User should get alert message "Please fill out this field." below password "password" field.
    
  @RegisterLink
  Scenario: Register link on varification 
    Given User is already on SignIn page
    When User click on Register link below input fields on SignIn page
    Then User should be redirected to Register page from SignIn page
    
      
  
      
   
    