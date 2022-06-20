package base;

import managers.WebManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobjects.LoginPage;

public class Initialization {

    WebManager webManager = new WebManager();

    @BeforeTest
    public void initializationOfDriver() {
        webManager.createDriverManagerInstance();
    }

    @AfterTest
    public void logOutUserFromApp() {
        new LoginPage().logOutUser();
    }

    @AfterTest(
            dependsOnMethods = "logOutUserFromApp"
    )
    public void deconstruct() {
        webManager.destroyDriverManagerInstance();
    }

}
