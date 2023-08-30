Feature: Vacation leave records for a certain period
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i want to see all the vacation leave records for a certain period
      Given I click on the Leave link on the menu
      And I select a specific period for which i want to see the records
      And I select to see only leave with Pending Approval status
      And I set Leave Type as US Vacation
      And I press search button
      Then I should see all the records with all the data entered
