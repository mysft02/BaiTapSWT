package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*
*  Verify you are able to change or reorder previously added product

 *  Test Data = QTY = 10

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on 'REORDER' link , change QTY & click Update

5. Verify Grand Total is changed

6. Complete Billing & Shipping Information

7. Verify order is generated and note the order number

Expected outcomes:

1) Grand Total is Changed

2) Order number is generated
 */

@Test
public class TC08 {
    public void Test_08(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            SoftAssert softassert= new SoftAssert();
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
            //Step 4. Click on 'REORDER' link , change QTY & click Update
            WebElement reOdElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr/td[6]/span/a[2]"));
            reOdElem.click();
            WebElement bfTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span"));
            String bfTot = bfTotElem.getText();
            System.out.println(bfTot);
            WebElement quantiElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input"));
            quantiElem.click();
            quantiElem.clear();
            quantiElem.sendKeys("10");
            WebElement clElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button"));
            clElem.click();

            //Step 5. Verify Grand Total is changed
            WebElement aftTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span"));
            String aftTot = aftTotElem.getText();
            System.out.println(aftTot);
            AssertJUnit.assertNotSame(bfTot, aftTot);
            //Step 6. Complete Billing & Shipping Information
            driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();

            try {
                Select sAddr = new Select(driver.findElement(By.name("billing_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception e){
                System.out.println("Bliing drop down error ");
            }

            driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("United States");
            WebElement selectCountry = driver.findElement(By.xpath("//select[@id='billing:country_id']"));
            Select checkoutCountry = new Select(selectCountry);
            checkoutCountry.selectByValue("US");

            WebElement region = driver.findElement(By.xpath("//select[@id='billing:region_id']"));
            Select regionSelect = new Select(region);
            regionSelect.selectByValue("2");
            driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']")).click();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

            Thread.sleep(3000);

            /*try {
                Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 2);
            } catch (Exception e){
                System.out.println("shipping drop down error ");
            }*/
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/ul/li[3]/label")).click();

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/div/button/span/span")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/label")).click();

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button/span/span")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button/span/span")).click();


            Thread.sleep(1000);
            WebElement orderId = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Your order # is: " + orderId.getText());
            WebElement verify = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            softassert.assertEquals(verify.getText(),"YOUR ORDER HAS BEEN RECEIVED.");
            softassert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
