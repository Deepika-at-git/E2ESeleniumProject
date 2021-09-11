package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

    public WebDriver driver;

    public  PracticePage(WebDriver driver){
        this.driver=driver;
    }

    By radio3 = By.cssSelector("input[value='radio3']");

    By country = By.cssSelector(".inputs.ui-autocomplete-input");

    By dropDown = By.id("dropdown-class-example");

    By checkBox = By.cssSelector("input[value='option2']");


    public WebElement getRadio3(){
        return driver.findElement(radio3);
    }

    public WebElement getCountry(){
        return driver.findElement(country);
    }

    public WebElement getdropDown(){
        return driver.findElement(dropDown);
    }

    public WebElement getcheckBox(){
        return driver.findElement(checkBox);
    }


}
