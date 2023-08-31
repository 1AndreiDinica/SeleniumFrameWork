Feature: Change Profile Picture
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i can change my profile picture
      Given I click the My Info options from the menu
      And I click on the profile picture
      And I add a picture
      And I click the Save button
      Then I can see that my profile picture has been updated