Feature: SauceDemo Login

  Scenario: Successful login with valid credentials
    Given user is on SauceDemo login page
    When user logs in using valid credentials
    Then user should see Products page