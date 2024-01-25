@HomePage
Feature: Home page verification feature

 @tag1
  Scenario: verify Sign-In warning message is not present by default
    Given User is already on dsportalapp home page 
    When User is not signed in already
    Then User should not get warning message by default  
    
  @tag2
  Scenario: user should be able to access GetStarted without sign in
    Given User is already on dsportalapp home page 
    When User is not signed in already
    And User click on GetStarted button
    Then User should get user is not Sign-In warning message
    
   @tag3
   Scenario: user should be able to access any data structure from drop down without sign in
    Given User is already on dsportalapp home page
    When User is not signed in already 
    And User click on data structure drop down
    Then User should see six data structure options in list
  
  @tag4
  Scenario: verify Register and Sign-In button are displayed and enabled
    Given User is already on dsportalapp home page
    When User is not signed in already
    And User verify Register and Sign-In buttons are displayed    
    Then verify Register and Sign-In buttons should be enabled    
   