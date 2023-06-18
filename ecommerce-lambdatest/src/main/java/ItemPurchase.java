import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPurchase {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a/div/span")
    WebElement Home;

    @FindBy(xpath = "//*[@id=\"mz-carousel-213240\"]/div/div[1]/a/img")
    WebElement Item;
    @FindBy(xpath = "//*[@id=\"entry_216843\"]/button")
    WebElement BuyNowBtn;

    @FindBy(xpath = "//*[@id=\"input-payment-firstname\"]")
    WebElement FirstName;

    @FindBy(xpath = "//*[@id=\"input-payment-lastname\"]")
    WebElement LastName;
    @FindBy(xpath = "//*[@id=\"input-payment-Email\"]")
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"input-payment-Telephone\"]")
    WebElement Telephone;
    @FindBy(xpath = "//*[@id=\"input-payment-Password\"]")
    WebElement Password;
    @FindBy(xpath = "//*[@id=\"input-payment-confirm\"]")
    WebElement ConfirmPassword;
    @FindBy(xpath = "//*[@id=\"input-payment-address-1\"]")
    WebElement Address1;
    @FindBy(xpath = "//*[@id=\"input-payment-city\"]")
    WebElement City;
    @FindBy(xpath = "//*[@id=\"input-payment-postcode\"]")
    WebElement PostCode;
    @FindBy(xpath = "//*[@id=\"input-payment-country\"]")
    WebElement Country;
    @FindBy(xpath = "//*[@id=\"input-payment-zone\"]")
    WebElement Region;
    @FindBy(xpath = "//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label")
    WebElement Terms;
    @FindBy(xpath = "//*[@id=\"button-save\"]")
    WebElement ContinueBtn;
    @FindBy(xpath = "//*[@id=\"button-confirm\"]")
    WebElement ConfirmOrder;
    Select select;

    public ItemPurchase(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name) {
        FirstName.sendKeys(name);
    }

    public void setLastName(String name) {
        LastName.sendKeys(name);
    }

    public void setAddress1(String address) {
        Address1.sendKeys(address);
    }

    public void setCity(String city) {
        City.sendKeys(city);
    }

    public void setPostCode(String code) {
        PostCode.sendKeys(code);
    }

    public void setEmail(String email) {
        Email.sendKeys(email);
    }

    public void setTelephone(String number) {
        Telephone.sendKeys(number);
    }

    public void setPassword(String password) {
        Password.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        ConfirmPassword.sendKeys(password);
    }

    public void setCountry(String country) {
        select = new Select(Country);
        select.selectByVisibleText(country);
    }

    public void setRegion(int index) {
        select = new Select(Region);
        select.selectByIndex(index);
    }

    public void clickTerms() {
        Terms.click();
    }

    public void clickContinueBtn() {
        ContinueBtn.click();
    }

    public void clickHome() {
        Home.click();
    }

    public void clickItem() {
        Item.click();
    }

    public void clickBuyNowBtn() {
        BuyNowBtn.click();
    }

    public void clickConfirmOrder() {
        ConfirmOrder.click();
    }

    public void purchaseItem(String firstName, String lastName, String address, String city, String zipCode, String country, int state) {
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

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
