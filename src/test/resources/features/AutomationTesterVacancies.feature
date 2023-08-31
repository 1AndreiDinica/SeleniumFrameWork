Feature: Automation Tester Vacancies
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i can see all the Automation Tester Vacancies
      Given I click Recruitment link from menu
      And I click on the Vacancies option
      And I search for vacancies with job title Account Assistant
      Then I can see that all records are displayed for Account Assistant