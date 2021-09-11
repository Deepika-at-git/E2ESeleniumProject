package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){

        this.driver=driver;
    }

    By login = By.cssSelector("a[href*='sign_in']");

    By title = By.xpath("//h2[text()='Featured Courses']");

    By naviBar = By.cssSelector(".nav.navbar-nav.navbar-right");


    public void getLogIn(){
        driver.findElement(login).click();
//        LogInPage objLogin = new LogInPage(driver);
//        return objLogin;
    }


    public WebElement getTitle(){
        return driver.findElement(title);
    }

    public WebElement getnavBar(){
        return driver.findElement(naviBar);
    }



}
