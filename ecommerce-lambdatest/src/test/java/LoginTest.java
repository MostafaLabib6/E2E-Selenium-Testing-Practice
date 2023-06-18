import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest  {

    LoginTest() {
        super();
    }

    @Test
    @Parameters({"Email", "Password"})
    public void Login(String email, String password) {
        Login login = new Login(BaseTest.driver);
        login.loginUser(email, password);
        Assert.assertEquals(login.getCurrentUrl(), "https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        System.out.println("Login Test Passed");
    }

}
