Feature: Create New Product
  As a seller
  I want to create new product
  So I can sell more product

  Scenario: Create New Product with filled form as registered user
    Given I set product url
    And I enter new product data with token
    When I request post product
    Then I get new product detail

  Scenario: Create New Product with empty form as registered user
    Given I set product url
    And I enter empty product data with token
    When I request post product
    Then I get error 500

  Scenario: Create New Product with filled form as anon user
    Given I set product url
    And I enter new product data
    When I request post product
    Then I get new product detail

  Scenario: Create New Product with empty form as anon user
    Given I set product url
    And I enter empty product data
    When I request post product
    Then I get error 500