Feature: Add comment for a leave request
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i can add a comment for a leave request
      Given I click on the Leave link on the menu
      And I click on the button with the three dots in the employee record
      And I select to Add Comment from that list
      And I enter a comment in the Leave Request Comments section
      And I save the comment
      Then I should be able to see the confirmation message that the comment was added