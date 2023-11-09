package BaiTap;
/* Verify user is able to purchase product using registered email id (USE CHROME BROWSER)

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number

 */

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Test
public class TC06 {
    public static void Test_06(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            SoftAssert softassert= new SoftAssert();
            driver.get("http://live.techpanda.org/");
            driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
            driver.findElement(By.xpath("//a[contains(@title,'Log In')]")).click();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sadfgsdg@gmail.com");
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[@id='send2']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
            driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
            WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
            Select countrySelect = new Select(country);
            countrySelect.selectByValue("US");

            WebElement state = driver.findElement(By.xpath("//select[@id='region_id']"));
            Select stateSelect = new Select(state);
            stateSelect.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("123456");
            driver.findElement(By.xpath("//span[contains(text(),'Estimate')]")).click();
            WebElement price = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));
            WebElement priceName = driver.findElement(By.cssSelector("dl[class='sp-methods'] dt"));
            softassert.assertEquals(priceName.getText(), "Flat Rate");
            System.out.println(priceName.getText() +": " + price.getText());

            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[2]/dl[1]/dd[1]/ul[1]/li[1]/label[1]")).click();
            driver.findElement(By.xpath("//button[@title='Update Total']")).click();
            WebElement genratePrice = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)"));
            WebElement newPrice = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));
            softassert.assertEquals(newPrice.getText(),genratePrice.getText());
            driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();

            try {
                Select sAddr = new Select(driver.findElement(By.name("billing_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception e){
                System.out.println("Bliing drop down error ");
            }

            driver.findElement(By.xpath("//input[@id='billing:firstname']")).sendKeys("Test");
            driver.findElement(By.xpath("//input[@id='billing:middlename']")).sendKeys("Soft");
            driver.findElement(By.xpath("//input[@id='billing:lastname']")).sendKeys("Ware");
            driver.findElement(By.xpath("//input[@id='billing:company']")).sendKeys("FPT");
            driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("123 ABC");
            driver.findElement(By.xpath("//input[@id='billing:street2']")).sendKeys("456 ABC");
            driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("United States");
            WebElement selectCountry = driver.findElement(By.xpath("//select[@id='billing:country_id']"));
            Select checkoutCountry = new Select(selectCountry);
            checkoutCountry.selectByValue("US");

            WebElement region = driver.findElement(By.xpath("//select[@id='billing:region_id']"));
            Select regionSelect = new Select(region);
            regionSelect.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys("123456");
            driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys("0123456789");
            driver.findElement(By.xpath("//input[@id='billing:fax']")).sendKeys("123456789");
            driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']")).click();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

            Thread.sleep(3000);

            try {
                Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception e){
                System.out.println("shipping drop down error ");
            }

            driver.findElement(By.xpath("//input[@id='shipping:firstname']")).sendKeys("Test");
            driver.findElement(By.xpath("//input[@id='shipping:middlename']")).sendKeys("Soft");
            driver.findElement(By.xpath("//input[@id='shipping:lastname']")).sendKeys("Ware");
            driver.findElement(By.xpath("//input[@id='shipping:company']")).sendKeys("FPT");
            driver.findElement(By.xpath("//input[@id='shipping:street1']")).sendKeys("123 ABC");
            driver.findElement(By.xpath("//input[@id='shipping:street2']")).sendKeys("456 ABC");
            driver.findElement(By.xpath("//input[@id='shipping:city']")).sendKeys("United States");
            WebElement selectedCountry = driver.findElement(By.xpath("//select[@id='shipping:country_id']"));
            Select checkout = new Select(selectedCountry);
            checkout.selectByValue("US");

            WebElement regioned = driver.findElement(By.xpath("//select[@id='shipping:region_id']"));
            Select selectedRegion = new Select(regioned);
            selectedRegion.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='shipping:postcode']")).sendKeys("123456");
            driver.findElement(By.xpath("//input[@id='shipping:telephone']")).sendKeys("0123456789");
            driver.findElement(By.xpath("//input[@id='shipping:fax']")).sendKeys("123456789");
            driver.findElement(By.xpath("//button[@onclick='shipping.save()']")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();

            driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//button[@title='Place Order']")).click();


            Thread.sleep(1000);
            WebElement orderId = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Your order # is: " + orderId.getText());
            WebElement verify = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            softassert.assertEquals(verify.getText(),"YOUR ORDER HAS BEEN RECEIVED.");
            softassert.assertAll();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
