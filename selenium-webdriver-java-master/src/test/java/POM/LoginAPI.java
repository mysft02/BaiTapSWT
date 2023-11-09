package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAPI {
    private WebDriver driver;

    public LoginAPI(WebDriver driver) {
        this.driver = driver;
    }
    private By usernameSelector = By.id("username");
    private By passwordSelector = By.id("login");
    private By loginSelector = By.cssSelector("#loginForm > div > div.form-buttons > input");
    private By closeSelector = By.cssSelector("#message-popup-window > div.message-popup-head > a > span");
    private By saleSelector = By.cssSelector("#nav > li:nth-child(1) > a > span");
    private By odSelector = By.cssSelector("#nav > li:nth-child(1) > ul > li:nth-child(1) > a > span");
    private By orderIDSelector = By.id("sales_order_grid_filter_real_order_id");
    private By frDateSelector = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[1]/input");
    private By toDateSelector = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[2]/input");
    private By searchSelector = By.cssSelector("#id_e754fe3b61b3f29526fdbb2d4c8dce76 > span > span > span");
    //Input user name
    public WebElement username() {
        return driver.findElement(usernameSelector);
    }
    public void inputUsername(String username){
        WebElement usernameElem = driver.findElement(usernameSelector);
        usernameElem.sendKeys(username);
    }

    //Input password and login
    public WebElement password() {
        return driver.findElement(passwordSelector);
    }
    public WebElement login() { return driver.findElement(loginSelector); }
    public WebElement close() { return driver.findElement(closeSelector); }
    public void inputPassword(String password){
        password().sendKeys(password);
        login().click();
        close().click();
    }

    //Get to orders page
    public WebElement sale() { return driver.findElement(saleSelector); }
    public WebElement od() { return driver.findElement(odSelector); }
    public void Order(){
        sale().click();
        od().click();
    }

    //Input information
    public WebElement orderID() { return driver.findElement(orderIDSelector); }
    public WebElement frDate() { return driver.findElement(frDateSelector); }
    public WebElement toDate() { return driver.findElement(toDateSelector); }
    public WebElement search() { return driver.findElement(searchSelector); }
    public void inputInfo(){
        orderID().clear();
        orderID().sendKeys("100020974");
        frDate().clear();
        frDate().sendKeys("11/01/2023");
        toDate().clear();
        toDate().sendKeys("11/31/2023");
        search().click();
    }
}
