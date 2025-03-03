Feature: Documentation

  Scenario: Zebrunner User Guide
    Given user is on Documentation page
    When select Core concepts
    Then select Projects
    Then select Test repository
    Then select Automation launches
    Then verify Automation launches page title

  Scenario: Test Case management
    Given user is on Documentation page
    When select Test Case management
    Then select TestRail
    Then select Xray

  Scenario: Testing platforms
    Given user is on Documentation page
    When select Testing platforms
    Then select Zebrunner Selenium Grid

  Scenario: Administration
    Given user is on Documentation page
    When select Administration
    Then select Onboarding

  Scenario: Zebrunner TestNG reporting agent
    Given user is on Documentation page
    When select Reporting concepts
    Then select Java
    Then select TestNG
    Then verify page title

