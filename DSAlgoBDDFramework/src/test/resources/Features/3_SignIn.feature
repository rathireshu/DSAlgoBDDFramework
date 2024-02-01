@SignIn
Feature: SignIn validation feature
 @tag1
  Scenario: Sign-in with valid user name and valid passwrod
    Given User is already on SignIn page
    When User enters valid "reshu146" and valid "Dsalgo@146"
    And User click on login button
    Then User should be regirected to Home page with success message "You are logged in" 
    And Username should be displayed along with Sign-out button on home page.
 
  @tag2
  Scenario Outline: Sign-in with invalid username and passwrod 
    Given User is already on SignIn page
    When User enters the "<SheetName>" and <RowNumber>
    And User click on login button
    Then Application should display error message "<InvalidCredentialsMsg>" 

    Examples: 
      | SheetName  | RowNumber | InvalidCredentialsMsg |
      | loginData  |     0     | Invalid Username and Password|
      | loginData  |     1     | Invalid Username and Password|
      | loginData  |     3     | Invalid Username and Password|
  
   @tag3
  Scenario: Verification for PopUp message appears for blank username 
    Given User is already on SignIn page
    When User provides username " " and password "test@123"
    And User click on login button
    Then User should get alert message "Please fill out this field." below username "username" field.
    
    @tag4
  Scenario: Verification for PopUp message appears for blank password 
    Given User is already on SignIn page
    When User provides username "test123" and password " ".
    And User click on login button
    Then User should get alert message "Please fill out this field." below password "password" field.
    
  @tag5
  Scenario: Register link on varification 
    Given User is already on SignIn page
    When User click on Register link on SignIn page
    Then User should be redirected to Register page
    
      
   
      
   
    