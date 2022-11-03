@Assign
Feature: Assign Product Rating
  As a user
  I want to assign product rating
  So I can evaluate product

  Scenario Outline: Assign Product Rating As Registered User
    Given I set product url
    When I enter <id> with rating url
    And I input <rating> rating with authorization
    And I request post product
    Then I get <result> as result

    Examples:
      | id | rating | result |
      | "0"  | 2    | "record not found error" |
      | "41" | 1    | "changed ratings"        |
      | "e"  | 3    | "invalid syntax error"   |
      | ""   | 1    | "not found error"        |

  Scenario Outline: Assign Product Rating As Anon User
    Given I set product url
    When I enter <id> with rating url
    And I input <rating> rating
    And I request post product
    Then I get <result> as result

    Examples:
      | id | rating | result |
      | "0"  | 2    | "unauthorized error"    |
      | "11" | 5    | "unauthorized error"    |
      | "e"  | 3    | "invalid syntax error"  |
      | ""   | 1    | "not found error"        |