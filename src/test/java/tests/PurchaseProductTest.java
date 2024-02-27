package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.tests.BaseTest;

public class PurchaseProductTest extends BaseTest {

    public static final String FINAL_URL = "https://www.saucedemo.com/checkout-complete.html";

    @Test(dataProvider = "userLoginAndFakePurchaseData")
    public void test(String username, String password, String firstName, String lastName, String postalCode) {
        InventoryPage inventoryPage = loginAndGetInventoryPage(username, password);
        inventoryPage.addRandomItemToCart();

        CartPage cartPage = inventoryPage.clickOnShoppingCartLink();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickOnCheckoutButton();

        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.enterUserData(firstName, lastName, postalCode);
        CompletedOrderPage completedOrderPage = checkoutStepTwoPage.clickOnFinishButton();

        Assert.assertEquals(completedOrderPage.getCurrentUrl(), FINAL_URL);
    }
}
