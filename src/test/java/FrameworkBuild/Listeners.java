package FrameworkBuild;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentTest test ;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS,"Test passed");
    }

    public void onTestFailure(ITestResult result){

        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;

        String testMethodName = result.getMethod().getMethodName();
        try{
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }catch (Exception e){

        }

        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
