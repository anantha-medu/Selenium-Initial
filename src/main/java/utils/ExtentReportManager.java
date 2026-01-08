package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager
{
    private static ExtentReports extent;
    private static ExtentTest tests;

    public static ExtentReports getReportInstance()
    {
        if(extent == null)
        {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
            String reportPath = "reports/ExtentReport"+timestamp+".html";
            //System.out.println(reportPath);
            //this creates the report
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            //config method can add details and customize the report
            reporter.config().setDocumentTitle("Automation Test Results");
            reporter.config().setReportName("Test reports");

            extent = new ExtentReports();
            //assign the created reporter instance to ExtentReports variable
            extent.attachReporter(reporter);
        }
        return extent;
    }


    public static ExtentTest createTest(String testName)
    {
        tests = getReportInstance().createTest(testName);
        return tests;
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName)
    {
        try
        {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path= "../screenshots/" + screenshotName + ".png";
            FileUtils.copyFile(src,new File(path));
            return path;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
