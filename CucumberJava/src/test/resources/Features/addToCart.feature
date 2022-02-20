Feature: TC Add to cart Positive

 
  Scenario: add to cart
    Given user is on bukalapak homepage
    When user search for product
    Then user add product to cart
