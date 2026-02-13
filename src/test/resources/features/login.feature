Feature: SauceDemo Login

  Scenario: Login with multiple credentials
    Given user is on SauceDemo login page
    When user logs in using excel data
    Then products page should be displayed
