@DataStructuresIntroduction
Feature: Data Structures-Introduction page validation 
   
   Background:  Signed in user is already on Data Structures-Introduction home page
   
    Given user is already on dsportalapp home page 
    When user is already signed in into dsportalapp
    And user click on Data Structures-Introduction GetStarted button
    Then user should be redirected to Data Structures-Introduction home page.
    

 @TimeComplexityFlow  
 Scenario: Time Complexity link TryHere button redirected user to Python Editor 
    
    When user clicks on Time Complexity link on Data Structures-Introduction home page
    Then user should be redirected to Time Complexity option page.
    When user clicks on TryHere button from Time Complexity page
    Then user should be redirected to python Editor page from Time Complexity page

    
  @InvalidInputValidation  
    Scenario: System will displays error alert window for invalid input
     
     When user clicks on Time Complexity link on Data Structures-Introduction home page
    Then user should be redirected to Time Complexity option page.
    When user clicks on TryHere button from Time Complexity page
    Then user should be redirected to python Editor page from Time Complexity page
    When user enters the invalid input "Time Complexity 12345" in Time Complexity editor
    And user click on RUN button for Time Complexity
    Then an Alert with error Message for Time Complexity will appears
    And user click on OK button for Time Complexity alert
    
    
  @ValidInputValidation
  Scenario Outline: System will show output below run button for valid python input  
  
    When user clicks on Time Complexity link on Data Structures-Introduction home page
    Then user should be redirected to Time Complexity option page.
    When user clicks on TryHere button from Time Complexity page
    Then user should be redirected to python Editor page from Time Complexity page
    When for Time Complexity user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Time Complexity
    Then for Time Complexity flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
    
  