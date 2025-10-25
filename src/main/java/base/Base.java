package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


public class Base {


    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }



    public static void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void smartClick(By locator) {
        try {
            click(locator);
        } catch (Exception e) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }

    public static void clickMultipleTimes(By locator, int times) {
        for (int i = 0; i < times; i++) {
            smartClick(locator);
        }
    }

    public static void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void login(By usernameLocator, String username, By passwordLocator, String password, By loginButtonLocator) {
        sendKeys(usernameLocator, username);
        sendKeys(passwordLocator, password);
        click(loginButtonLocator);
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static void switchToNewTab() {
        Set<String> allWindows = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allWindows);
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static boolean isElementThere(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
      }

    }
