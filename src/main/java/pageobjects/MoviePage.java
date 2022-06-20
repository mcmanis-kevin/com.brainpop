package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static managers.WebManager._driver;
import static managers.WebManager._wait;

public class MoviePage extends DriverLib {

    @CacheLookup
    @FindBy(id = "play_movie")
    WebElement watchMovieButton = null;

    @CacheLookup
    @FindBy(id = "time-elapsed")
    WebElement timeElapsedTimeStamp = null;

    @CacheLookup
    @FindBy(id = "duration")
    WebElement durationTimeStamp = null;

    @CacheLookup
    @FindBy(id = "play")
    WebElement playButton = null;

    @CacheLookup
    @FindBy(id = "pause")
    WebElement pauseButton = null;

    @CacheLookup
    @FindBy(id = "replay_button")
    WebElement replayButton = null;

    @CacheLookup
    @FindBy(id = "caption")
    WebElement caption = null;

    @CacheLookup
    @FindBy(xpath = "//*[@id='video']/parent::div//span")
    WebElement closedCaptionText = null;

    @CacheLookup
    @FindBy(id = "feature_related_reading")
    WebElement featureRelatedReadingButton = null;

    @CacheLookup
    @FindBy(id = "body_header")
    WebElement header = null;

    public MoviePage() {
        PageFactory.initElements(_driver, this);
    }

    public void watchMovie() {
        clickElement(watchMovieButton);
    }

    public String getMovieEndTime(WebElement element) {
        int time = Integer.parseInt(getTimeStamp(element)) + 1;
        return String.valueOf(time);
    }

    private int getMovieStartTime(WebElement element) {
        return Integer.parseInt(getTimeStamp(element));
    }

    private String getTimeStamp(WebElement element) {
        String initialTime = getElementText(element);
        return initialTime.replace(":", "").trim();
    }

    public void skipToEndOfMovie() {
        int startTime = 0;
        int endTime = 2;
        while (startTime < endTime) {
            startTime = getMovieStartTime(timeElapsedTimeStamp);
            endTime = Integer.parseInt(getMovieEndTime(durationTimeStamp));
            executeJsScript("document.getElementById('video').currentTime = " + getMovieEndTime(durationTimeStamp));
        }
    }

    public void skipToClosedCaptionTime() {
        pause(1000);
    }

    public void clickPlay() {
        clickElement(playButton);
    }

    public void clickPause() {
        clickElement(pauseButton);
    }

    public boolean doesReplayButtonExist() {
        return _wait.until(ExpectedConditions.elementToBeClickable(replayButton)).isDisplayed();
    }

    public void closedCaption() {
        clickElement(caption);
    }

    public String getClosedCaptionText() {
        return closedCaptionText.getText();
    }

    public boolean isClosedCaptionTextVisible() {
        return _wait.until(ExpectedConditions.invisibilityOf(closedCaptionText));
    }

    public void featureRelatedReading() {
        clickElement(featureRelatedReadingButton);
    }

    public void selectRandomFeatureTopic(String randomIndex) {
        WebElement element = _driver.findElement(By.cssSelector("#related_readingTab > li:nth-child(" + randomIndex + ")"));
        clickElement(element);
    }

}
