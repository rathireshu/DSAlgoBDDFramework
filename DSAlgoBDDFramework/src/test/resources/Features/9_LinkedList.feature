@LinkedList
Feature: Linked list Page validation

     
    Background: Signed in user is already on Linked List home page
    
      Given user is already on dsportalapp home page 
      When user is already signed in into dsportalapp
      And user navigate to data-structures dropdown 
      And user click on the Linked List menu "Linked List" from drop down 
      Then user should redirect to Linked List home page   
    
@LLIntroduction 
  Scenario: Redirect to python editor form LL Introduction link
    
    When user click on LL Introduction link
    Then user should redirect to LL Introduction page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation  @run
  Scenario: For LL Introduction link system will displays error alert window for invalid input
     
    When user click on LL Introduction link
    Then user should redirect to LL Introduction page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation @run
  Scenario Outline: System will show output below run button for valid python input  
  
     When user click on LL Introduction link
    Then user should redirect to LL Introduction page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
   
   
 @LLCreatingLinkedList 
  Scenario: Redirect to python editor form LL Creating Linked List link
    
    When user click on LL Creating Linked List link
    Then user should redirect to LL Creating Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation 
  Scenario: For LL Creating Linked List link system will displays error alert window for invalid input
     
    When user click on LL Creating Linked List link
    Then user should redirect to LL Creating Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Creating Linked List link
    Then user should redirect to LL Creating Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
     
      
 @LLTypesOfLinkedList
  Scenario: Redirect to python editor form LL Types of Linked List link
    
    When user click on LL Types of Linked List link
    Then user should redirect to LL Types of Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation 
  Scenario: For LL Types of Linked List link system will displays error alert window for invalid input
     
    When user click on LL Types of Linked List link
    Then user should redirect to LL Types of Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Types of Linked List link
    Then user should redirect to LL Types of Linked List page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
 
 @LLImplementLinkedListInPython 
  Scenario: Redirect to python editor form LL Implement Linked List in Python link
    
    When user click on LL Implement Linked List in Python link
    Then user should redirect to LL Implement Linked List in Python page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation
  Scenario: For LL Implement Linked List in Python link system will displays error alert window for invalid input
     
    When user click on LL Implement Linked List in Python link
    Then user should redirect to LL Implement Linked List in Python page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Implement Linked List in Python link
    Then user should redirect to LL Implement Linked List in Python page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
 
 @LLTraversal 
  Scenario: Redirect to python editor form LL Traversal link
    
    When user click on LL Traversal link
    Then user should redirect to LL Traversal page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation
  Scenario: For LL Traversal link system will displays error alert window for invalid input
     
    When user click on LL Traversal link
    Then user should redirect to LL Traversal page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation  
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Traversal link
    Then user should redirect to LL Traversal page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
 @LLInsertion
  Scenario: Redirect to python editor form LL Insertion link
    
    When user click on LL Insertion link
    Then user should redirect to LL Insertion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation @run
  Scenario: For LL Insertion link system will displays error alert window for invalid input
     
    When user click on LL Insertion link
    Then user should redirect to LL Insertion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Insertion link
    Then user should redirect to LL Insertion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
 
@LLDeletion
  Scenario: Redirect to python editor form LL Deletion link
    
    When user click on LL Deletion link
    Then user should redirect to LL Deletion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    
    
   @InValidInputValidation 
  Scenario: For LL Deletion link system will displays error alert window for invalid input
     
    When user click on LL Deletion link
    Then user should redirect to LL Deletion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When user enters the invalid input "linkedlist12345" python editor for lined list flow
    And user click on RUN button for lined list flow
    Then an Alert with error Message for lined list flow will appears
    And user click on OK button of lined list flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on LL Deletion link
    Then user should redirect to LL Deletion page
    When user clicks on TryHere button for lined list flow
    Then user should be redirect to the python editor for lined list flow
    When for lined list user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for lined list flow
    Then for lined list flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
  
           
     
  
           
     
  