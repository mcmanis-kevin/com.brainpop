package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.readers.IniReader;

import static managers.WebManager._driver;
import static paths.DataPaths.LoginDataIniFile;

public class ResetPassword extends DriverLib {

    @CacheLookup
    @FindBy(id = "username")
    WebElement forgotUsername = null;

    @CacheLookup
    @FindBy(id = "forgot_your_username")
    WebElement forgotYourUsernameLink = null;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailField = null;

    @CacheLookup
    @FindBy(id = "verify_username")
    WebElement nextButton = null;

    @CacheLookup
    @FindBy(id = "username_remind_email_back")
    WebElement emailBackButton = null;

    @CacheLookup
    @FindBy(id = "username_remind_email")
    WebElement emailNextButton = null;

    public ResetPassword() {
        PageFactory.initElements(_driver, this);
    }

    public void enterUsernameForForgotPassword() {
        final String UsernameToEnter = new IniReader(LoginDataIniFile).get_IniValue("LOGIN_INFORMATION", "Username");
        sendKeysToElement(forgotUsername, UsernameToEnter);
    }

    public void forgotYourUsername() {
        clickElement(forgotYourUsernameLink);
    }

    public void email() {
        final String UsernameToEnter = new IniReader(LoginDataIniFile).get_IniValue("LOGIN_INFORMATION", "Email");
        sendKeysToElement(forgotUsername, UsernameToEnter);
    }

    public void next() {
        clickElement(nextButton);
    }

    public void emailBack() {
        clickElement(emailBackButton);
    }

    public void emailNext() {
        clickElement(emailNextButton);
    }

}
