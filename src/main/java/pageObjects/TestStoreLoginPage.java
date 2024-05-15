package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestStoreLoginPage {

    WebDriver driver;

    public TestStoreLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // https://www.automationtesting.co.uk/loginPortal.html

    By email = By.cssSelector("input#field-email");
    By password = By.cssSelector("[name='password']");
    By signInBtn = By.cssSelector("button#submit-login");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getSignInBtn() {
        return driver.findElement(signInBtn);
    }
}
