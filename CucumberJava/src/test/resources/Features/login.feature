Feature: TC Login Positive

  Scenario: login new user
    Given user go to login page
    When user fill email address
    And user fill password
    And user click button login
    Then user has logged in
