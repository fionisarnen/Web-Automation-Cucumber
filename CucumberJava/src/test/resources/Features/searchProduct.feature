Feature: TC search product positive

  Scenario: search product
    Given user succesfully logged in and landed on homepage
    When user input keyword for product searching
    Then user view search result
