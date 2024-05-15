package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BasePage;
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

        HomePage home = new HomePage();

        // handles cookie prompt
        home.getCookie().click();

        home.getTestStoreLink().click();

        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getProdOne().click();

        ShopProductPage shopProd = new ShopProductPage(driver);
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        ShopContentPanel cPanel = new ShopContentPanel(driver);
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getHavePromo().click();
        cart.getPromoTextbox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        cart.getProceedCheckoutBtn().click();

        OrderFormPersonalInfo pInfo = new OrderFormPersonalInfo(driver);
        pInfo.getGenderMr().click();
        pInfo.getFirstNameField().sendKeys("John");
        pInfo.getLastnameField().sendKeys("Doe");
        pInfo.getEmailField().sendKeys("john@test.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        // creating an object of the order delivery info page
        OrderFormDelivery orderDelivery = new OrderFormDelivery(driver);
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getStateDropdown());
        state.selectByVisibleText("Texas");
        orderDelivery.getPostcodeField().sendKeys("77021");
        orderDelivery.getContinueBtn().click();

        // creating an object of the shipping method page
        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod(driver);
        shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
        shipMethod.getContinueBtn().click();

        // creating an object of the payment options page
        OrderFormPayment orderPay = new OrderFormPayment(driver);
        orderPay.getPayByCheckRadioBtn().click();
        orderPay.getTermsConditionsCheckbox().click();
        orderPay.getOrderBtn().click();

        Thread.sleep(10000);
    }

}
