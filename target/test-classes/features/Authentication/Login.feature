Feature: Login
  As a User
  I want to login
  So I can use the website

  Scenario Outline: Login with username and password
    Given I set login url
    And I set <email> and <password>
    When I request post auth
    Then I get <result> as auth result

    Examples:
    | email | password | result |
    | "thaur@mail.com" | "thaurn" | "logged in" |
    | "thaur@mail.com" | "pinto" | "invalid error" |
    | "user@mail.com"  | ""  | "password error"     |
    | "" | "nasdade" | "email error" |
    | "naevis@mail.com" | "pass" | "user not found" |
    | "" | "" | "email error" |