@HomePage
Feature: Home page verification feature

 @NoSignInWaringDefault @run
  Scenario: verify Sign-In warning message is not present by default
    Given user is already on dsportalapp home page 
    When User is not signed in already
    Then User should not get warning message by default  
    
  @GetStartedAccessWithoutSignIn @run
  Scenario: user should be able to access GetStarted without sign in
    Given user is already on dsportalapp home page 
    When User is not signed in already
    And User click on GetStarted button
    Then User should get user is not Sign-In warning message
    
   @DataStrMenuAccessWithoutSignIn
   Scenario: user should be able to access any data structure from drop down without sign in
    Given user is already on dsportalapp home page
    When User is not signed in already 
    And User click on data structure drop down	
    Then User should see six data structure options in list
  
  @RegisternSignInBtnDispalyed
  Scenario: verify Register and Sign-In button are displayed and clickable
    Given user is already on dsportalapp home page
    When User is not signed in already
    And User verify Register and Sign-In buttons are displayed    
    Then verify Register and Sign-In buttons should be clickable    
   
  @signInBtn
  Scenario: User should be redirected to login page after click on Sign-In button
    Given user is already on dsportalapp home page
    When User click on Sign-In buttons    
    Then User should be redirected to login page
 
 @RegisterBtn
  Scenario: User should be redirected to Register page after click on Register button
    Given user is already on dsportalapp home page
    When User click on Register buttons    
    Then User should be redirected to Register page
    
    
  @RegirectedToGraph
  Scenario: User should be redirected to Graph home page via Graph data structure dropdown
    Given user is already on dsportalapp home page 
    When user is already signed in into dsportalapp
    And User click on data structure drop down	
    And user click on Graph data structure from drop down menu "Graph"
    Then user should be redirected to Graph home page. 
     