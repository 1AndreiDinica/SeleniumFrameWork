Feature: Rejected Records Status
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i want to display all the leave records in Rejected status
      Given I click on the Leave link on the menu
      And I click on the Leave List option
      And I selected Rejected Status by filtering the Show Leave Section
      Then I check that the Rejected status is present as a selection there
