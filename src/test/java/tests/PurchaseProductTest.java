package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PurchaseProductTest extends BaseTest{

    @Test
    @Parameters({"username", "password"})
    public void test(String username, String password) {
        LoginPage loginPage = getLoginPage();
        loginPage.login(username, password);
    }
}
