package Step_Definitions;

import Pages.Android.Ratings_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;

import static Pages.Android.Ratings_Page.*;

import static Hooks.Base_Class.driver;

public class Ratings_Steps {


    public WebDriverWait wait = new WebDriverWait(driver, 30);




    @And("User clicks on the first movie")
    public void userClicksOnTheFirstMovie(){
        //click on movie steps
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(first_searched_movie_xpath)));
        Ratings_Page.get_first_searched_movie_xpath().click();

    }

    @Given("User searches for the movie {string}")
    public void userSearchesForTheMovie(String movie_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(search_movie_field_css)));
        Ratings_Page.get_search_movie_field_css().sendKeys(movie_name);
    }

    @When("User clicks on the imdb rating button")
    public void userClicksOnTheImdbRatingButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(star_button_for_rating_xpath)));
        Ratings_Page.get_star_button_for_rating_xpath().click();
    }

    @Then("User should see the ratings for all demographics")
    public void userShouldSeeTheRatingsForAllDemographics() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(allages_all_css)));

        //Assert that all other demographic elements are not null and are displayed
        //Iterate one by one to assert all items in list

        for(int i=0; i<get_demographics_object_css().size(); i++){

            Assert.assertTrue(get_demographics_object_css().get(i).isDisplayed()); //All elements in this list are displayed

            //Assertion to check that all elements have rating values which are not null
            String rating_of_each_element = get_demographics_object_css().get(i).getText();
            Assert.assertNotNull(rating_of_each_element);

        }



    }
}
