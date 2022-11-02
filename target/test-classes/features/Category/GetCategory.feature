@GetCat
Feature: Get Category
  As a user
  I want to get a category
  So I can search products related to it

  Scenario: Get All Categories
    Given I set category url
    When I request get category
    Then I see all categories list

  Scenario Outline: Get A Category
    Given I set category url
    And I add <id> to url
    When I request get category
    Then I get <result>

    Examples:
    | id | result |
    | "2" | "category" |
    | "e" | "invalid syntax error" |