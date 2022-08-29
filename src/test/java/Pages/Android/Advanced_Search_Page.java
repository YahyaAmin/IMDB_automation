package Pages.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Hooks.Base_Class.driver;

public class Advanced_Search_Page {

    public static String title_field_css = "input[name='title']";

    public static String feature_film_checkbox_xpath = "//*[@name=\"title_type\"][@value=\"feature\"]";

    public static String  result_title_css = "div[class='desc'] span";

    public static String tv_series_checkbox_css = "#title_type-3";

    public static String feature_film_assert_css = "h1[class='header']";

    public static String release_date_min_field_css = "input[name='release_date-min']";

    public static String release_date_max_field_css = "input[name='release_date-max']";
    public static String movie_name_xpath(String movie_name){return "(//a[contains(text(), '"+movie_name+"')])[1]";}

    public static String title_type_tv_movie_css = "#title_type-2";

    public static String min_rating_xpath = "//select[@name='user_rating-min']";

    public static String max_option_xpath(String abc){return "(//option[text()='"+abc+"'])[2]";}

    public static String max_rating_xpath = "//select[@name='user_rating-max']";

    public static String min_option_xpath(String abc){return "(//option[text()='"+abc+"'])[1]";}

    public static String tv_episode_checkbox_css = "#title_type-4";


    public Advanced_Search_Page() {
    }


    public static WebElement get_title_field_css(){return driver.findElement(By.cssSelector(title_field_css));}

    public static WebElement get_movie_name_xpath(String movie_name){return driver.findElement(By.xpath(movie_name_xpath(movie_name)));}

    public static WebElement get_result_title_css(){return driver.findElement(By.cssSelector(result_title_css));}

    public static WebElement get_feature_film_checkbox_xpath(){return driver.findElement(By.xpath(feature_film_checkbox_xpath));}

    public static WebElement get_feature_film_assert_css(){return driver.findElement(By.cssSelector(feature_film_assert_css));}

    public static WebElement get_title_type_css(){return driver.findElement(By.cssSelector(title_type_tv_movie_css));}

    public static WebElement get_tv_series_checkbox_css(){return driver.findElement(By.cssSelector(tv_series_checkbox_css));}

    public static WebElement get_tv_episode_checkbox_css(){return driver.findElement(By.cssSelector(tv_episode_checkbox_css));}

    public static WebElement get_release_date_min_field_css(){return driver.findElement(By.cssSelector(release_date_min_field_css));}

    public static WebElement get_release_date_max_field_css(){return driver.findElement(By.cssSelector(release_date_max_field_css));}

    public static WebElement get_min_rating_xpath(){return driver.findElement(By.xpath(min_rating_xpath));}

    public static WebElement get_min_option_xpath(String abcd){return driver.findElement(By.xpath(min_option_xpath(abcd)));}

    public static WebElement get_max_option_xpath(String abcd){return driver.findElement(By.xpath(max_option_xpath(abcd)));}
    public static WebElement get_max_rating_xpath(){return driver.findElement(By.xpath(max_rating_xpath));}
}
