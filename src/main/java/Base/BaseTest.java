package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Log;

import java.time.Duration;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        Log.info("Setting up driver");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Log.info("Opened browser and url");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @AfterMethod
    public void tearDown()
    {
        if(driver != null)
        {
            Log.info("CLosing the browser..");
            driver.quit();
        }
    }
}
