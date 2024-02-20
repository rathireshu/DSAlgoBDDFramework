@Stack
Feature: Stack Page validation

     
    Background: Signed in user is already on Stack home page
    
      Given user is already on dsportalapp home page 
      When user is already signed in into dsportalapp
      And user navigate to data-structures dropdown 
      And user click on the stack menu "Stack" from drop down 
      Then user should redirect to Stack page   
    
@OperationsInStack
  Scenario: Redirect to python editor form Operations in Stack link
    
    When user click on Operations in Stack link
    Then user should redirect to Operations in Stack page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow

  @InValidInputValidation
  Scenario: For Implementation Of Queue in python link system will displays error alert window for invalid input
     
    When user click on Operations in Stack link
    Then user should redirect to Operations in Stack page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When user enters the invalid input "stack12345" python editor for Stack flow
    And user click on RUN button for Stack flow
    Then an Alert with error Message for Stack flow will appears
    And user click on OK button for Stack flow alert
    
  @ValidInputValidation
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Operations in Stack link
    Then user should redirect to Operations in Stack page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When for Stack user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Stack flow
    Then for Stack flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
    
 @Implementation
  Scenario: Redirect to python editor form Implementation link
    
    When user click on Implementation link
    Then user should redirect to Implementation page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow

  @InValidInputValidation
  Scenario: For Implementation link system will displays error alert window for invalid input
     
     When user click on Implementation link
    Then user should redirect to Implementation page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When user enters the invalid input "stack12345" python editor for Stack flow
    And user click on RUN button for Stack flow
    Then an Alert with error Message for Stack flow will appears
    And user click on OK button for Stack flow alert
    
  @ValidInputValidation
  Scenario Outline: System will show output below run button for valid python input  
  
     When user click on Implementation link
    Then user should redirect to Implementation page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When for Stack user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Stack flow
    Then for Stack flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     2     | 2 |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
@Applications
  Scenario: Redirect to python editor form Applications link
    
    When user click on Applications link
    Then user should redirect to Applications page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow

  @InValidInputValidation
  Scenario: For Applications link system will displays error alert window for invalid input
     
     When user click on Applications link
    Then user should redirect to Applications page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When user enters the invalid input "stack12345" python editor for Stack flow
    And user click on RUN button for Stack flow
    Then an Alert with error Message for Stack flow will appears
    And user click on OK button for Stack flow alert
    
  @ValidInputValidation
  Scenario Outline: System will show output below run button for valid python input  
  
     When user click on Applications link
    Then user should redirect to Applications page
    When user clicks on TryHere button for Stack flow
    Then user should be redirect to the python editor for Stack flow
    When for Stack user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Stack flow
    Then for Stack flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     2     | 2 |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
 
    
    