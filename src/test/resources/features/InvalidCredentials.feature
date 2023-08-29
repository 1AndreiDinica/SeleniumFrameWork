Feature: As a customer I want to login with my invalid credentials and receive the error message

  Scenario: Login with invalid credentials
    Given Customer navigates to the webpage
    When I enter invalid credentials
    And I press the Login button
    Then I receive the error message "Invalid credentials"

