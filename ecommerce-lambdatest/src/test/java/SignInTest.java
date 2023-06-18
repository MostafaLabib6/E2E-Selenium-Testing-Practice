import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    private SignIn signIn_instance;

    @Test
    void setSignIn() {
        signIn_instance = new SignIn(BaseTest.driver);
        signIn_instance.signin();
        System.out.println("Signin Test Passed");
    }

}
