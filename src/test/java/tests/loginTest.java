package tests;

import Base.BaseTest;
import Pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class loginTest extends BaseTest
{
    @Test
    public void testLogin()
    {
        loginPage login = new loginPage(driver);
        login.enterUsername("student");
        login.enterPassword("Password123");
        login.clickSubmit();

        System.out.println("Page title is " + driver.getTitle());
    }



}
