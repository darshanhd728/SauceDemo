@login
Feature: SauceDemo Login

  Scenario Outline: Login with multiple credentials
    Given user is on SauceDemo login page
    When user logs in with "<username>" and "<password>"
    Then products page should be displayed

    Examples:
      | username        | password       |
      | performance_glitch_user1   | secret_sauce   |
      | problem_user1    | secret_sauce   |
      | standard_user  | secret_sauce |