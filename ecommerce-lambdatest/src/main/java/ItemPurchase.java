import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPurchase {
    private WebDriver driver;
    By Home = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a/div/span");
    By Item = By.xpath("//*[@id=\"mz-carousel-213240\"]/div/div[1]/a/img");
    By BuyNowBtn = By.xpath("//*[@id=\"entry_216843\"]/button");
    By FirstName = By.xpath("//*[@id=\"input-payment-firstname\"]");
    By LastName = By.xpath("//*[@id=\"input-payment-lastname\"]");
    By Email = By.xpath("//*[@id=\"input-payment-email\"]");
    By Telephone = By.xpath("//*[@id=\"input-payment-telephone\"]");
    By Password = By.xpath("//*[@id=\"input-payment-password\"]");
    By ConfirmPassword = By.xpath("//*[@id=\"input-payment-confirm\"]");
    By Address1 = By.xpath("//*[@id=\"input-payment-address-1\"]");
    By City = By.xpath("//*[@id=\"input-payment-city\"]");
    By PostCode = By.xpath("//*[@id=\"input-payment-postcode\"]");
    By Country = By.xpath("//*[@id=\"input-payment-country\"]");
    By Region = By.xpath("//*[@id=\"input-payment-zone\"]");
    By Terms = By.xpath("//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label");
    By ContinueBtn = By.xpath("//*[@id=\"button-save\"]");
    By ConfirmOrder = By.xpath("//*[@id=\"button-confirm\"]");
    Select select;
    public ItemPurchase(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name) {
        type(FirstName, name);
    }
    public void setLastName(String name) {
        type(LastName, name);
    }
    public void setAddress1(String address) {
        type(Address1, address);
    }
    public void setCity(String city) {
        type(City, city);
    }
    public void setPostCode(String code) {
        type(PostCode, code);
    }
    public void setEmail(String email) {
        type(Email, email);
    }
    public void setTelephone(String number) {
        type(Telephone, number);
    }
    public void setPassword(String password) {
        type(Password, password);
    }
    public void setConfirmPassword(String password) {
        type(ConfirmPassword, password);
    }
    public void setCountry(String country) {
       select = new Select(find(Country));
       select.selectByVisibleText(country);
    }
    public void setRegion(int index) {
        select = new Select(find(Region));
        select.selectByIndex(index);
    }
    public void clickTerms() {
        click(Terms);
    }
    public void clickContinueBtn() {
        click(ContinueBtn);
    }
    public void clickHome() {
        click(Home);
    }
    public void clickItem() {
        click(Item);
    }
    public void clickBuyNowBtn() {
        click(BuyNowBtn);
    }
    public void clickConfirmOrder() {
        click(ConfirmOrder);
    }
    public void purchaseItem(String firstName,String lastName,String address,String city,String zipCode,String country,int state){
        clickHome();
        clickItem();
        clickBuyNowBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/checkout"));
        setFirstName(firstName);
        setLastName(lastName);

        setAddress1(address);
        setCity(city);
        setPostCode(zipCode);
        setCountry(country);
        setRegion(state);
        clickTerms();
        clickContinueBtn();
        assert getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/checkout/shipping");
        clickConfirmOrder();
        assert getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/checkout/confirm");
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
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
