package FrameworkBuild;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PracticeLandingPage;
import pageObjects.PracticePage;
import resources.Base;

import java.io.IOException;
import java.util.List;

public class ValidatePracticeLandingPage extends Base {

    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException
    {

        driver =initializeDriver();

    }


    @Test
    public void validatePractice() throws IOException, InterruptedException {
        //driver=initializeDriver();
        driver.get(prop.getProperty("url"));

        PracticeLandingPage objPrac = new PracticeLandingPage(driver);
        objPrac.getPractice().click();
        log.info("Successful click on Practice");

        PracticePage objPP = new PracticePage(driver);
        //radio button click
        objPP.getRadio3().click();

        //Autocomplete dropdown
        objPP.getCountry().sendKeys(prop.getProperty("text"));
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

        for(WebElement value:options){

            if(value.getText().equalsIgnoreCase(prop.getProperty("country"))){
                value.click();
                break;
            }
        }

        //Dropdown Example
        Thread.sleep(2000);
        WebElement dropdownSelect = objPP.getdropDown();
        Select ddOption = new Select(dropdownSelect);
        ddOption.selectByVisibleText(prop.getProperty("dropdown"));

        //Checkbox example
        Thread.sleep(2000);
        objPP.getcheckBox().click();

        log.info("Successful validating Practice page");


    }

    @AfterTest
    public void teardown(){
        driver.close();
    }


}
