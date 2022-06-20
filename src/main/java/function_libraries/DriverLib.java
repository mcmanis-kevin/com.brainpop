package function_libraries;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static managers.WebManager._driver;
import static managers.WebManager._wait;

public class DriverLib extends SystemLib {

    public String waitForWindowTitle() {
        return _driver.getTitle();
    }

    public void clickElement(WebElement element) {
        _wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysToElement(WebElement element, String strToType) {
        _wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(strToType);
    }

    public String getElementText(WebElement element) {
        return _wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void enter() {
        sendActionKey(Keys.ENTER);
    }

    void sendActionKey(Keys key) {
        Actions actions = new Actions(_driver);
        actions
                .sendKeys(key)
                .build()
                .perform();
    }

}
