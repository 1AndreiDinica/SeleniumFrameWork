Feature: Update Street and Country details
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i am able to update my street and country details
      Given I click the My Info options from the menu
      Then I click on the Contact Details link which will redirect me to the Details page
      And I update the Street field from the contact details
      And I select Algeria as a country
      And I press the save button
      Then I should see the successfully update message