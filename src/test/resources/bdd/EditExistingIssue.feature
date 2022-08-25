Feature: Edit an existing issue
  Edit an existing issue and check the result

  Scenario: Edit an existing issue
    Given You are logged in and open 'MTP-2235' issue
    When You click on 'Edit' button
    And Rename the summary to 'Happy Path Edit'
    And Update the issue
    Then The summary should be changed to 'Happy Path Edit'
    Then Restore changes

