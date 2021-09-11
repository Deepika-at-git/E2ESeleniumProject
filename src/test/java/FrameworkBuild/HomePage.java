package FrameworkBuild;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class HomePage extends Base {

    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException
    {

        driver =initializeDriver();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String email, String password, String text) throws IOException, SQLException {
//        driver=initializeDriver();
//        log.info("Initializing Driver");
        driver.get(prop.getProperty("url"));

        LandingPage objL = new LandingPage(driver);
        objL.getLogIn();

        LogInPage objLogin = new LogInPage(driver);
        objLogin.getemail().sendKeys(email);
        objLogin.getpassword().sendKeys(password);
        System.out.println(text);
        objLogin.getlogin().click();
        log.info("Successful entry of login details");

        ForgotPassword fp=objLogin.getforgotPassword();
        fp.getemail().sendKeys("abc@abc.com");
        fp.getsendMeInstruction().click();

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][3];

        data[0][0]="user1@abc.com";
        data[0][1]="user1";
        data[0][2]="User1 login";

        data[1][0]="user2@abc.com";
        data[1][1]="user2";
        data[1][2]="User2 login";


        return data;
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }



}
