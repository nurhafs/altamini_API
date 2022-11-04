Feature: Create Category
  As a user
  I want to create category
  So I can sell more kinds of products

  Scenario: Create Category with filled form as registered user
    Given I set category url
    And I filled new category data with token
    When I request post category
    Then New category created

  Scenario: Create Category with empty form as registered user
    Given I set category url
    And I leave new category data empty with token
    When I request post category
    Then I get error 500

  Scenario: Create Category with filled form as anon user
    Given I set category url
    And I filled new category data
    When I request post category
    Then New category created

  Scenario: Create Category with empty form as anon user
    Given I set category url
    And I leave new category data empty
    When I request post category
    Then I get error 500