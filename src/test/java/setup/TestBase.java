package setup;

import org.testng.ITestResult;
import org.testng.annotations.*;
import tests_utils.Helper;

import java.net.MalformedURLException;

public class TestBase extends AndroidSetUp {
    @BeforeSuite
    public void setUp() {
        try {
            prepareAndroidForSetUP();
        } catch (MalformedURLException e) {
            System.out.println("Error in setUp Process" + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        androidDriver.quit();
    }

    // take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(androidDriver, result.getName());
        }
    }

}
