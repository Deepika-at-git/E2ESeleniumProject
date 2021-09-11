package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeLandingPage {

    public WebDriver driver;

    public PracticeLandingPage(WebDriver driver){
        this.driver=driver;
    }

    By practice = By.cssSelector("a[href*='AutomationPractice']");


    public WebElement getPractice(){
        return driver.findElement(practice);
    }




}
