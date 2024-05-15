package TestCases;

import org.testng.annotations.Test;

import config.BaseTest;
import pageObjects.TestStoreLoginPage;

public class StoreLoginTest extends BaseTest {

    @Test
    public void login() {
        driver.get(
                "https://teststore.automationtesting.co.uk/index.php?controller=authentication?back=https%3A%2F%2Fteststore.automationtesting.co.uk%2Findex.php");

        TestStoreLoginPage testStoreLoginPage = new TestStoreLoginPage(driver);

        testStoreLoginPage.getEmail().sendKeys("invalid_email");
        testStoreLoginPage.getPassword().sendKeys("invalid_password");
        testStoreLoginPage.getSignInBtn().click();
    }
}
