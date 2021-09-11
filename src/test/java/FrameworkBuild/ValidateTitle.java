package FrameworkBuild;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class ValidateTitle extends Base {

    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver =initializeDriver();
    }

    @Test
    public void navigateToLandingPage() throws IOException {
        //driver=initializeDriver();
        driver.get(prop.getProperty("url"));

        LandingPage objval = new LandingPage(driver);
        String actual = objval.getTitle().getText();
        String expected = "FEATURED_COURSES";
        Assert.assertEquals(actual,expected);
        log.info("Successful validation of the Title");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
