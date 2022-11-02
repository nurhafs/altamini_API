Feature: Get Product Ratings
  As a user
  I want to get product ratings
  So I can decide whether to buy the products or not

  Scenario Outline: Get Product Ratings
    Given I set product url
    When I enter <id> with rating url
    And I request get product
    Then I get <result> as result

    Examples:
    | id | result |
    | "31" | "product ratings" |
    | "e" | "invalid syntax error" |
