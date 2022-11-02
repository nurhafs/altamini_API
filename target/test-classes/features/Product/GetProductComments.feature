Feature: Get Product Comments
  As a user
  I want to get product comments
  So I can reconsider the quality of the product

  Scenario: Get Product Comments with valid ID
    Given I set product url
    When I enter valid id with comment url
    And I request get product
    Then I get comments of the product

  Scenario: Get Product Comments with invalid ID
    Given I set product url
    When I enter invalid id with comment url
    And I request get product
    Then I get invalid syntax error