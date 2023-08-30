Feature: Pending Approval Status for an Employee
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i want to se leave records with Pending Approval status for an employee then reset data
      Given I click on the Leave link on the menu
      And I select a specific period
      And I select to see only leave with Pending Approval status
      And I select Leave type as CAN Personal
      And I enter Anthony Nolan in the Employee Name field
      And I press the Search button
      And I click the Reset button
      Then I should see a pop-up message that says no records founds
