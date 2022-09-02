@RatingsFeature
Feature: Ratings Tests

  @TC13 @RatingsTest
  Scenario: User searches for a valid movie and checks its ratings
    #Only valid movie names will work for this test
    Given User searches for the movie "The Dark Knight"
    When  User clicks on the first movie
    And   User clicks on the imdb rating button
    Then  User should see the ratings for all demographics
