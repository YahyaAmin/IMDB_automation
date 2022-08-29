@WatchlistFeature
Feature: Watchlist Test

  #Login Steps in background
  Background:
    Given User clicks on the sign in button
    And User clicks on sign in with IMDB button
    When User enters the email address "yahyaamin1997@gmail.com"
    And User enters the password "Vista123"
    When User clicks sign in button after entering details
    Then User should successfully sign in and see their username "Yahya" at the top right


  @TC02 @WatchlistTest
  Scenario: User adds/removes movies from their watchlist

    Given User clicks on the watchlist button
    And User clicks on browse popular movies
    When User adds the highest rated movie to their watchlist
    And User clicks on the watchlist button
    When User clicks on the edit button
    And User removes the first movie from watchlist
    When User clicks on the delete button
    Then User should see that the movie is deleted from watchlist


















