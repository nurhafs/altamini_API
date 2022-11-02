Feature: Get User Information
  As a user
  I want to get my information
  So I can see my profile

  Scenario: Get User Information with token
    Given I set user info url
    When I request get user with token
    Then I get user information

  Scenario: Get User Information without token
    Given I set user info url
    When I request get user without token
    Then I get unauthorized error
