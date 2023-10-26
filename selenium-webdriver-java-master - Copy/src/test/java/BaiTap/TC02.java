package BaiTap;
/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class TC02 {
    public void Test_02(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Click on �MOBILE� menu
            WebElement mobileElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
            mobileElem.click();
            //Step 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            WebElement sortElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
            Select select = new Select(sortElem);
            select.selectByVisibleText("Name");
            WebElement sonyElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[1]/span/span"));
            String innerText = sonyElem.getText();
            System.out.println(innerText);
            //Step 4. Click on Sony Xperia mobile
            WebElement sonyInfoElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a"));
            sonyInfoElem.click();
            //Step 5. Read the Sony Xperia mobile from detail page.
            WebElement desElem = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/dl/dd[1]/div/div"));
            String des = desElem.getText();
            System.out.println(des);
            //Step 6. Compare Product value in list and details page should be equal ($100).
            WebElement priceElem = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div/span/span"));
            String price = priceElem.getText();
            if(price.equals(innerText)){
                System.out.println("Prices are equal!");
            }else{
                System.out.println("Prices are not equal!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
