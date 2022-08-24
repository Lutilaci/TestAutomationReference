Feature: Cancel edit issue
  During editing an issue you try to cancel it

  Scenario: After cancel you are not able to see the edited issue name
    Given As valid user I am logged-in to Jira
    And Navigate to MTP-2235
    When I click to 'Edit' button
    And I change summary to 'Happy Path Cancel'
    And I click 'Cancel' button
    And I accept alert window
    When I refresh the page
    Then Expected summary is 'Happy Path'
