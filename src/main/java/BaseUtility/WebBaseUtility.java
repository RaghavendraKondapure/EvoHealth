package BaseUtility;

import genralized_utillity.Log4j.Log;
import genralized_utillity.Screenshot.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebBaseUtility {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    //Before Class Annotation makes java function to run every time before a TestNG Test class
    @BeforeClass
    protected void CreateDriver() {
        try {

            //Initializing driver object
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();

            //Initializing explicit wait object
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            wait = new WebDriverWait(driver, 30);

        } catch (Exception e) {

            Log.error("Found issue initializing driver");
            System.out.println(e);
        }
    }

    //After Class Annotation makes java function to run every time after a TestNG Test class
    @AfterSuite
    public void End() {
        //quit the driver
        driver.quit();
    }


    //Capture Screenshot for failed testCases
    //Params : result - it gives test case pass/fail status
    @AfterMethod
    public void screenshotTest(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                Screenshot.getScreenshot(driver, result.getName());
            }
        } catch (Exception e) {
            Log.error("Screenshot method Issue");
            System.out.println(e);
        }
    }

}


