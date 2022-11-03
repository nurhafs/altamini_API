@CreateOrder
Feature: Create Order
  As a user
  I want to create order
  So I can buy the products

  Scenario: Create Order as registered user with filled form
    Given I set order url
    And I fill the form with token
    When I request post
    Then order submitted

  Scenario: Create Order as registered user with empty form
    Given I set order url
    And I leave the form empty with token
    When I request post
    Then order submitted

  Scenario: Create Order as anon user with filled form
    Given I set order url
    And I fill the form
    When I request post
    Then I get unauthorized

  Scenario: Create Order as anon user with empty form
    Given I set order url
    And I leave the form empty
    When I request post
    Then I get unauthorized