@google
Feature: Google

  Background:
    Given user open url
    Then page title should be "Google"
    Then Verify Google logo is displayed On GooglePage

  Scenario Outline: google Test

    When  I search for "<searchText>"
    And   I clicked "<clickedText>"

    Examples:
      |searchText                       |clickedText              |
      |selenium training                |selenium training course |
      |selenium training                |selenium training        |




