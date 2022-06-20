package cases.partone;

import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ResetPassword;

public class ResetPasswordTestCase {

    @Test
    public void forgotPassword_Test() {
        new LoginPage().clickLoginButton();
        ResetPassword resetPassword = new ResetPassword();
        resetPassword.enterUsernameForForgotPassword();
        resetPassword.next();
    }

}
