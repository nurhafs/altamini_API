Feature: Delete Product
  As a user
  I want to delete a product
  So I can stop selling the product

  Scenario: Delete Product with Valid ID
    Given I set product url
    When I request delete with valid id
    Then I get null data

  Scenario: Delete Product with Invalid ID
    Given I set product url
    When I request delete with invalid id
    Then I get invalid syntax error