package tests;

import Base.BaseTest;
import Pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentReportManager;
import utils.Log;

public class loginTest extends BaseTest
{
    @Test (priority = 1)
    public void testLogin()
    {
        loginPage login = new loginPage(driver);
        tests.info("Adding credentials");
        Log.info("Entering username");
        login.enterUsername("student");

        Log.info("Entering password");
        login.enterPassword("Password123");

        tests.info("Clicking submit");
        Log.info("Clicking submit");
        login.clickSubmit();


        System.out.println("Page title is " + driver.getTitle());
        tests.pass("login success!");

    }

    @Test (priority = 2)
    public void titleCheck()
    {
        tests.info("Getting page title");
        Assert.assertEquals(driver.getTitle(),"Logged In Successfully | Practice Test Automation");
    }



}
