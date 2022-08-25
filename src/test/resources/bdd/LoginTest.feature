// Can I have a review pls?

Feature: Test Login feature
  Try to login to Jira

  Scenario Outline: Can you login to Jira?
    Given The user is on the login page
    When I enter username "<userName>"
    And I enter password "<password>"
    Then I press login

    Examples:
      | userName   | password  |
      | invalid    | valid     |
      | valid      | invalid   |
      | valid      | valid     |