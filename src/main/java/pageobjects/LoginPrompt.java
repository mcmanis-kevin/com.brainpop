package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.WebManager._driver;

public class LoginPrompt extends DriverLib {

    @CacheLookup
    @FindBy(id = "login")
    WebElement username = null;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password = null;

    @CacheLookup
    @FindBy(id = "btnLogin")
    WebElement loginButton = null;

    @CacheLookup
    @FindBy(id = "login-error")
    WebElement badUsernamePasswordDialogBox = null;

    public LoginPrompt() {
        PageFactory.initElements(_driver, this);
    }

    public void enterUsername(String usernameAsStr) {
        sendKeysToElement(username, usernameAsStr);
    }

    public void enterPassword(String passwordAsStr) {
        sendKeysToElement(password, passwordAsStr);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String badUserPassDialogIsDisplayed() {
        final String DialogText = getElementText(badUsernamePasswordDialogBox);
        if (null == DialogText)
            return "";
        else return DialogText.trim();
    }

}
