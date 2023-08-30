Feature: Language pack
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user i am able to add a new language Pack
      Given I click the Admin link
      And I click the Configuration dropdown menu button
      And I click the Language Package option
      And I click the Add button to add a new language to the packages
      And I select the Colognian from the list
      And I press the Save to add this new language to my packages
      Then I should be able to see the confirmation message that the language was succesfully saved
