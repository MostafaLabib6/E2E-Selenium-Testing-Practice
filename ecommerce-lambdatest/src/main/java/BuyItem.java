import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BuyItem {
    WebDriver driver;
    Login login;
    By Home = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a/div/span");
    By Item = By.xpath("//*[@id=\"mz-carousel-213240\"]/div/div[1]/a/img");
    By BuyNowBtn = By.xpath("//*[@id=\"entry_216843\"]/button");
    By FirstName = By.xpath("//*[@id=\"input-payment-firstname\"]");
    By LastName = By.xpath("//*[@id=\"input-payment-lastname\"]");

    By Address1 = By.xpath("//*[@id=\"input-payment-address-1\"]");
    By City = By.xpath("//*[@id=\"input-payment-city\"]");
    By PostCode = By.xpath("//*[@id=\"input-payment-postcode\"]");
    By Country = By.xpath("//*[@id=\"input-payment-country\"]");
    By Region = By.xpath("//*[@id=\"input-payment-zone\"]");
    By Terms = By.xpath("//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label");
    By ContinueBtn = By.xpath("//*[@id=\"button-payment-address\"]");
    Select select;

    public BuyItem(WebDriver driver,String email,String password) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
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
    public void setCountry(String country) {
       select = new Select(find(Country));
       select.selectByVisibleText(country);
    }
    public void setRegion(String region) {
        select = new Select(find(Region));
        select.selectByVisibleText(region);
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
    public void BuyProduct(){
        clickHome();
        clickItem();
        clickBuyNowBtn();
        setFirstName("FirstName Test");
        setLastName("LastName Test");
        setAddress1("Address Test");
        setCity("City Test");
        setPostCode("12345");
        setCountry("India");
        setRegion("Andhra Pradesh");
        clickTerms();
        clickContinueBtn();
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
