@Tree
Feature: Tree Page validation

     
    Background: Signed in user is already on Tree home page
    
      Given user is already on dsportalapp home page 
      When user is already signed in into dsportalapp
      And user navigate to data-structures dropdown 
      And user click on the Tree menu "Tree" from drop down 
      Then user should redirect to Tree home page   
    
@OverviewOfTrees @run
  Scenario: Redirect to python editor form Overview of Trees link
    
    When user click on Overview of Trees link
    Then user should redirect to Overview of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation @run
  Scenario: For Overview of Trees link system will displays error alert window for invalid input
     
    When user click on Overview of Trees link
    Then user should redirect to Overview of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Overview of Trees link
    Then user should redirect to Overview of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      
   
   
   
@Terminologies 
  Scenario: Redirect to python editor form Overview of Trees link
    
    When user click on Terminologies link
    Then user should redirect to Terminologies page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Terminologies link system will displays error alert window for invalid input
     
    When user click on Terminologies link
    Then user should redirect to Terminologies page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Terminologies link
    Then user should redirect to Terminologies page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
       | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      
@TypesOfTrees 
  Scenario: Redirect to python editor form Types of Trees link
    
    When user click on Types of Trees link
    Then user should redirect to Types of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Types of Trees link system will displays error alert window for invalid input
     
    When user click on Types of Trees link
    Then user should redirect to Types of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Types of Trees link
    Then user should redirect to Types of Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  

@TreeTraversals 
  Scenario: Redirect to python editor form Tree Traversals link
    
    When user click on Tree Traversals link
    Then user should redirect to Tree Traversals page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Tree Traversals link system will displays error alert window for invalid input
     
    When user click on Tree Traversals link
    Then user should redirect to Tree Traversals page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Tree Traversals link
    Then user should redirect to Tree Traversals page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
     
@Traversals-Illustration 
  Scenario: Redirect to python editor form Traversals-Illustration link
    
    When user click on Traversals-Illustration link
    Then user should redirect to Traversals-Illustration page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Traversals-Illustration link system will displays error alert window for invalid input
     
    When user click on Traversals-Illustration link
    Then user should redirect to Traversals-Illustration page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Traversals-Illustration link
    Then user should redirect to Traversals-Illustration page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  


@BinaryTrees 
  Scenario: Redirect to python editor form Binary Trees link
    
    When user click on Binary Trees link
    Then user should redirect to Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Binary Trees link system will displays error alert window for invalid input
     
    When user click on Binary Trees link
    Then user should redirect to Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Binary Trees link
    Then user should redirect to Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |     
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
      
      
@TypesOfBinaryTrees 
  Scenario: Redirect to python editor form Types of Binary Trees link
    
    When user click on Types of Binary Trees link
    Then user should redirect to Types of Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    
    
@InValidInputValidation 
  Scenario: For Types of Binary Trees link system will displays error alert window for invalid input
     
    When user click on Types of Binary Trees link
    Then user should redirect to Types of Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When user enters the invalid input "tree12345" python editor for tree flow
    And user click on RUN button for tree flow
    Then an Alert with error Message for tree flow will appears
    And user click on OK button of tree flow alert
 
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Types of Binary Trees link
    Then user should redirect to Types of Binary Trees page
    When user clicks on TryHere button for tree flow
    Then user should be redirect to the python editor for tree flow
    When for tree user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for tree flow
    Then for tree flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      
      
      
 @PracticeQuestion 
  Scenario: Open the practice Question Page for tree flow
  
    When user click on Overview of Trees link
    Then user should redirect to Overview of Trees page
    When user clicks to the Practice Questions link for Tree flow
    Then user redirected to the practice questions page for Tree flow
   
                                      
                                      