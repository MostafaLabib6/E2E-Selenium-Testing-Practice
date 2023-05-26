import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasisTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser value!!");
        }
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
