package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenTest extends ExtentTestNG implements ITestListener{

   public ExtentTest test;
    public  ExtentReports extentReport = ExtentTestNG.report();
    public BaseClass baseClass = new BaseClass();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
            test = extentReport.createTest(result.getMethod().getMethodName());
            extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String image =null;
        extentTest.get().log(Status.PASS,result.getMethod().getMethodName());
        try {
            image  = baseClass.getScreenshot(result.getMethod().getMethodName(),HelperPage.driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(image);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String image =null;
        String errro = String.valueOf(result.getThrowable());
        extentTest.get().fail(errro);
        try {
            WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            image  = baseClass.getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(image);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
            extentReport.flush();
    }
}
