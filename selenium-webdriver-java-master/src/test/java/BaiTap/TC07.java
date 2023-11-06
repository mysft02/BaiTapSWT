package BaiTap;
//Verify that you will be able to save previously placed order as a pdf file
/*
        Test Steps:

        1. Go to http://live.techpanda.org/

        2. Click on My Account link

        3. Login in application using previously created credential

        4. Click on 'My Orders'

        5. Click on 'View Order'

        6. Click on 'Print Order' link
*/


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TC07 {
    public void Test_07(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Click on My Account link
            WebElement accElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]"));
            accElem.click();
            WebElement myAccElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[1]/a"));
            myAccElem.click();
            //Step 3. Login in application using previously created credential
            WebElement mailElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[1]/div/input"));
            mailElem.sendKeys("dungntse171487@fpt.edu.vn");
            WebElement pwdElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[2]/div/input"));
            pwdElem.sendKeys("123456");
            WebElement logElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[2]/button"));
            logElem.click();
            //Step 4. Click on 'My Orders'
            WebElement myOdElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a"));
            myOdElem.click();
            //Step 5. Click on 'View Order'
            WebElement viewOdElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]"));
            viewOdElem.click();
            //Step 6. Click on 'Print Order' link
            WebElement prtOdElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]"));
            prtOdElem.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
