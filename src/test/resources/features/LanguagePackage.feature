Feature: Language Packages
  Background: User is Logged in
    Given Customer navigates to the webpage
    When I enter my valid username and password
    And I press the Login button

    Scenario: As a user I am able to access the Language Packages
      Given I click the Admin link
      And I click the Configuration dropdown menu button
      And I click the Language Package option
      And I click on the Translate button for Spanish
      Then I should be redirected to the language Customization page