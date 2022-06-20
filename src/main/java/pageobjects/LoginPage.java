package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.readers.IniReader;

import static managers.WebManager._driver;
import static paths.DataPaths.LoginDataIniFile;

public class LoginPage extends DriverLib {

    @CacheLookup
    @FindBy(id = "nli_log_in_button")
    WebElement loginButton = null;

    @CacheLookup
    @FindBy(xpath = "//*[starts-with(@id, 'user_menu')]")
    WebElement loggedInUsername = null;

    @CacheLookup
    @FindBy(xpath = "//*[starts-with(@id, 'logout_button')]")
    WebElement logOut = null;


    public LoginPage() {
        PageFactory.initElements(_driver, this);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void logOutUser() {
        clickElement(loggedInUsername);
        clickElement(logOut);
    }

    public void loginToApp() {
        clickLoginButton();
        LoginPrompt loginPrompt = new LoginPrompt();
        IniReader iniReader = new IniReader(LoginDataIniFile);
        loginPrompt.enterUsername(iniReader.get_IniValue("LOGIN_INFORMATION", "Username"));
        loginPrompt.enterPassword(iniReader.get_IniValue("LOGIN_INFORMATION", "Password"));
        loginPrompt.clickLoginButton();
    }

}
