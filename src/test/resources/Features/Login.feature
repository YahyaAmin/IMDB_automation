@LoginFeature
Feature: Login Tests

  @TC01 @LoginTest
  Scenario: User successfully login to IMDB

    Given User clicks on the sign in button
    And User clicks on sign in with IMDB button
    When User enters the email address "yahyaamin1997@gmail.com"
    And User enters the password "Vista123"
    When User clicks sign in button after entering details
    Then User should successfully sign in and see their username "Yahya" at the top right

















