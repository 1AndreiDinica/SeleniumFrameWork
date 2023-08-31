Feature: Interview with a candidate
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i am able to schedule an interview with a candidate
      Given I click Recruitment link from menu
      And I click on the view icon in the Actions section to see a candidates's application Shortlisted
      And I click the Schedule interview button for the candidate
      And I add the title of the interview
      And I add two interviewers int the interviewer field
      And I select a date and hour
      And I press the Save button to schedule the interview
      Then I should see the confirmation message for this interview