@LoginFeature
Feature: Login Tests

  @TC01 @LoginTest
  Scenario: User successfully login to IMDB
    Given User clicks on the sign in button
    When  User clicks on sign in with IMDB button
    And   User enters the email address "yahyaamin1997@gmail.com"
    And   User enters the password "Vista123"
    And   User clicks sign in button after entering details
    Then  User should successfully sign in and see their username "Yahya" at the top right
