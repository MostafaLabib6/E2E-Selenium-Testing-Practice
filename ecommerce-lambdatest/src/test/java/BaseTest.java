import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    static WebDriver driver;
    static String browserName = "chrome";
    static String url = "https://ecommerce-playground.lambdatest.io/";

    public static WebDriver setup() {
        if (browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            driver = new EdgeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(url);
        return driver;

    }

    public void tearDown() {
        driver.close();
    }


}
