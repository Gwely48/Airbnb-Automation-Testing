package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AirbnbSearchPage extends Base {

    private By searchBox = By.name("query");
    private By guestsButton = By.xpath("//div[text()='Add guests']");
    private By checkInDate = By.xpath("//button[@data-state--date-string='2025-10-29']");
    private By checkOutDate = By.xpath("//button[@data-state--date-string='2025-11-05']");
    private By adultsCount = By.xpath("//button[@data-testid='stepper-adults-increase-button' and @type='button']");
    private By childsCount = By.xpath("//button[@data-testid='stepper-children-increase-button' and @type='button']");
    private By serchButton = By.xpath("//div[contains(@class,'s15knsuf') and text()='Search']");

    public void navigateToAirbnb() {
        navigateToUrl("https://www.airbnb.com");
    }

    public void searchForLocation(String location) {
        click(searchBox);
        sendKeys(searchBox, location);
        findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void pickPlace(String location){
        searchForLocation(location);
    }

    public void setCheckInDate(){
        click(checkInDate);
        click(checkOutDate);
    }

    public void addGuests(){
        click(guestsButton);
        clickMultipleTimes(adultsCount, 2);
        clickMultipleTimes(childsCount, 2);
    }

    public void pressSearchButton(){
        click(serchButton);
    }

    }

