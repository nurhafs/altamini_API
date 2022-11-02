Feature: Create Comment for Product
  As a user
  I want to write comment for product
  So the product can improve

  Scenario: Create Product Comment with valid ID and filled form as registered user
    Given I set product url
    When I enter valid id with comment url
    And I fill the comments with token
    And I request post product
    Then My comment is submitted

  Scenario: Create Product Comment with valid ID and filled form as anon user
    Given I set product url
    When I enter valid id with comment url
    And I fill the comments
    And I request post product
    Then I get error 401

  Scenario: Create Product Comment with invalid ID and filled form
    Given I set product url
    When I enter invalid id with comment url
    And I fill the comments
    And I request post product
    Then I get invalid syntax error

  Scenario: Create Product Comment with valid ID and empty form as registered user
    Given I set product url
    When I enter valid id with comment url
    And I leave the comments empty with token
    And I request post product
    Then I get error 500

  Scenario: Create Product Comment with valid ID and empty form as anon user
    Given I set product url
    When I enter valid id with comment url
    And I leave the comments empty
    And I request post product
    Then I get error 401

  Scenario: Create Product Comment with invalid ID and empty form
    Given I set product url
    When I enter valid id with comment url
    And I leave the comments empty
    And I request post product
    Then I get invalid syntax error