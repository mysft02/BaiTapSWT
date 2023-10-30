package BaiTap;
//Verify that you are able to compare two product
/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class TC04 {
    public void Test_04() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Click on �MOBILE� menu
            WebElement mobileElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
            mobileElem.click();
            //Step 3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
            WebElement cmpSonyElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
            cmpSonyElem.click();
            WebElement cmpIPElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
            cmpIPElem.click();
            //Step 4. Click on �COMPARE� button. A popup window opens
            WebElement cmpElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button"));
            cmpElem.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //Step 5. Verify the pop-up window and check that the products are reflected in it
            //Heading "COMPARE PRODUCTS" with selected products in it.
            WebElement headerElem = driver.findElement(By.xpath("/html/body/div/div[1]/h1"));
            AssertJUnit.assertEquals("COMPARE PRODUCTS", headerElem.getText());
            WebElement item1Elem = driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[1]/h2/a"));
            AssertJUnit.assertEquals("SONY XPERIA", item1Elem.getText());
            WebElement item2Elem = driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[2]/h2/a"));
            AssertJUnit.assertEquals("IPHONE", item2Elem.getText());
            //Step 6. Close the Popup Windows
            WebElement closeElem = driver.findElement(By.xpath("/html/body/div/div[2]/button/span/span"));
            closeElem.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
