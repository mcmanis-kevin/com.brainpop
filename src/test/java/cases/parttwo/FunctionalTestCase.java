package cases.parttwo;

import base.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MoviePage;
import pageobjects.SearchResultsPage;

public class FunctionalTestCase extends Initialization {

    @Test
    public void resultsReturned_Test() {
        new LoginPage().loginToApp();
        HomePage homePage = new HomePage();
        homePage.search("Challenge");
        homePage.enter();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertEquals(searchResultsPage.topicCount(), searchResultsPage.getSearchResults().size());
    }

    @Test(
            dependsOnMethods = "resultsReturned_Test"
    )
    public void movie_Test() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.selectResultTopic();
        MoviePage moviePage = new MoviePage();
        moviePage.watchMovie();
        moviePage.clickPlay();
        moviePage.skipToEndOfMovie();
        Assert.assertTrue(moviePage.doesReplayButtonExist());
    }

    @Test(
            dependsOnMethods = "resultsReturned_Test"
    )
    public void closedCaptions_Test() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.selectResultTopic();
        MoviePage moviePage = new MoviePage();
        moviePage.watchMovie();
        moviePage.closedCaption();
        moviePage.clickPlay();
        moviePage.skipToClosedCaptionTime();
        moviePage.clickPause();
        String closedCapText = moviePage.getClosedCaptionText();
        moviePage.closedCaption();
        boolean capNotVisible = moviePage.isClosedCaptionTextVisible();
        Assert.assertEquals(closedCapText, "<Title Screen> \"The Mysteries of Life\n" +
                "with Tim and Moby\"");
        Assert.assertTrue(capNotVisible);
    }

    @Test(
            dependsOnMethods = "resultsReturned_Test"
    )
    public void featureRelatedReading_Test() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.selectResultTopic();
        MoviePage moviePage = new MoviePage();
        moviePage.featureRelatedReading();
        String ranNum = String.valueOf(moviePage.getRandomNumber(2, 6));
        moviePage.selectRandomFeatureTopic(ranNum);
    }

}
