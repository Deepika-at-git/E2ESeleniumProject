package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection {

    public static void main(String[] args) throws SQLException, InterruptedException {


        //DAtabase connection
        String host="localhost";
        String port="3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo","root","password");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select username from Credentials where userpassword='abcp'"); //this will be pointing to base index
        rs.next(); //pointing to first index
        System.setProperty("webdriver.chrome.driver","/Users/raghguru/Desktop/Selenium-Dpka/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/sign_in/password/new/index.php");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(rs.getString("username"));
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

}
