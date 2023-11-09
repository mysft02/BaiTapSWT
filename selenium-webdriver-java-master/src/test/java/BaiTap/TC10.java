package BaiTap;
/*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.

*/

import POM.LoginAPI;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

@Test
public class TC10 {
    public void Test_10() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            SoftAssert softassert = new SoftAssert();
            //Step 1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            //Step 2. Login the credentials provided
            LoginAPI loginPage = new LoginAPI(driver);
            loginPage.inputUsername("user01");
            loginPage.inputPassword("guru99com");
            //Step 3. Go to Sales-> Orders menu
            loginPage.Order();
            //Step 4. Input OrderId and FromDate -> ToDate
            loginPage.inputInfo();
            //Step 5.Click Search button
            //Step 6. Screenshot capture.
            Thread.sleep(2000);
            File dest = new File("C:\\Users\\Admin\\Downloads\\Compressed\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\Capture");
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File screenshot1 = screenshot.getScreenshotAs(OutputType.FILE);
            File filterPage = new File(dest, "TC10.png");
            FileHandler.copy(screenshot1, filterPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
