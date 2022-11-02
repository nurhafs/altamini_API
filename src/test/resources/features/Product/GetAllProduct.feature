Feature: Get All Product
  As a user
  I want to get all product
  So I can view list of products

  Scenario: Get All Product
    Given I set product url
    When request get product
    Then I get all products list