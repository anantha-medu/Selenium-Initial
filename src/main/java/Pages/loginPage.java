package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginPage
{
    private WebDriver driver;

    private By usernameText = By.xpath("//*[@id=\"username\"]");
    private By passwordText = By.xpath("//*[@id=\"password\"]");
    private By submitButton = By.xpath("//*[@id=\"submit\"]");

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterUsername(String username)
    {
        driver.findElement(usernameText).clear();
        driver.findElement(usernameText).sendKeys(username);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(pwd);
    }

    public void clickSubmit()
    {
        driver.findElement(submitButton).click();
    }
}
