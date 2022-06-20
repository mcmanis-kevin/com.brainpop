package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.WebManager._driver;

public class HomePage extends DriverLib {

    @CacheLookup
    @FindBy(xpath = "//*[starts-with(@id, 'search-input')]")
    WebElement searchField = null;

    public HomePage() {
        PageFactory.initElements(_driver, this);
    }

    public void search(String whatToSearchFor) {
        sendKeysToElement(searchField, whatToSearchFor);
    }

}
