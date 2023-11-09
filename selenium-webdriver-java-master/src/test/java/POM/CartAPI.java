package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;

public class CartAPI {
    private WebDriver driver;
    private By couponSelector = By.id("coupon_code");
    private By mobileSelector = By.cssSelector("#nav > ol > li.level0.nav-1.first > a");
    private By addTCSelector = By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > div.add-to-cart-buttons > button");
    private By applySelector = By.cssSelector("#discount-coupon-form > div > div > div > div > button > span > span");
    private By successMsgSelector = By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span");
    private By bfTtSelector = By.cssSelector("#shopping-cart-totals-table > tbody > tr:nth-child(1) > td:nth-child(2) > span");
    private By atTtSelector = By.cssSelector("#shopping-cart-totals-table > tfoot > tr > td:nth-child(2) > strong > span");

    public CartAPI(WebDriver driver) {
        this.driver = driver;
    }

    //Choose mobile item
    public WebElement mobile() { return driver.findElement(mobileSelector); }
    public WebElement phoneTC(int s) { return driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(" + s + ") > div > h2 > a")); }
    public WebElement addTC() { return driver.findElement(addTCSelector); }
    public void addMb(String itemName){
        int num = 0;
        mobile().click();
        if (itemName.equals("Iphone")){
            num = 1;
        } else if (itemName.equals("Samsung Galaxy")){
            num = 2;
        } else{
            num = 3;
        }
        phoneTC(num).click();
        addTC().click();
    }

    //Input coupon
    public WebElement coupon() {
        return driver.findElement(couponSelector);
    }
    public WebElement apply() {
        return driver.findElement(applySelector);
    }
    public void inputCoupon(String coupon) {
        coupon().clear();
        coupon().sendKeys(coupon);
        apply().click();
    }

    //Verify price
    public WebElement success() {
        return driver.findElement(successMsgSelector);
    }
    public WebElement bfTt() {
        return driver.findElement(bfTtSelector);
    }
    public WebElement atTt() {
        return driver.findElement(atTtSelector);
    }
    public void checkDiscount(String coupon){
        assertEquals("Coupon code \"" + coupon + "\" was applied.", success().getText());
        assertNotEquals(bfTt().getText(), atTt().getText());
    }
}
