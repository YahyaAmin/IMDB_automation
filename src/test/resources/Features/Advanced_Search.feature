@AdvancedSearchFeature
Feature: Advanced Search Tests

  Background:
    Given User navigates to advanced search page

  @TC03 @SearchTests
  Scenario: User searches for the movies by title and enters a valid movie name

    And User enters the title of movie "Batman"
    When User clicks Enter key
    Then User should see the relevant movie results for "Batman"


  @TC04 @SearchTests
  Scenario: User searches for the movies by title and enters an invalid movie name

    And User enters the title of movie "wlehfliwe"
    When User clicks Enter key
    Then User should see no results


  @TC05 @SearchTests
  Scenario: User searches for movie by title type Feature film

    And User clicks on feature film checkbox
    When User clicks Enter key
    Then User should be able to see all the feature films


  @TC06 @SearchTests
  Scenario: User searches for movie by title type TV-Movie

    And User clicks on tv-movie checkbox
    When User clicks Enter key
    Then User should be able to see all the tv-movies


  @TC07 @SearchTests
  Scenario: User searches for movie by title type TV-series

    And User clicks on tv-series checkbox
    When User clicks Enter key
    Then User should be able to see all the tv-series


  @TC08 @SearchTests
  Scenario: User searches for movie by release date

    And User enters the starting release date "1994-08"
    When User enters ending release date "1995-09"
    When User clicks Enter key
    Then User should be able to see all the movies during that time


  @TC09 @SearchTests
  Scenario: User seacrhes for movie by rating

    And User enters a minimum rating of "5.5"
    When User enters a max rating of "7.2"
    When User clicks Enter key
    Then User should be able to see the list of movies for that rating between "5.5" and "7.2"

























