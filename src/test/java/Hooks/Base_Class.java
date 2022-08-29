package Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidElement;


import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.time.Duration;


public class Base_Class {

    //AppiumDriver driver;
    //public static AppiumDriver<AndroidElement> driver;
    public static WebDriver driver = null;


    @Before
    public void setup() {


        try {
            /*DesiredCapabilities caps = new DesiredCapabilities();

            //System.out.println(caps);

            String projectpath = System.getProperty("user.dir");
            File f = new File("apps");
            File fs = new File(f,"app.apk");
            String finalpath = projectpath+'\\'+fs;


            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung");
            caps.setCapability(MobileCapabilityType.UDID, "R58M87RMRDM");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");
            caps.setCapability(MobileCapabilityType.APP,finalpath);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

            URL url = new URL("http://10.40.5.218:49525/");

            driver = new AndroidDriver<AndroidElement>(url, caps);
            */
            String projectpath = System.getProperty("user.dir");
            //System.out.println("Project path is:" + projectpath);

            System.setProperty("webdriver.chrome.driver", "apps/chromedriver.exe");
            driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
            driver.manage().window().maximize();
            //System.setProperty("webdriver.chrome.whitelistedIps", "");
            URL url = new URL("https://www.imdb.com/");
            driver.navigate().to(url);



        }




        catch(Exception exp){
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
