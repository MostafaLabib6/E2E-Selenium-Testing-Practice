import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BasisTest{
    Login login;
    @Test(priority = 0)
    @Parameters({"email","password"})
    public void Login(String email,String password) {
        login = new Login(driver);
        login.loginUser(email, password);
        Assert.assertEquals(login.getCurrentUrl(),"https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        System.out.println("Login Test Passed");
    }

}
