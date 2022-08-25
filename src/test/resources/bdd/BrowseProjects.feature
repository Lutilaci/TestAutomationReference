Feature: Check TOUCAN project

  Scenario Outline: Check TOUCAN project
    Given Open project <project>
    Then Check is the current project is <project>

    Examples:
      |  project  |
      |  'JETI'   |
      |  'COALA'  |
      |  'TOUCAN' |
      |   'MTP'   |