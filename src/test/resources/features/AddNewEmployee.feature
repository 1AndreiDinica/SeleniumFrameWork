Feature: Automation Tester Vacancies
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user I am amble to add a new employee
      Given I click on the PIM option from the menu
      And I choose the Add Employee option
      And I add a profile picture for that employee
      And I enter the employee full name in the Employee section
      And I enter an employee id in the id field
      And I click on the Create Login Details button to make the option available
      And I add a username and password
      And I press the Save button PIM
      Then I should see a confirmation message that the employee was successfully saved