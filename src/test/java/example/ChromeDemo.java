package example;

import config.BaseTest;
import config.Config;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ChromeDemo extends BaseTest {

    @Test
    public void usernameAndPasswordRequired() {
        driver.get(Config.BASE_URL);

        // Perform login
        driver.findElement(By.xpath(Config.LOGIN_LINK)).click();

        // Wait for login modal popup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));

        // Perform invalid login using constants from Config
        driver.findElement(By.xpath(Config.LOGIN_USERNAME)).sendKeys("");
        driver.findElement(By.xpath(Config.LOGIN_PASSWORD)).sendKeys("");
        driver.findElement(By.xpath(Config.LOGIN_BUTTON)).click();

        // Wait for the alert to be present
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        // Get the text of the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        // Perform any additional actions, such as accepting or dismissing the alert
        alert.accept(); // Use dismiss() to dismiss the alert
    }

    @Test
    public void invalidLoginTest() {
        driver.get(Config.BASE_URL);

        // Perform login
        driver.findElement(By.xpath(Config.LOGIN_LINK)).click();

        // Wait for login modal popup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));

        // Perform invalid login using constants from Config
        driver.findElement(By.xpath(Config.LOGIN_USERNAME)).sendKeys("invalid_username");
        driver.findElement(By.xpath(Config.LOGIN_PASSWORD)).sendKeys("invalid_password");
        driver.findElement(By.xpath(Config.LOGIN_BUTTON)).click();

        // Wait for the alert to be present
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        // Get the text of the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        // Perform any additional actions, such as accepting or dismissing the alert
        alert.accept(); // Use dismiss() to dismiss the alert
    }

    @Test
    public void loginAndLogoutTest() {
        // Navigate to the login page
        driver.get(Config.BASE_URL);

        // Perform login
        driver.findElement(By.xpath(Config.LOGIN_LINK)).click();

        // Wait for login modal popup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));

        // Add text to the input field
        driver.findElement(By.xpath(Config.LOGIN_USERNAME)).sendKeys(Config.USERNAME);
        driver.findElement(By.xpath(Config.LOGIN_PASSWORD)).sendKeys(Config.PASSWORD);
        driver.findElement(By.xpath(Config.LOGIN_BUTTON)).click();

        // Navigate to homepage
        String welcomeUsername = "//a[text()='Welcome " + Config.USERNAME + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeUsername)));

        driver.findElement(By.xpath(Config.LOGOUT_LINK)).click();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
