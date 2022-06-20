package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.readers.IniReader;

import java.time.Duration;
import java.util.Collections;

import static paths.DataPaths.LoginDataIniFile;

public class WebManager {

    public static WebDriver _driver;
    public static WebDriverWait _wait;

    ChromeOptions chromeOptions() {
        final String url = new IniReader(LoginDataIniFile).get_IniValue("LOGIN_INFORMATION", "Url");
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("--ignore-certificate-errors");
        capabilities.addArguments("--ignore-zoom-level");
        capabilities.addArguments("--start-maximized");
        capabilities.addArguments("--incognito");
        capabilities.addArguments("--verbose");
        capabilities.addArguments("--no-sandbox");
        capabilities.setAcceptInsecureCerts(true);
        capabilities.addArguments("disable-infobars");
        capabilities.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        capabilities.addArguments("--headless");
//        capabilities.addArguments("--disable-gpu");
        capabilities.addArguments("--ignore-certificate-errors");
        capabilities.addArguments("--allow-running-insecure-content");
        capabilities.addArguments("--disable-extensions");
        capabilities.addArguments("--disable-dev-shm-usage");
//        capabilities.addArguments("--window-size=2560,1080");
        capabilities.addArguments("--app=" + url);
        return capabilities;
    }

    public void createDriverManagerInstance() {
        _driver = WebDriverManager.chromedriver()
                .arch32()
                .capabilities(chromeOptions())
                .create();
        _wait = new WebDriverWait(_driver, Duration.ofSeconds(20));
    }

    public void destroyDriverManagerInstance() {
        _driver.quit();
    }

}
