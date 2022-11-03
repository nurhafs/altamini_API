@GetOrder
Feature: Get Order
  As a User
  I want to get my orders
  So I can review them before checking out

  Scenario: Get All Orders as registered user
    Given I set order url
    When I send request get with authorization
    Then I get my orders list

  Scenario: Get All Orders as anon user
    Given I set order url
    When I send request get without authorization
    Then I get unauthorized

  Scenario Outline: Get Orders as registered user
    Given I set order url with "<param>" parameter
    When I send request get with authorization
    Then I get "<result>" order

    Examples:
    | param | result |
    | 1 | specific |
    | q | invalid syntax error |

  Scenario Outline: Get Orders as anon user
    Given I set order url with "<param>" parameter
    When I send request get without authorization
    Then I get "<result>" order

    Examples:
      | param | result |
      | 1 | unauthorized error |
      | q | unauthorized error |