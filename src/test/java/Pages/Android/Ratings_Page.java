package Pages.Android;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Hooks.Base_Class.driver;

public class Ratings_Page {

    public static String search_movie_field_css = "#suggestion-search";

    public static String first_searched_movie_xpath = "//*[@id=\"react-autowhatever-1--item-0\"]/a/div[2]";

    public static String star_button_for_rating_xpath = "//*[@class='sc-7ab21ed2-1 jGRxWM']";

    public static String allages_all_css = "td[class='ratingTable Selected'] div[class='bigcell']";


    public Ratings_Page() {
    }


    public static WebElement get_search_movie_field_css(){return driver.findElement(By.cssSelector(search_movie_field_css));}

    public static WebElement get_first_searched_movie_xpath(){return driver.findElement(By.xpath(first_searched_movie_xpath));}

    public static WebElement get_star_button_for_rating_xpath(){return driver.findElement(By.xpath(star_button_for_rating_xpath));}

    public static WebElement get_allages_all_css(){return driver.findElement(By.cssSelector(allages_all_css));}

}
