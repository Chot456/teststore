package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.ActionKeywords;
import base.ExtentManager;
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
    public void addRemoveItem() throws Exception {

        ExtentManager.log("Starting AddRemoveItemBasketTest...");

        // creating an object of the automationtesting.co.uk webpage
        HomePage home = new HomePage();
        home.getCookie().click();
        ExtentManager.pass("Reached the shop homepage");

        ActionKeywords.click(home.getTestStoreLink());

        // creating an object of the test store homepage
        ShopHomePage shopHome = new ShopHomePage();
        ExtentManager.pass("Reached the shop product page");
        ActionKeywords.click(shopHome.getProdOne());

        // creating an object of the shop products page (when a product has been
        // selected)
        ShopProductPage shopProd = new ShopProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Have successfully selected product size");
        ActionKeywords.click(shopProd.getQuantIncrease());
        ExtentManager.pass("Have successfully increased quantity");
        ActionKeywords.click(shopProd.getAddToCartBtn());
        ExtentManager.pass("Have successfully added product to basket");

        // creating an object of the cart content panel (once an item was added)
        ShopContentPanel cPanel = new ShopContentPanel();
        ActionKeywords.click(cPanel.getContinueShopBtn());
        ActionKeywords.click(shopProd.getHomepageLink());
        ActionKeywords.click(shopHome.getProdTwo());
        ActionKeywords.click(shopProd.getAddToCartBtn());
        ActionKeywords.click(cPanel.getCheckoutBtn());

        ShoppingCart cart = new ShoppingCart();
        ActionKeywords.click(cart.getDeleteItemTwo());

        // using a wait to ensure the deletion has taken place
        ActionKeywords.waitForElementVisible(cart.getDeleteItemTwo(), 120);

        System.out.println(cart.getTotalAmount().getText());

        try {
            // using an assertion to make sure the total amount is what we are expecting
            Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24");
            ExtentManager.pass("The total amount matches the expected amount.");
        } catch (AssertionError e) {
            Assert.fail("Cart amount did not match the expected amount, it found" + cart.getTotalAmount().getText() +
                    " expected $45.23");
            ExtentManager.fail("The total amount did not match the expected amount.");
        }
        // change to $45.24 to pass the test

    }

}