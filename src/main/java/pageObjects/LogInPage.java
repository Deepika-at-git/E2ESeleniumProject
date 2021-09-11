package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

    public WebDriver driver;

    By email = By.cssSelector("input[name='email']");
    By password = By.cssSelector("input[name=' password']");
    By login = By.cssSelector("input[value='Log In']");
    By forgotPassword = By.cssSelector("[href*='password/new']");

    public LogInPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getemail(){
        return driver.findElement(email);
    }

    public WebElement getpassword(){
        return driver.findElement(password);
    }

    public WebElement getlogin(){
        return driver.findElement(login);
    }

    public ForgotPassword getforgotPassword(){
        driver.findElement(forgotPassword).click();
        ForgotPassword fp = new ForgotPassword(driver);
        return fp;
    }

}
