package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    WebDriver driver;
    By email = By.id("user_email");
    By sendMeInstruction = By.cssSelector("[value='Send Me Instruction']");

    public ForgotPassword(WebDriver driver){
        this.driver=driver;
    }
    public WebElement getemail(){
        return driver.findElement(email);
    }

    public WebElement getsendMeInstruction(){
        return driver.findElement(sendMeInstruction);
    }

}
