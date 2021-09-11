package FrameworkBuild;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class ValidateNavigationBar extends Base {
    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException
    {

        driver =initializeDriver();

    }

    @Test
    public void navBar() throws IOException {

        //driver=initializeDriver();
        driver.get(prop.getProperty("url"));

        LandingPage navObj = new LandingPage(driver);
        Assert.assertTrue(navObj.getnavBar().isDisplayed());
        log.info("Successful display of Navigation bar");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

}
