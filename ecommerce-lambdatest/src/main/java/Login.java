import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span")
    WebElement MyAccount;
    @FindBy(xpath = "//*[@id=\"input-Email\"]")
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"input-Password\"]")
    WebElement Password;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]")
    WebElement loginBtn ;
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public void loginUser(String email, String pass) {
        MyAccount.click();
        Email.sendKeys(email);
        Password.sendKeys(pass);
        loginBtn.click();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
