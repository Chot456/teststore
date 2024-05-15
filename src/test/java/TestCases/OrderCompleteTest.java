package TestCases;

import java.io.IOException;

import base.ExtentManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Hooks;
import pageObjects.HomePage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersonalInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws IOException, InterruptedException {
        ExtentManager.log("Starting OrderCompleteTest...");

        HomePage home = new HomePage();

        // handles cookie prompt
        home.getCookie().click();

        home.getTestStoreLink().click();
        ExtentManager.pass("Have successfully reached store homepage");

        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getProdOne().click();
        ExtentManager.pass("Have successfully clicked on product");

        ShopProductPage shopProd = new ShopProductPage();
        ExtentManager.pass("Have successfully reached shop product page");
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Have successfully selected product size");
        shopProd.getQuantIncrease().click();
        ExtentManager.pass("Have successfully increased quantity");
        shopProd.getAddToCartBtn().click();
        ExtentManager.pass("Have successfully added item to cart");

        ShopContentPanel cPanel = new ShopContentPanel();
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        ExtentManager.pass("Have successfully reached the shopping cart page");
        cart.getHavePromo().click();
        ExtentManager.pass("Have successfully selected the promo button");
        cart.getPromoTextbox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        cart.getProceedCheckoutBtn().click();
        ExtentManager.pass("Have successfully selected the check out button");

        OrderFormPersonalInfo pInfo = new OrderFormPersonalInfo();
        pInfo.getGenderMr().click();
        pInfo.getFirstNameField().sendKeys("John");
        pInfo.getLastnameField().sendKeys("Doe");
        pInfo.getEmailField().sendKeys("john@test.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();
        ExtentManager.pass("Have successfully entered customer details");

        // creating an object of the order delivery info page
        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getStateDropdown());
        state.selectByVisibleText("Texas");
        orderDelivery.getPostcodeField().sendKeys("77021");
        orderDelivery.getContinueBtn().click();
        ExtentManager.pass("Have successfully entered delivery info");

        // creating an object of the shipping method page
        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
        shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
        shipMethod.getContinueBtn().click();
        ExtentManager.pass("Have successfully selected the shipping method");

        // creating an object of the payment options page
        OrderFormPayment orderPay = new OrderFormPayment();
        orderPay.getPayByCheckRadioBtn().click();
        orderPay.getTermsConditionsCheckbox().click();
        orderPay.getOrderBtn().click();
        ExtentManager.pass("Have successfully placed order");
    }

}
