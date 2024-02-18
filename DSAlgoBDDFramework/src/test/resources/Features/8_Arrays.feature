@Arrays
Feature: Arrays Page validation

     
    Background: Signed in user is already on Arrays home page
    
      Given user is already on dsportalapp home page 
      When user is already signed in into dsportalapp
      And user navigate to data-structures dropdown 
      And user click on the arrays menu "Arrays" from drop down 
      Then user should redirect to arrays page   
    
@ArrayInPython 
  Scenario: Redirect to python editor form Array in python link
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    
    
 @InValidInputValidation 
  Scenario: For Array in python link system will displays error alert window for invalid input
     
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When user enters the invalid input "arrays12345" python editor for Arrays flow
    And user click on RUN button for Arrays flow
    Then an Alert with error Message for Arrays flow will appears
    And user click on OK button of Arrays flow alert
 
 @ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When for arrays user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays flow
    Then for Arrays flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |      
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
      
 @ArraysUsingList 
  Scenario: Redirect to python editor form Arrays Using List link
    
    When user click on Arrays Using List link
    Then user should redirect to Arrays Using List page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    
    
 @InValidInputValidation 
  Scenario: For Arrays Using List link system will displays error alert window for invalid input
     
    When user click on Arrays Using List link
    Then user should redirect to Arrays Using List page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow    
    When user enters the invalid input "arrays12345" python editor for Arrays flow
    And user click on RUN button for Arrays flow
    Then an Alert with error Message for Arrays flow will appears
    And user click on OK button of Arrays flow alert
    
    
    
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Arrays Using List link
    Then user should redirect to Arrays Using List page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow  
    When for arrays user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays flow
    Then for Arrays flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      
 
  @BasicOperationsInLists 
  Scenario: Redirect to python editor form Basic Operations in Lists link
    
    When user click on Basic Operations in Lists link
    Then user should redirect to Basic Operations in Lists page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    
    
 @InValidInputValidation 
  Scenario: For Arrays Using List link system will displays error alert window for invalid input
     
    When user click on Basic Operations in Lists link
    Then user should redirect to Basic Operations in Lists page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When user enters the invalid input "arrays12345" python editor for Arrays flow
    And user click on RUN button for Arrays flow
    Then an Alert with error Message for Arrays flow will appears
    And user click on OK button of Arrays flow alert
    
    
    
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
    When user click on Basic Operations in Lists link
    Then user should redirect to Basic Operations in Lists page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When for arrays user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays flow
    Then for Arrays flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
      
 @ApplicationsOfArray 
  Scenario: Redirect to python editor form Applications of Array link
    
    When user click on Applications of Array link
    Then user should redirect to Applications of Array page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    
    
 @InValidInputValidation 
  Scenario: For Arrays Using List link system will displays error alert window for invalid input
     
     When user click on Applications of Array link
    Then user should redirect to Applications of Array page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When user enters the invalid input "arrays12345" python editor for Arrays flow
    And user click on RUN button for Arrays flow
    Then an Alert with error Message for Arrays flow will appears
    And user click on OK button of Arrays flow alert
    
    
    
@ValidInputValidation 
  Scenario Outline: System will show output below run button for valid python input  
  
     When user click on Applications of Array link
    Then user should redirect to Applications of Array page
    When user clicks on TryHere button for arrays flow
    Then user should be redirect to the python editor for arrays flow
    When for arrays user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays flow
    Then for Arrays flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |  
      
      
@ArrayPracticeQuestions 
  Scenario: Arrays Practice Questions flow verification
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    
@InvalidRunSearchTheArrayQuestions     
    
    Scenario: Error alert for invalid input Run flow of Search the Array question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on first question search in array link
    Then user should be redirect to the python editor for question flow
    When user enters the invalid input "SearchInArrays12345" python editor for Arrays flow
    And user click on RUN button for Arrays question flow
    Then an Alert with error Message for question flow will appears
    And user click on OK button of question flow alert
  
 @ValidRunSearchTheArrayQuestions    
   
 Scenario Outline: System will show output below Run button for valid question input  
  
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on first question search in array link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |   
  
  
 @ValidSubmitSearchTheArrayQuestions      
    
    Scenario Outline: Error message in console for valid input Submit flow of Search the Array question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on first question search in array link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on Submit button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
    
    
    Examples: 
      | SheetName            | RowNumber | validResult                      |
      | pythonCodeSubmission |     0     | submission success               |
     
    
@InvalidRunMaxConsecutiveOnesQuestions    
    
    Scenario: Error alert for invalid input Run flow of Max Consecutive Ones question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on second question Max Consecutive Ones link
    Then user should be redirect to the python editor for question flow
    When user enters the invalid input "MaxConsecutiveOnes12345" python editor for Arrays flow
    And user click on RUN button for Arrays question flow
    Then an Alert with error Message for question flow will appears
    And user click on OK button of question flow alert
  
 @ValidRunMaxConsecutiveOnesQuestions     
   
 Scenario Outline: System will show output below Run button for valid question input  
  
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on second question Max Consecutive Ones link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     0     | hello       |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      
  
 @ValidSubmitMaxConsecutiveOnesQuestions   
    
    Scenario Outline: Error message in console for valid input Submit flow of Max Consecutive Ones question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on second question Max Consecutive Ones link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on Submit button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
    
    
    Examples: 
      | SheetName            | RowNumber | validResult                      |
      | pythonCodeSubmission |     2     | submission success               |
           
    
@InvalidRunFindNumWithEvenNumOfDigitsQuestions
    
    Scenario: Error alert for invalid input Run flow of Find Numbers with Even Number of Digits question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on third question Find Numbers with Even Number of Digits link
    Then user should be redirect to the python editor for question flow
    When user enters the invalid input "FindNumberswithEvenNumberofDigits12345" python editor for Arrays flow
    And user click on RUN button for Arrays question flow
    Then an Alert with error Message for question flow will appears
    And user click on OK button of question flow alert
  
 @ValidRunFindNumWithEvenNumOfDigitsQuestions   
   
 Scenario Outline: System will show output below Run button for valid question input  
  
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on third question Find Numbers with Even Number of Digits link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |   
  
  
 @ValidSubmitFindNumWithEvenNumOfDigitsQuestions      
    
    Scenario Outline: Error message in console for valid input Submit flow of Find Numbers with Even Number of Digits question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on third question Find Numbers with Even Number of Digits link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on Submit button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
    
    
    Examples: 
      | SheetName            | RowNumber | validResult                      |
      | pythonCodeSubmission |     4     | submission success               |
     
   
@InvalidRunSquaresOfSortedArrayQuestions 
    
    Scenario: Error alert for invalid input Run flow of Squares of a Sorted Array question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on fourth question Squares of a Sorted Array link
    Then user should be redirect to the python editor for question flow
    When user enters the invalid input "SquaresOfSortedArray12345" python editor for Arrays flow
    And user click on RUN button for Arrays question flow
    Then an Alert with error Message for question flow will appears
    And user click on OK button of question flow alert
  
 @ValidRunSquaresOfSortedArrayQuestions
   
 Scenario Outline: System will show output below Run button for valid question input  
  
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on fourth question Squares of a Sorted Array link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on RUN button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
  
    Examples: 
      | SheetName  | RowNumber | validResult |
      | pythonCode |     1     | Element Found |
      | pythonCode |     2     | 2 |
      | pythonCode |     4     | [4, 9, 9, 49, 121] |   
  
  
 @ValidSubmitSquaresOfSortedArrayQuestions  
    
    Scenario Outline: Error message in console for valid input Submit flow of Squares of a Sorted Array question
    
    When user click on Array in python link
    Then user should redirect to Array in python page
    When user clicks on practice question link for arrays flow
    Then user should be redirect to the practice question home page
    When user click on fourth question Squares of a Sorted Array link
    Then user should be redirect to the python editor for question flow
    When for arrays question user enters valid python code from test sheet "<SheetName>" and <RowNumber>
    And user click on Submit button for Arrays question flow
    Then for Arrays question flow console should display result "<validResult>"
    
    
     Examples: 
      | SheetName            | RowNumber | validResult                      |
      | pythonCodeSubmission |     6     | Error occurred during submission |
      
    
  
  
  
  
  
  
  
  
  
  
  
  
  