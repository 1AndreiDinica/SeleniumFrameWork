Feature: Delete a record from my Contact Details
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i am able to delete a record from my Contact Details
      Given I click the My Info options from the menu
      And I select the Contact Details link which will redirect me to the contact Details
      And I tick the checkbox to select one record saved in the Record Found
      And I press the Delete button to delete the record
      And I press Yes to confirm this deletion
      Then I should receive the confirmation message that the record has been deleted successfully
