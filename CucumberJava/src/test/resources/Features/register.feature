Feature: TC Register Positive

  Scenario: Register new user
    Given user go to daftar page
    When user input email address
    And click kirim kode
    And user input secret code
    And user fill registeration
    Then user go to homepage
