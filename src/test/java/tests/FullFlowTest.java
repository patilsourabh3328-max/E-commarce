package tests;

import base.BaseTest;
import pages.*;
import org.testng.annotations.Test;

public class FullFlowTest extends BaseTest {

    @Test
    public void completeOrderFlow() {

        // ✅ driver comes from BaseTest
        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);
        login.login("patilsourabh3328@gmail.com", "sourabh@1");

        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        products.searchProduct("Men tshirt");
        products.viewFirstProduct();

        ProductDetailsPage details = new ProductDetailsPage(driver);
        details.addProductToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();

        PaymentPage payment = new PaymentPage(driver);
        payment.pay();
    }
}
