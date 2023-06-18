import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignIn {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span")
    WebElement MyAccount;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div/a")
    WebElement ContinueBtn;
    @FindBy(xpath = "//*[@id=\"input-firstname\"]")
    WebElement FirstName;
    @FindBy(xpath = "//*[@id=\"input-lastname\"]")
    WebElement LastName;
    @FindBy(xpath = "//*[@id=\"input-email\"]")
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"input-telephone\"]")
    WebElement Telephone;
    @FindBy(xpath = "//*[@id=\"input-password\"]")
    WebElement Password;
    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    WebElement ConfirmPassword;
    @FindBy(xpath = "//label[@for='input-agree']")
    WebElement AgreePrivacyPolicy;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input")
    WebElement ContinueBtn2;
    @FindBy(xpath = "//div[@id='content']//h1[@class='page-title my-3']//i[@class ='fas fa-check-circle text-success']")
    WebElement CheckCreationMSG;

    SignIn(WebDriver driver) {
        this.driver = driver;
    }

    void signin() {
        MyAccount.click();
        ContinueBtn.click();
        FirstName.sendKeys("userNameTest");
        LastName.sendKeys("userLastNameTest");
        String em = generateRandomEmail();
        Email.sendKeys(em);
        Telephone.sendKeys(generateRandomTelephone());
        Password.sendKeys("123456HardP@ss");
        ConfirmPassword.sendKeys("123456HardP@ss");
        AgreePrivacyPolicy.click();
        ContinueBtn2.click();

//        check("Your Account Has Been Created!".toLowerCase(), find(checkCreationMSG).getText().toLowerCase());
//        saveEmails(em);
//        ---------------------------------------
//         Then logout
        Actions action = new Actions(driver);
        action.moveToElement(MyAccount).perform();
        click(By.xpath("//a[contains(text(),'Logout')]"));
//        Assert.assertEquals("https://ecommerce-playground.lambdatest.io/index.php?route=account/logout", driver.getCurrentUrl() );
    }

    private String generateRandomTelephone() {
        return RandomStringUtils.random(11, false, true);
    }

    private String generateRandomEmail() {
        return RandomStringUtils.random(10, true, false) + "@gmail.com";
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

    private void saveEmails(String email) {
        Path path = Paths.get("D:/Intellij Idea/Inrellij-projects/E2E-Selenium-Testing/emails.txt");

        try {
            Files.writeString(path, email,
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.print("Invalid Path");
        }


    }
}