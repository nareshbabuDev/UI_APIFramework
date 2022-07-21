@Cite
Feature: ZoteroBib UI Validation

 @CiteSearch
 Scenario Outline: Cite search
    Given User is on ZoteroBib Home page
    When User searches for Cite
    |Cite_Value|
    |<Cite_Value>|
    And User select cite from display list
    Then User can see Cite "<Cite_Value>" in Biblography

  Examples:
   |Cite_Value|
   |J.K. Rowling: Harry Potter|


 @CiteAdd
 Scenario Outline: Cite Add
    Given User is on ZoteroBib Cite Section
    When User add Cite through Manual Entry
      |Book_Title| last_Name | first_Name |
      |<Book_Title>|<last_Name> | <first_Name> |
    Then User can see Cite "<Book_Title>" in Biblography

    Examples:
      |Book_Title| last_Name | first_Name |
      |TEST QA   | TESTER    | ONE |


  @CiteUpdate
  Scenario Outline: Cite Update
    Given User is on ZoteroBib Biblography Section
    And User select Cite for Cite Updation
      |Book_Title|
      |<Book_Title>|
    When User update Cite through Manual Entry
      |Update_Book_Title|
      |<Update_Book_Title>|
    Then User can see Cite "<Update_Book_Title>" in Biblography

    Examples:
      |Book_Title| Update_Book_Title |
      |TEST QA   |    QA             |

  @CiteDelete
  Scenario Outline: Cite Delete
    Given User is on ZoteroBib Biblography Section
    And User select Cite for Cite Deletion
      |Book_Title|
      |<Book_Title>|
    When User delete Cite through Manual
      |Book_Title|
      |<Book_Title>|
    Then User can not see Cite "<Book_Title>" in Biblography

    Examples:
      |Book_Title|
      |QA |

  @healthCheck
  Scenario: To confirm whether the API is up and running
    Given user has access to endpoint "/itemTypes"
    When user makes a request to check the health of Cite service
    Then user should get the response code 200