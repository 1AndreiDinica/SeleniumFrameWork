Feature: Language pack
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user I am able to change my password
      Given I select the Change Password option from drop-down user profile menu
      And I enter the current password in the Current Password field
      And I enter in the Password field a new password
      And I confirm the new password
      And I press the Save button to update the password
      Then I should be able to see the confirmation message it was saved