import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private  WebDriver driver;
    By myAccount = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By password = By.xpath("//*[@id=\"input-password\"]");
    By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]");
    public Login(WebDriver driver) {
        this.driver = driver;

    }
    public void loginUser(String mail, String pass) {
        clickMyAccount();
        setEmail(mail);
        setPassword(pass);
        pressLoginBtn();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void  clickMyAccount(){
        click(myAccount);
    }
    public void  setEmail(String mail){
        type(email, mail);
    }
    public void  setPassword(String pass){
      type(password, pass);
    }
    public void  pressLoginBtn(){
        click(loginBtn);
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
