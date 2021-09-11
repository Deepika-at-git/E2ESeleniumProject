Feature: Login to the application

  Scenario Outline: Positive test validation
    Given Initialize browser with chrome
    And   Navigate to "https://qaclickacademy.com" site
    And   Click on Login in the home page to land to secure sign in
    When  User enters <username> and <password> and logs in
    Then  Verify user is not logged in with invalid credentials
    Examples:
      |username     |password
      |abc@abc.com  |abc
      |xyz@abc.com  |xyz
