@login
Feature: SauceDemo Login

  Scenario: Login with multiple credentials
    Given user is on SauceDemo login page
    When user logs in using excel data
    Then products page should be displayed

    Examples:
      | username        | password       |
      | performance_glitch_user1   | secret_sauce   |
      | problem_user1    | secret_sauce   |
      | standard_user  | secret_sauce |
