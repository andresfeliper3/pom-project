package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.tests.BaseTest;

public class LogoutTest  extends BaseTest {
    private static final String AFTER_LOGOUT_URL = "https://www.saucedemo.com/";

    @Test(dataProvider = "userLoginData")
    public void test(String username, String password) {
        InventoryPage inventoryPage = loginAndGetInventoryPage(username, password);

        inventoryPage.clickOnNavigationBars();
        LoginPage loginPageAfterLogout = inventoryPage.clickOnLogoutLink();

        Assert.assertEquals(loginPageAfterLogout.getCurrentUrl(), AFTER_LOGOUT_URL);
    }
}
