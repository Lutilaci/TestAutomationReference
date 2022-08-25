Feature: Check are issues editable in JETI project

  Scenario Outline: Are JETI issues editable?
    Given Open issue <issue_id>
    Then I see the 'Edit' button

    Examples:
    |  issue_id  |
    | 'JETI-1'  |
    | 'JETI-2'  |
    | 'JETI-3'  |