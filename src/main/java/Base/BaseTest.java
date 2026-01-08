package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportManager;
import utils.Log;

import java.lang.reflect.Method;

public class BaseTest
{
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest tests;

    @BeforeSuite
    public void setupReport()
    {
        extent = ExtentReportManager.getReportInstance();
        Log.info("Setting up driver");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Log.info("Opened browser and url");
    }

    @AfterSuite
    public void tearDownReport()
    {
        extent.flush();
        if(driver != null)
        {
            Log.info("CLosing the browser..");
            driver.quit();
        }
    }

    @BeforeMethod
    public void setup(Method method)
    {
        tests = ExtentReportManager.createTest(method.getName());
        Log.info(method.getName()+" Test case started");
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        String screenshotPath = ExtentReportManager.captureScreenshot(driver,methodName);
        if(result.getStatus() == ITestResult.FAILURE)
        {
            tests.fail(methodName+" has failed!",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            Log.error("Test case "+ methodName + " failed");
        }

        if(result.getStatus()==ITestResult.SUCCESS)
        {
            tests.pass(methodName+" has completed!", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            Log.info("Test case "+ methodName + " is pass");
        }

    }
}
