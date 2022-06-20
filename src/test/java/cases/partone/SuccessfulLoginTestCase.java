package cases.partone;

import base.Initialization;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class SuccessfulLoginTestCase extends Initialization {

    @Test
    public void successfulLoginAttempt_Test() {
        new LoginPage().loginToApp();
    }

}
