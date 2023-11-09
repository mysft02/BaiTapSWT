package BaiTap;
/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/

import POM.CartAPI;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertNotEquals;

@Test
public class TC09 {
    public void Test_09() {
        WebDriver driver = driverFactory.getChromeDriver();
        String coupon = "GURU50";
        try {
            SoftAssert softassert = new SoftAssert();
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Go to Mobile and add IPHONE to cart
            CartAPI cart = new CartAPI(driver);
            cart.addMb("Iphone");
            //Step 3. Enter Coupon Code
            cart.inputCoupon(coupon);
            //Step 4. Verify the discount generated
            cart.checkDiscount(coupon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
