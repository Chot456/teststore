package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class TestStoreLoginPage extends BasePage {

    WebDriver driver;

    By email = By.cssSelector("input#field-email");
    By password = By.cssSelector("[name='password']");
    By signInBtn = By.cssSelector("button#submit-login");

    public TestStoreLoginPage() throws IOException {
        super();
    }

    public WebElement getEmail() throws IOException {
        this.driver = getDriver();
        return driver.findElement(email);
    }

    public WebElement getPassword() throws IOException {
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getSignInBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(signInBtn);
    }
}
