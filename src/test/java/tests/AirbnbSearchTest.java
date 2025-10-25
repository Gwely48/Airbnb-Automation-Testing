package tests;

import base.Base;
import pages.AirbnbSearchPage;
import pages.ResultsPage;

import static base.Base.*;

public class AirbnbSearchTest {

    public static void main(String[] args) throws InterruptedException {
        AirbnbSearchPage searchPage = new AirbnbSearchPage();
        ResultsPage resultsPage = new ResultsPage();

        Base.openBrowser();
        searchPage.navigateToAirbnb();
        searchPage.pickPlace("Rome, Italy");
        searchPage.setCheckInDate();
        searchPage.addGuests();
        searchPage.pressSearchButton();
        resultsPage.selectBedCount();
        switchToNewTab();
        resultsPage.checkResults();
        driver.quit();

    }
}
