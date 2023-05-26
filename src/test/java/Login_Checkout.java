import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Checkout extends BasisTest{
    private String mail = "hiwakon486@glumark.com";
    private String pass = "KL8WFfqdm@SDWmR";
    By myAccount = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By password = By.xpath("//*[@id=\"input-password\"]");
    By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]");
    By searchBox = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div[2]/input");
    By searchBtn = By.xpath("//*[@id=\"search\"]/div[2]/button");
    By item = By.xpath("//*[@id=\"entry_212469\"]/div/div[2]/div/div[2]/h4/a");
    By addToCart = By.xpath("//*[@id=\"entry_216842\"]/button");
    By checkOut = By.xpath("//*[@id=\"notification-box-top\"]/div/div[2]/div[2]/div[2]/a");
    @Test
    public void Login() {
        click(myAccount);
        type(email, mail);
        type(password, pass);
        click(loginBtn);
        type(searchBox, "iPod Touch");
        click(searchBtn);
        click(item);
        click(addToCart);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> find(checkOut));
        click(checkOut);
        Assert.assertEquals("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/checkout", driver.getCurrentUrl());
    }
    private void check(String expected,String actual ) {
        if (expected.equalsIgnoreCase(actual)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    private String generateRandomTelephone(){
        return RandomStringUtils.random(11, false, true);
    }
    private String generateRandomEmail(){
        return RandomStringUtils.random(10, true, false)+"@gmail.com";
    }
    private WebElement find(By element) {
        return driver.findElement(element);
    }
    private void click(By element) {
        find(element).click();
    }
    private void type(By element, String text) {
        find(element).sendKeys(text);
    }
}
