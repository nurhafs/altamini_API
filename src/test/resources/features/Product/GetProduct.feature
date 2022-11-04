Feature: Get A Product
  As a user
  I want to get a product
  So I can view product details

Scenario: Get A Product with Valid ID
  Given I set product url
  When I request get with valid id
  Then I get product detail

  Scenario: Get A Product with Invalid ID
    Given I set product url
    When I request get with invalid id
    Then I get invalid syntax error