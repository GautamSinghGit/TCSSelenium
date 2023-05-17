package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentTestNG {


    public static ExtentReports report(){

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Spark.html");

        extentSparkReporter.config().setReportName("Test Automation");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("QA CLick Academy");


        ExtentReports extentReporter  = new ExtentReports();
        extentReporter.attachReporter(extentSparkReporter);

        extentReporter.setSystemInfo("author","Tiwari Seth");
        extentReporter.setSystemInfo("Machine","Windows");

        return extentReporter;


    }
}
