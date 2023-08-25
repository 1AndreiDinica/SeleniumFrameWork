Feature: As a customer I want to login with my valid credentials and check that my username is displayed in the navigation bar

  Scenario: Login with valid credentials
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button
    Then I verify the username is displayed in the right corner of the navigation bar