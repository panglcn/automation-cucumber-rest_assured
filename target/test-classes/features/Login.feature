Feature: Login

  Using website http://automationpractice.com/index.php for example

  Background:
    Given user is on the authentication page

  Scenario: AT_001_Verify user login successfully with valid account
    When user enters with "auto@yopmail.com" and "Testing!123" as email and password
    And user click on sign in button
    Then user should be redirected to my account page

  Scenario Outline: AT_002_Verify error message when enter invalid account
    When user enters with "<email>" and "<password>" as email and password
    And user click on sign in button
    Then user should see "<error>" as error message
    Examples:
      | email             | password    | error                      |
      |                   | Password    | An email address required. |
      | auto@yopmail.com  |             | An email address required. |
      | auto1@yopmail.com | Testing!123 | Authentication failed.     |
      | auto@yopmail.com  | 123         | Invalid password.          |