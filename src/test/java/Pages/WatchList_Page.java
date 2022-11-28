package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Hooks.Base_Class.driver;

public class WatchList_Page {

    public static String watchlist_button_css = ".imdb-header__watchlist-button > a > div";
    public static String browse_popular_movies_button = "//a[normalize-space()='Browse Popular Movies']";
    public static String add_to_favorite_xpath = "//div[@data-tconst='tt0111161']";
    public static String edit_button_css = "a[title='Edit']";
    public static String checkbox_to_remove_watchlist_movie_xpath = "//*[@name='titleCheck']";
    public static String delete_button_css = "#delete_items";
    public static String delete_at_popup_xpath = "//*[@type='submit' and @value='DELETE']";
    public static String titles_in_watchlist_xpath = "//*[@class='list-number-items']";

    public WatchList_Page(){

    }
    public static WebElement get_watchlist_button_css(){return driver.findElement(By.cssSelector(watchlist_button_css));}
    public static WebElement get_browse_popular_movies_button(){return driver.findElement(By.xpath(browse_popular_movies_button));}
    public static WebElement get_add_to_favorite_xpath(){return driver.findElement(By.xpath(add_to_favorite_xpath));}
    public static WebElement get_edit_button_css(){return driver.findElement(By.cssSelector(edit_button_css));}
    public static WebElement checkbox_to_remove_watchlist_movie_xpath(){return driver.findElement(By.xpath(checkbox_to_remove_watchlist_movie_xpath));}
    public static WebElement get_delete_button_css(){return driver.findElement(By.cssSelector(delete_button_css));}
    public static WebElement get_delete_at_popup_xpath(){return driver.findElement(By.xpath(delete_at_popup_xpath));}
    public static WebElement get_titles_in_watchlist_xpath(){return driver.findElement(By.xpath(titles_in_watchlist_xpath));}
}
