Feature: Add Attachment into my Contact Details
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i am able to add an attachment into my Contact Details
      Given I click the My Info options from the menu
      Then I click on the Contact Details link which will redirect me to the Details page
      And I click the Add Attachment button
      And I select to upload file
      And I add a comment on this document uploaded in the comment field
      And I press the Save button for this attachment added
      Then I am able to see my document added in the record found section


