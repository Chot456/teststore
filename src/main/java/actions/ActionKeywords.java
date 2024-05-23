package actions;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Hooks;

public class ActionKeywords extends Hooks {
    public ActionKeywords() throws IOException {
        super();
    }

    /**
     * Navigates to the specified URL using the driver.
     *
     * @param url the URL to navigate to
     * @throws Exception if an error occurs during navigation
     */
    public static void navigateTo(String url) throws Exception {
        try {
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().get(url);
            Thread.sleep(5000);
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Scrolls the page by the specified amount in the x and y directions.
     *
     * @param x the amount to scroll horizontally
     * @param y the amount to scroll vertically
     * @throws Exception if an error occurs during the scroll operation
     */
    public static void scrollpage(int x, int y) throws Exception {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollBy(" + x + "," + y + ")");
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Waits for a given WebElement to become invisible for a specified number of
     * seconds.
     *
     * @param element the WebElement to wait for
     * @param seconds the number of seconds to wait
     * @throws IOException if an I/O error occurs
     */
    public static void waitForElementVisible(WebElement element, int seconds) throws IOException {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Clicks on a WebElement.
     *
     * @param pageObject the WebElement to be clicked
     * @throws Exception if an error occurs during the click operation
     */
    public static void click(WebElement pageObject) throws Exception {
        try {
            pageObject.click();
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Clicks on a WebElement using JavaScript.
     *
     * @param pageObject the WebElement to be clicked
     * @throws Exception if an error occurs during the click operation
     */
    public static void clickjs(WebElement pageObject) throws Exception {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", pageObject);
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Sends the specified text to the given WebElement.
     *
     * @param pageObject the WebElement to input the text into
     * @param text       the text to be inputted
     * @throws Exception if an error occurs during the input operation
     */
    public static void input(WebElement pageObject, String text) throws Exception {
        try {
            pageObject.sendKeys(text);
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Sends the specified integer as a string to the given WebElement.
     *
     * @param pageObject the WebElement to input the number into
     * @param num        the integer to be inputted
     * @throws Exception if an error occurs during the input operation
     */
    public static void input(WebElement pageObject, int num) throws Exception {
        try {
            String number = String.valueOf(num);
            pageObject.sendKeys(number);
        } catch (Exception e) {
            throw (e);
        }
    }
}
