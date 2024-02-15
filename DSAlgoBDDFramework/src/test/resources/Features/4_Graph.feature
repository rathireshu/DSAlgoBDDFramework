@GraphPage
Feature: Graph page validation 
   
   Background:  Signed in user is already on Graph home page
    Given user is already on dsportalapp home page 
    When user is already signed in into dsportalapp
    And user click on Graph GetStarted button
    Then user should be redirected to Graph home page.
    
@GraphLink
 Scenario: Sign in user redirected to Graph option page
   
    When user clicks on Graph link option on graph home page
    Then user should be redirected to Graph option page.

 @GraphLink  
 Scenario: Graph link TryHere button redirected user to Python Editor 
    
    When user clicks on Graph link option on graph home page
    Then user should be redirected to Graph option page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
      
@GraphLink  
  Scenario: For Graph link System will not displays anything for empty input on Python Editor 
  
    When user clicks on Graph link option on graph home page
    Then user should be redirected to Graph option page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user enters blank input python code "  " in editor
    And user click on RUN button
    Then no error message should displayed on console
 
 @GraphLink 
  Scenario: For Graph link system will displays error alert window for invalid python code   
   
    When user clicks on Graph link option on graph home page
    Then user should be redirected to Graph option page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user provides invalid input python code "test123" in editor
    And user click on RUN button
    Then system should display a alert window with error message
    And user click the OK button in the alert window
    
      
 @GraphOption 
  Scenario Outline: For Graph link system will show output for valid python input  
  
    When user clicks on Graph link option on graph home page
    Then user should be redirected to Graph option page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button
    Then console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |
     
   
 @GraphRepresentations 
  Scenario: Validating sign in user redirect to Graph Representations page
   
    When user clicks on Graph Representations link option on graph home page
    Then user should be redirected to Graph Representations page.
    
@GraphRepresentations
 Scenario: Validating GraphRepresentations TryHere button redirect user to Python Editor 
    
    When user clicks on Graph Representations link option on graph home page
    Then user should be redirected to Graph Representations page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    
 
 @GraphRepresentations 
  Scenario: For Graph Representations System will not displays anything for empty input on Python Editor 
  
    When user clicks on Graph Representations link option on graph home page
    Then user should be redirected to Graph Representations page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user enters blank input python code "  " in editor
    And user click on RUN button
    Then no error message should displayed on console
 
@GraphRepresentations
  Scenario: For Graph Representations system will displays error alert window for invalid python code   
   
   When user clicks on Graph Representations link option on graph home page
    Then user should be redirected to Graph Representations page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user provides invalid input python code "test123" in editor
    And user click on RUN button
    Then system should display a alert window with error message
    When user click the OK button in the alert window
   
@GraphRepresentations
  Scenario Outline: For Graph Representations system will show output for valid python input  
  
    When user clicks on Graph Representations link option on graph home page
    Then user should be redirected to Graph Representations page.
    When user clicks on TryHere button
    Then user should be redirected to python Editor page with Run button
    When user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button
    Then console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |
 
 
 @GraphRepresentations
  Scenario: For Graph Representations Signed in user should be redirected to Practice Questions page 
  
   Given  user clicks on Graph Representations link option on graph home page
   Then user should be redirected to Graph Representations page.
   When user clicks Practice Questions link on Graph Representations page
   Then user should be redirected to Practice Questions page.
    
  
    