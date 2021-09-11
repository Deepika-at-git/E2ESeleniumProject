package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
        prop.load(fis);
        //String browserName=System.getProperty("browser");//this is to run through maven command mvn test -Dbrowser=chrome
        String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome")){

            System.setProperty("webdriver.chrome.driver","/Users/raghguru/Desktop/Selenium-Dpka/chromedriver");
            ChromeOptions options = new ChromeOptions();

            if(browserName.contains("headless")) {
                options.addArguments("--headless");

            }
            driver = new ChromeDriver(options);
        }

//        else if(browserName.equals("firefox")){
//
//
//
//        }
//
//        else if(browserName.equals("IE")){
//
//        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException{

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports1/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

}
