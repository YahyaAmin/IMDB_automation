package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;

public class Base_Class {

    public static WebDriver driver = null;

    @Before
    public void setup() {
        try {
            System.setProperty("webdriver.chrome.driver", "apps/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            URL url = new URL("https://www.imdb.com/");
            driver.navigate().to(url);
        } catch(Exception exp){
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    @After
    public void teardown(){
        driver.quit();
    }
}