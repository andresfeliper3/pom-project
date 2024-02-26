package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseProductTest extends BaseTest{

    @Test(dataProvider = "userData")
    public void test(String username, String password, String firstName, String lastName, String postalCode) {
        LoginPage loginPage = getLoginPage();
        InventoryPage inventoryPage = loginPage.login(username, password);
        inventoryPage.addRandomItemToCart();

        CartPage cartPage = inventoryPage.clickOnShoppingCartLink();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickOnCheckoutButton();

        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.enterUserData(firstName, lastName, password);
        CompletedOrderPage completedOrderPage = checkoutStepTwoPage.clickOnFinishButton();

        Assert.assertEquals(completedOrderPage.getCurrentUrl(), FINAL_URL);
    }
}
