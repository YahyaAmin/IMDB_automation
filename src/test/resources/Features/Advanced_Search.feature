@AdvancedSearchFeature
Feature: Advanced Search Tests

  Background:
    Given User navigates to advanced search page

  @TC03 @SearchTests
  Scenario: User searches for the movies by title and enters a valid movie name
    When User enters the title of movie "Batman"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should see the relevant movie results for "Batman"

  @TC04 @SearchTests
  Scenario: User searches for the movies by title and enters an invalid movie name
    When User enters the title of movie "wlehfliwe"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should see no results

  @TC05 @SearchTests
  Scenario: User searches for movie by title type Feature film
    When User clicks on feature film checkbox
    When User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the feature films

  @TC06 @SearchTests
  Scenario: User searches for movie by title type TV-Movie
    When User clicks on tv-movie checkbox
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the tv-movies

  @TC07 @SearchTests
  Scenario: User searches for movie by title type TV-series
    When User clicks on tv-series checkbox
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the tv-series

  @TC08 @SearchTests
  Scenario: User searches for movie by release date
    When User enters the starting release date "1994-08"
    And  User enters ending release date "1995-09"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the movies during that time

  @TC09 @SearchTests
  Scenario: User searches for movie by rating
    When User scrolls down to ratings field
    And  User enters a minimum rating of "5.5"
    And  User enters a max rating of "7.2"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see the list of movies for that rating between "5.5" and "7.2"

  @TC10 @SearchTests
  Scenario: User searches for a movie using number of votes
    When User scrolls down to number of votes field
    And  User enters number of minimum votes "150"
    And  User enters maximum number of votes "155"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see the movies for votes between "150" and "155"

  @TC11 @SearchTests
  Scenario: User searches for a movie by genre
    When User scrolls down to the genres field
    And  User searches for their genre "Action"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the "Action" movies

  @TC12 @SearchTests
  Scenario: User searches for a movie by country
    When User scrolls down till country list
    And  User selects the country "India"
    And  User scrolls down to the search button
    And  User clicks on the search button
    Then User should be able to see all the movies of the country "India"