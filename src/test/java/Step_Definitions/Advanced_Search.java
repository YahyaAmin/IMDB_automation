package Step_Definitions;

import Pages.Advanced_Search_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Hooks.Base_Class.driver;
import static Pages.Advanced_Search_Page.*;
import static Utils.Scroll.ScrollVertical;

public class Advanced_Search {
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    @Given("User navigates to advanced search page")
    public void userNavigatesToAdvancedSearchPage() {
        driver.navigate().to("https://www.imdb.com/search/title/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
    }

    @And("User enters the title of movie {string}")
    public void userEntersTheTitleOfMovie(String movie_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        Advanced_Search_Page.get_title_field_css().sendKeys(movie_name);
    }

    @When("User clicks Enter key")
    public void userClicksEnterKey() throws AWTException, InterruptedException {
        Advanced_Search_Page.get_title_field_css().click();
        //steps to handle popup
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Then("User should see the relevant movie results for {string}")
    public void userShouldSeeTheRelevantMovieResultsFor(String movie) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(movie_name_xpath(movie))));
        String title = get_movie_name_xpath(movie).getText();
        Assert.assertTrue(title.contains(movie));
    }
    @Then("User should see no results")
    public void userShouldSeeNoResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(result_title_css)));
        String result_text = get_result_title_css().getText();
        Assert.assertEquals(result_text, "No results.");
    }

    @And("User clicks on feature film checkbox")
    public void userClicksOnFeatureFilmCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(feature_film_checkbox_xpath)));
        Advanced_Search_Page.get_feature_film_checkbox_xpath().click();
    }

    @Then("User should be able to see all the feature films")
    public void userShouldBeAbleToSeeAllTheFeatureFilms() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assert title at the top. Title should contain feature film
        String text = get_feature_film_assert_css().getText();
        Assert.assertTrue(text.contains("Feature"));
    }

    @And("User clicks on tv-movie checkbox")
    public void userClicksOnTvMovieCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        Advanced_Search_Page.get_title_type_css().click();
    }

    @Then("User should be able to see all the tv-movies")
    public void userShouldBeAbleToSeeAllTheTvMovies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assert title at the top. Title should contain feature film
        String text = get_feature_film_assert_css().getText();
        Assert.assertTrue(text.contains("TV Movie"));
    }

    @And("User clicks on tv-series checkbox")
    public void userClicksOnTvSeriesCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        Advanced_Search_Page.get_tv_series_checkbox_css().click();
    }

    @Then("User should be able to see all the tv-series")
    public void userShouldBeAbleToSeeAllTheTvSeries() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assert title at the top. Title should contain feature film
        String text = get_feature_film_assert_css().getText();
        Assert.assertTrue(text.contains("TV Series"));
    }

    @And("User clicks on tv-episode checkbox")
    public void userClicksOnTvEpisodeCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        Advanced_Search_Page.get_tv_episode_checkbox_css().click();
    }

    @Then("User should be able to see all the tv-episode")
    public void userShouldBeAbleToSeeAllTheTvEpisode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assert title at the top. Title should contain feature film
        String text = get_feature_film_assert_css().getText();
        Assert.assertTrue(text.contains("ABC"));
    }

    @And("User enters the starting release date {string}")
    public void userEntersTheStartingReleaseDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        Advanced_Search_Page.get_release_date_min_field_css().sendKeys(date);
    }

    @When("User enters ending release date {string}")
    public void userEntersEndingReleaseDate(String date) {
        Advanced_Search_Page.get_release_date_max_field_css().sendKeys(date);
    }

    @Then("User should be able to see all the movies during that time")
    public void userShouldBeAbleToSeeAllTheMoviesDuringThatTime() throws InterruptedException {
        Thread.sleep(4000);
    }

    @And("User enters a minimum rating of {string}")
    public void userEntersAMinimumRatingOf(String min_rating) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(min_rating_xpath)));
        Advanced_Search_Page.get_min_rating_xpath().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(min_option_xpath(min_rating))));
        Advanced_Search_Page.get_min_option_xpath(min_rating).click();
        Advanced_Search_Page.get_min_option_xpath(min_rating).click();
        Advanced_Search_Page.get_min_rating_xpath().click();
    }

    @When("User enters a max rating of {string}")
    public void userEntersAMaxRatingOf(String max_rating) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(max_rating_xpath)));
        Advanced_Search_Page.get_max_rating_xpath().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(max_option_xpath(max_rating))));
        Advanced_Search_Page.get_max_option_xpath(max_rating).click();
        Advanced_Search_Page.get_max_option_xpath(max_rating).click();
        Advanced_Search_Page.get_max_rating_xpath().click();
    }


    @Then("User should be able to see the list of movies for that rating between {string} and {string}")
    public void userShouldBeAbleToSeeTheListOfMoviesForThatRatingBetweenAnd(String min_rating, String max_rating) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));
        //assertion
        String text_to_assert = Advanced_Search_Page.get_feature_film_assert_css().getText();
        Assert.assertTrue(text_to_assert.contains("Rating between "+min_rating+" and "+max_rating));
    }

    @When("User scrolls down to ratings field")
    public void userScrollsDownToRatingsField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        ScrollVertical(get_min_rating_xpath());
    }

    @When("User scrolls down to number of votes field")
    public void userScrollsDownToNumberOfVotesField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        ScrollVertical(get_min_votes_field_css());
    }

    @And("User enters number of minimum votes {string}")
    public void userEntersNumberOfMinimumVotes(String min_vote) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(min_votes_field_css)));
        get_min_votes_field_css().sendKeys(min_vote);
    }

    @When("User enters maximum number of votes {string}")
    public void userEntersMaximumNumberOfVotes(String max_vote) {
        get_max_votes_field_css().sendKeys(max_vote);
    }

    @Then("User should be able to see the movies for votes between {string} and {string}")
    public void userShouldBeAbleToSeeTheMoviesForVotesBetweenAnd(String mn_vote, String mx_vote) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assertion
        String text_to_assert = Advanced_Search_Page.get_feature_film_assert_css().getText();
        Assert.assertTrue(text_to_assert.contains("Rating Count between "+mn_vote+" and "+mx_vote));
    }

    @When("User scrolls down to the genres field")
    public void userScrollsDownToTheGenresField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        ScrollVertical(get_wait_genres_xpath());
    }

    @And("User searches for their genre {string}")
    public void userSearchesForTheirGenre(String genre_name) {
       genre_name= genre_name.toLowerCase();
       genre_name = genre_name.replace("-", "_");
        System.out.println("String val" + genre_name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wait_genres_xpath)));
        Advanced_Search_Page.get_dynamic_genre_xpath(genre_name).click();
    }

    @When("User scrolls down to the search button")
    public void userScrollsDownToTheSearchButton() {
        ScrollVertical(get_search_button_xpath());
    }

    @And("User clicks on the search button")
    public void clicksOnTheSearchButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search_button_xpath)));
        Advanced_Search_Page.get_search_button_xpath().click();
    }

    @Then("User should be able to see all the {string} movies")
    public void userShouldBeAbleToSeeAllTheMovies(String genre_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assertion
        String text_to_assert = Advanced_Search_Page.get_feature_film_assert_css().getText();
        Assert.assertTrue(text_to_assert.contains(genre_name+" Movies and TV Shows"));
    }

    @When("User scrolls down till country list")
    public void userScrollsDownTillCountryList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title_field_css)));
        ScrollVertical(get_country_list_xpath());
    }

    @And("User selects the country {string}")
    public void userSelectsTheCountry(String country) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(country_list_xpath)));
        get_dynamic_country_search_xpath(country).click();
    }

    @Then("User should be able to see all the movies of the country {string}")
    public void userShouldBeAbleToSeeAllTheMoviesOfTheCountry(String country_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(feature_film_assert_css)));

        //assertion
        String text_to_assert = Advanced_Search_Page.get_feature_film_assert_css().getText();
        Assert.assertTrue(text_to_assert.contains(country_name));
    }
}
