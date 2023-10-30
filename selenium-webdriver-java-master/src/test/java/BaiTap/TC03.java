package BaiTap;
//Verify that you cannot add more product in cart than the product available in store
/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty

 */

import driver.driverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class TC03 {
    public void Test_03() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Click on �MOBILE� menu
            WebElement mobileElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
            mobileElem.click();
            //Step 3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement sonyInfoElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span"));
            sonyInfoElem.click();
            //Step 4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
            //"The requested quantity for "Sony Xperia" is not available".
            WebElement quantiElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input"));
            quantiElem.click();
            quantiElem.clear();
            quantiElem.sendKeys("1000");
            WebElement updateElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button/span/span"));
            updateElem.click();
            //Step 5. Verify the error message
            WebElement errorElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[2]/p"));
            String error = errorElem.getText();
            AssertJUnit.assertEquals("The requested quantity for 'Sony Xperia' is not available", error);
            //AssertJUnit.assertEquals("* The maximum quantity allowed for purchase is 500.", error);
            //Step 6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            WebElement cartElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tfoot/tr/td/button[2]/span/span"));
            cartElem.click();
            WebElement noItemElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/h1"));
            //Step 7. Verify cart is empty
            AssertJUnit.assertEquals("SHOPPING CART IS EMPTY", noItemElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
