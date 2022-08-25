Feature: Check project types available

  Scenario Outline: Check project types available
    Given Open project <project>
    Then Check is the current project is <project>

    Examples:
      |  project  |
      |  'JETI'   |
      |  'COALA'  |
      |  'TOUCAN' |
      |   'MTP'   |