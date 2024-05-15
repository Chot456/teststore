package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.HomePage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        HomePage home = new HomePage();
        home.getCookie().click();

        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getProdOne().click();

        // creating an object of the shop products page (when a product has been
        // selected)
        ShopProductPage shopProd = new ShopProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        // creating an object of the cart content panel (once an item was added)
        ShopContentPanel cPanel = new ShopContentPanel();
        cPanel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        System.out.println(cart.getTotalAmount().getText());

        Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");
        // change to $45.24 to pass the test

    }

}