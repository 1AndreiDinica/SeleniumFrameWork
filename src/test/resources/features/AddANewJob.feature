Feature: Add a new job
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i want to add a new Job
      Given I click the Admin link
      And I select Job Titles options from the Job menu dropdown
      And I click the Add button to add a new job
      And I add a name for the job in the Job Title field
      And I add a Job description
      And I add a Job Specification file
      And I click the Save button to add the new job
      Then I should see the confirmation message that the job was successfully added