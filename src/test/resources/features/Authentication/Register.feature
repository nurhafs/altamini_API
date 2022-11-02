Feature: Register
  As a new user
  I want to register
  So I can login

  Scenario: Register with new data
    Given I set register url
    When I set new data
    And I request post auth
    Then I am registered

  Scenario Outline: Register
    Given I set register url
    And I set "<email>" and "<password>" and "<fullname>" as data
    When I request post auth
    Then I get "<result>" as auth result

    Examples:
    | email | password | fullname | result |
    |       | password | fullname | email error |
    | sum@mail.com |   | fullname | password error |
    | sum@mail.com | password |  | fullname error |
    | someone@mail.com | 123123 | Firstname Lastname | duplicate error |