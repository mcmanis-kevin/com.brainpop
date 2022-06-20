package pageobjects;

import function_libraries.DriverLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.readers.IniReader;

import java.util.List;

import static managers.WebManager._driver;
import static paths.DataPaths.SearchDataIniFile;

public class SearchResultsPage extends DriverLib {

    @CacheLookup
    @FindBys(
            @FindBy(css = "#topic_list li")
    )
    List<WebElement> searchResults = null;

    @CacheLookup
    @FindBy(css = "#search_topic_results > .topics_results_number")
    WebElement topicResultCount = null;

    public SearchResultsPage() {
        PageFactory.initElements(_driver, this);
    }

    public int topicCount() {
        return Integer.parseInt(getElementText(topicResultCount));
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void selectResultTopic() {
        final String TopicAsStr = new IniReader(SearchDataIniFile).get_IniValue("SEARCH_TOPICS", "Topic");
        clickElement(_driver.findElement(By.xpath("//div[contains(text(), '" + TopicAsStr + "')]")));
    }

}
