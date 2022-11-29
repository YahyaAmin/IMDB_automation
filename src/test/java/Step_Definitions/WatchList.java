package Step_Definitions;

import Pages.WatchList_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Hooks.Base_Class.driver;
import static Pages.WatchList_Page.*;
import static Step_Definitions.Advanced_Search.wait;

public class WatchList {

    //public WebDriverWait wait = new WebDriverWait(driver, 30);

    @Given("User clicks on the watchlist button")
    public void userClicksOnTheWatchlistButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(watchlist_button_css)));
        WatchList_Page.get_watchlist_button_css().click();
    }

    @And("User clicks on browse popular movies")
    public void userClicksOnBrowsePopularMovies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browse_popular_movies_button)));
        WatchList_Page.get_browse_popular_movies_button().click();
    }

    @When("User adds the highest rated movie to their watchlist")
    public void userAddsTheHighestRatedMovieToTheirWatchlist() throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.alertIsPresent());
        //steps to handle popup
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);

        //add to favorite
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_to_favorite_xpath)));
        WatchList_Page.get_add_to_favorite_xpath().click();
    }

    @When("User clicks on the edit button")
    public void userClicksOnTheEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(edit_button_css)));
        WatchList_Page.get_edit_button_css().click();
    }

    @And("User removes the first movie from watchlist")
    public void userRemovesTheFirstMovieFromWatchlist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkbox_to_remove_watchlist_movie_xpath)));
        WatchList_Page.checkbox_to_remove_watchlist_movie_xpath().click();

        //assert that the delete button is enabled
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(delete_button_css)));
        Assert.assertTrue(get_delete_button_css().isEnabled());
    }

    @When("User clicks on the delete button")
    public void userClicksOnTheDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(delete_button_css)));
        WatchList_Page.get_delete_button_css().click();
        WatchList_Page.get_delete_at_popup_xpath().click();
    }

    @Then("User should see that the movie is deleted from watchlist")
    public void userShouldSeeThatTheMovieIsDeletedFromWatchlist() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(delete_button_css)));
        Thread.sleep(2000);
        //assert that there are zero movies in the watchlist
        String test_text = WatchList_Page.get_titles_in_watchlist_xpath().getText();
        Assert.assertEquals(test_text,"0");
    }
}
