import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignIn {
    private WebDriver driver;
    By myAccount = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By continueBtn = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a");
    By firstName = By.xpath("//*[@id=\"input-firstname\"]");
    By lastName = By.xpath("//*[@id=\"input-lastname\"]");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By telephone = By.xpath("//*[@id=\"input-telephone\"]");
    By password = By.xpath("//*[@id=\"input-password\"]");
    By confirmPassword = By.xpath("//*[@id=\"input-confirm\"]");
    By agreeprivacyPolicy = By.xpath("//label[@for='input-agree']");
    By continueBtn2 = By.xpath("//*[@id=\"content\"]/form/div/div/input");

    By checkCreationMSG = By.xpath("//div[@id='content']//h1[@class='page-title my-3']//i[@class ='fas fa-check-circle text-success']");


    SignIn(WebDriver driver) {
        this.driver = driver;
    }

    void signin() {
        click(myAccount);
        click(continueBtn);
        type(firstName, "userNameTest");
        type(lastName, "userLastNameTest");
        String em = generateRandomEmail();
        type(email, em);
        type(telephone, generateRandomTelephone());
        type(password, "123456HardP@ss");
        type(confirmPassword, "123456HardP@ss");
        click(agreeprivacyPolicy);
        click(continueBtn2);
//        check("Your Account Has Been Created!".toLowerCase(), find(checkCreationMSG).getText().toLowerCase());
        saveEmails(em);
        //---------------------------------------
        // Then logout
        Actions action = new Actions(driver);
        action.moveToElement(find(myAccount)).perform();
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