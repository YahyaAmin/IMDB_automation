package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Hooks.Base_Class.driver;

public class Login_Page {
    public static String sign_in_css = ".navbar__user";
    public static String sign_in_with_imdb_button_xpath = "//span[normalize-space()='Sign in with IMDb']";
    public static String email_field_css = "#ap_email";
    public static String password_field_css = "#ap_password";
    public static String sign_in_button_css = "#signInSubmit";
    public static String logged_in_user_menu_xpath = "//*[contains(@class, 'accountmenu-toggle navbar')]";

    public Login_Page() {
    }
    public static WebElement get_sign_in_css(){return driver.findElement(By.cssSelector(sign_in_css));}
    public static WebElement get_sign_in_with_imdb_button_xpath(){return driver.findElement(By.xpath(sign_in_with_imdb_button_xpath));}
    public static WebElement get_email_field_css(){return driver.findElement(By.cssSelector(email_field_css));}
    public static WebElement get_password_field_css(){return driver.findElement(By.cssSelector(password_field_css));}
    public static WebElement get_sign_in_button_css(){return driver.findElement(By.cssSelector(sign_in_button_css));}
    public static WebElement get_logged_in_user_menu_xpath(){return driver.findElement(By.xpath(logged_in_user_menu_xpath));}
}
