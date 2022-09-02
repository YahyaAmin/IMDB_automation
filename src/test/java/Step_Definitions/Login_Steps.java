package step_definitions;

import pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static hooks.Base_Class.driver;
import static pages.Login_Page.*;

public class Login_Steps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);

    @Given("User clicks on the sign in button")
    public void userClicksOnTheSignInButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sign_in_css)));
        Login_Page.get_sign_in_css().click();
    }

    @And("User clicks on sign in with IMDB button")
    public void userClicksOnSignInWithIMDBButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sign_in_with_imdb_button_xpath)));
        Login_Page.get_sign_in_with_imdb_button_xpath().click();
    }

    @When("User enters the email address {string}")
    public void userEntersTheEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(email_field_css)));
        Login_Page.get_email_field_css().clear();
        Login_Page.get_email_field_css().sendKeys(email);
    }

    @And("User enters the password {string}")
    public void userEntersThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(password_field_css)));
        Login_Page.get_password_field_css().clear();
        Login_Page.get_password_field_css().sendKeys(password);
    }

    @When("User clicks sign in button after entering details")
    public void userClicksSignInButtonAfterEnteringDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sign_in_button_css)));
        Login_Page.get_sign_in_button_css().click();
    }

    @Then("User should successfully sign in and see their username {string} at the top right")
    public void userShouldSuccessfullySignInAndSeeTheirUsernameAtTheTopRight(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logged_in_user_menu_xpath)));
        String user = Login_Page.get_logged_in_user_menu_xpath().getText();
        //assert that the user is logged in and can see their name at the top right
        Assert.assertEquals(user, username);
    }
}
