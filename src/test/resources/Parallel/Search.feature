Feature: Search

 Background:
   Given user open url
   Then  page title should be "Google"
   Then  Verify Google logo is displayed On GooglePage
   When  I search for "selenium training"
   And   I clicked "selenium training"


  @search1
  Scenario: 1 - Search test 1
    Then  "Tümü" is visible
    Then  Verify Google logo is displayed On SearchPage

  @search2
  Scenario: 2 - Search test 2
    Then  "Tümü" is visible
    Then  Verify Google logo is displayed On SearchPage
    And   Scroll to x 0 y 1000
    And   I wait for 3 seconds
    When  Scroll to Google Logo On bottom of the page
    And   I wait for 3 seconds

