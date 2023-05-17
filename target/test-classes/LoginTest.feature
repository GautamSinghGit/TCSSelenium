Feature: Verify login page


  Background:launch application under test
    Given : Launch the application

  Scenario Outline: Verify user is able to login successfully
    Given user login with "<name>" and "<pwd>"
    Then user verify logo is displayed
    Examples:
      | name                | pwd          |
      | selenium3@gmail.com | Selenium@123 |


  Scenario Outline: Login with wrong credentials and verify error message is displayed
    Given user login with "<name>" and "<pwd>"
    Examples:
      | name           | pwd          |
      | wrongusername | Selenium@123 |
