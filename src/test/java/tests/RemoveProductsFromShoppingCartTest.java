package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.order.CartPage;
import pages.InventoryPage;
import utils.tests.BaseTest;

public class RemoveProductsFromShoppingCartTest extends BaseTest {

    private static final int AMOUNT_OF_ITEMS_TO_ADD = 3;

    @Test(dataProvider = "userLoginData")
    public void test(String username, String password) {
        InventoryPage inventoryPage = loginAndGetInventoryPage(username, password);

        for(int i = 0; i < AMOUNT_OF_ITEMS_TO_ADD; i++) {
            inventoryPage.addItemToCart(i);
        }

        CartPage cartPage = inventoryPage.clickOnShoppingCartLink();
        cartPage.removeAllProducts();
        int removedProductsAmount = cartPage.getRemovedProductsAmount();

        Assert.assertEquals(removedProductsAmount, AMOUNT_OF_ITEMS_TO_ADD);

    }
}
