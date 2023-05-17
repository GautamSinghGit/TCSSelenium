Feature: Validate home page
  sscenarios

  Background: launch the application under test
    Given : Launch the application

  Scenario Outline: Validate user is on home page after successfull login
    Given user login with "<name>" and "<pwd>"
    Then user verify logo is displayed
    Examples:
      | name                | pwd          |
      | selenium3@gmail.com | Selenium@123 |

  Scenario Outline: Validate single product is added into cart
    Given user login with "<name>" and "<pwd>"
    When user add a single "<product>" to the cart
    Then user verify success message is displayed

    Examples:
      | name                | pwd          | product      |
      | selenium3@gmail.com | Selenium@123 | "ZARA COAT 3 |