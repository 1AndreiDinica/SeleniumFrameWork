Feature: Rejected Status added correctly
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user I can verify that the Rejected status is correctly added to the leave records search
      Given I click the Leave link from the menu
      And I select the Rejected status from the Show Leave with Status section
      Then I check that the Rejected status is present as a selection

