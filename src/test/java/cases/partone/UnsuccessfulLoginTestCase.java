package cases.partone;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.LoginPrompt;
import utilities.readers.IniReader;

import static paths.DataPaths.LoginDataIniFile;

public class UnsuccessfulLoginTestCase {

    @Test
    public void unsuccessfulLogin_Test() {
        new LoginPage().clickLoginButton();
        LoginPrompt loginPrompt = new LoginPrompt();
        loginPrompt.enterUsername(new IniReader(LoginDataIniFile).get_IniValue("LOGIN_INFORMATION", "Username"));
        loginPrompt.enterPassword("BadPassword");
        loginPrompt.clickLoginButton();
        Assert.assertEquals(loginPrompt.badUserPassDialogIsDisplayed(), "The username and password you entered did not match.");
    }

}
