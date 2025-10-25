package pages;

import base.Base;
import org.openqa.selenium.By;

public class ResultsPage extends Base {

    private By filterButton = By.xpath("//button[@data-testid='category-bar-filter-button']");
    private By bedCount = By.xpath("//button[@aria-label='increase value' and contains(@aria-describedby,'min_bedrooms')]");
    private By showResults = By.xpath("//a[contains(@class,'b1yncvrf')]");
    private By selectPool = By.xpath("//button[@id='filter-item-amenities-7' and .//span[text()='Pool']]");
    private By closePopup = By.xpath("//button[contains(@class,'b1yncvrf') and text()='Got it']");
    private By openFirstResult = By.xpath("//img[contains(@class,'iekrptg')]");
    private By showAmenities = By.xpath("//button[contains(@class,'c1xbk6gl')]//span[contains(text(),'amenities')]");
    private By closePopUpTranslate = By.xpath("//button[@aria-label='Close']");
    private By findPool = By.xpath("//div[contains(@id,'row-title') and text()='Pool']");
    public void selectBedCount() {
        click(closePopup);
        click(filterButton);
        clickMultipleTimes(bedCount, 5);
        click(selectPool);
        click(showResults);
        click(openFirstResult);
    }

        public void checkResults(){
            click(closePopUpTranslate);
            click(showAmenities);
            click(findPool);

            if (Base.isElementThere(findPool)) {
                System.out.println("There's a pool");
            } else {
                System.out.println("There's no pool");
            }

        }
    }

