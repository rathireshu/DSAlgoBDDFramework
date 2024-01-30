@SignIn
Feature: SignIn validation feature
 @tag1
  Scenario: Sign-in with valid user name and valid passwrod
    Given User is already on SignIn page
    When User enters valid "sonali" and valid "Dsalgo@1"
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
  Scenario Outline: Sign-in with empty username and passwrod 
    Given User is already on SignIn page
    When  Either username "<userNameValue>" or password "<passwordValue>" is blank.
    And User click on login button
    Then User should get alert message "<alertMessage>" 
    
    
    Examples: 
      | userNameValue  | passwordValue | alertMessage               |
      |                |    dksdmsdm   | Please fill out this field.|
      | test6438743    |               | Please fill out this field.|