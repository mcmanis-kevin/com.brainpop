package function_libraries;

import org.openqa.selenium.JavascriptExecutor;

import static managers.WebManager._driver;

public class SystemLib {

    public void executeJsScript(String jsScriptToExecute) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) _driver;
        jsExecutor.executeScript(jsScriptToExecute);
    }

    public void pause(int timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
