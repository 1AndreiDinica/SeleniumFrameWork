Feature: Automation Tester Vacancies
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: Access an employees record
      Given I click on Maintenance option from menu
      And I enter the password to validate the admin credentials
      And I click the Confirm button
      And I click on the Access Records option
      And I enter Anthony Anadebe in the Employee Name
      And I click on the Search button
      Then I can see that the employee ID is displayed