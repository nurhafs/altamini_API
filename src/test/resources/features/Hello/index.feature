Feature: Hello
  As a user
  I want to use this feature
  So I can say hello

  Scenario: Hello
    Given I set hello url
    When i send get request
    Then I get reply