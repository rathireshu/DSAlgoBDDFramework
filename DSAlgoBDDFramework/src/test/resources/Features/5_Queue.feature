@Queue
Feature: Queue Page validation

     
    Background: Signed in user is already on Queue home page
    
      Given user is already on dsportalapp home page 
      When user is already signed in into dsportalapp
      And user navigate to data-structures dropdown 
      And user click the queue menu "Queue" from drop down 
      Then user should redirect to Queue page   
    

  @QueuePage
  Scenario: Open the Queue page from the GetStarted button
    
    When user click the queue GetStarted button
    Then user should redirect to Queue page
    
  @ImplementationOfQueue
  Scenario: Redirect to python editor form Implementation of Queue in Python link
    
    Given user is already on Queue page
    When user click on Implementation of Queue in Python link
    Then user should redirect to Implementation of Queue in Python page
    When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page

  @ImplementationOfQueue
  Scenario: For Implementation Of Queue in python link system will displays error alert window for invalid input
     
    Given user is already on Queue page
    When user click on Implementation of Queue in Python link
    Then user should redirect to Implementation of Queue in Python page
    When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When user enters the invalid input "queue12345" in the editor
    And user click on RUN button for queue
    Then user should get an Alert with error Message
    And user click the alert OK button 
    
    
  @ImplementationOfQueue
  Scenario Outline: For Implementation Of Queue in python system will show output for valid python input  
  
    When user click on Implementation of Queue in Python link
    Then user should redirect to Implementation of Queue in Python page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When for queue user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for queue
    Then for queue flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      
    
     
  @collections.deque
  Scenario: Redirect to python editor form Implementation using collections.deque page
    
    Given user is already on Queue page
    When user click on Implementation using collections.deque link
    Then user should redirect to Implementation using collections.deque Page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page

  @collections.deque
  Scenario: For Implementation using collections.deque system will displays error alert window for invalid input
     
    Given user is already on Queue page
    When user click on Implementation using collections.deque link
    Then user should redirect to Implementation using collections.deque Page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When user enters the invalid input "dqueue12345" in the editor
    And user click on RUN button for queue
    Then user should get an Alert with error Message
    And user click the alert OK button 
    
    
  @collections.deque
  Scenario Outline: For Implementation using collections.deque system will show output for valid python input  
  
    Given user is already on Queue page
    When user click on Implementation using collections.deque link
    Then user should redirect to Implementation using collections.deque Page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When for queue user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for queue
    Then for queue flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     2     | 2 |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
    
      
  @ImplementationUsingArray
  Scenario: Redirect to python editor form Implementation using Array page
    
    Given user is already on Queue page
    When user click on Implementation using Array
    Then user should redirect to Implementation using Array page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page

  @ImplementationUsingArray
  Scenario: For Implementation using Array system will displays error alert window for invalid input
     
    Given user is already on Queue page
    When user click on Implementation using Array
    Then user should redirect to Implementation using Array page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When user enters the invalid input "array12345" in the editor
    And user click on RUN button for queue
    Then user should get an Alert with error Message
    And user click the alert OK button 
   
  @ImplementationUsingArray 
  Scenario Outline: For Implementation using Array system will show output for valid python input  
  
    Given user is already on Queue page
    When user click on Implementation using Array
    Then user should redirect to Implementation using Array page
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When for queue user enters valid python code from test sheet "<SheetName>" and <RowNumber>  
    And user click on RUN button for queue
    Then for queue flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     3     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
    
    
      
  @QueueOperations
  Scenario: Redirect to python editor form Queue Operations page
    
    Given user is already on Queue page
    When user clicks on Queue Operations
    Then user should land on Queue Operations
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page

 @QueueOperations
  Scenario: For Queue Operations system will displays error alert window for invalid input
     
    Given user is already on Queue page
    When user clicks on Queue Operations
    Then user should land on Queue Operations
     When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When user enters the invalid input "queue12345" in the editor
    And user click on RUN button for queue
    Then user should get an Alert with error Message
    And user click the alert OK button 
   
  @QueueOperations 
  Scenario Outline: For Queue Operations system will show output for valid python input  
  
    Given user is already on Queue page
    When user clicks on Queue Operations
    Then user should land on Queue Operations
    When user clicks on TryHere button from queue
    Then user should be redirect to the python editor page
    When for queue user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for queue
    Then for queue flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     3     | 2 |
      
  
  @PracticeQuestion 
  Scenario: Open the practice Question Page 
  
    Given user is already on Queue page
    When user click on Implementation of Queue in Python link
    Then user should redirect to Implementation of Queue in Python page
    When user clicks to the Practice Questions link
    Then user redirected to the practice questions page
   