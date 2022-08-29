package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static Hooks.Base_Class.driver;


public class Scroll
{
    public static void ScrollVertical(WebElement Element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page Horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

    }
}