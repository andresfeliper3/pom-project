package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PurchaseProductTest extends BaseTest{

    @Test
    @Parameters({"url", "username", "password"})
    public void test(String url, String username, String password) {
        LoginPage loginPage = getLoginPage(url);
        loginPage.login(username, password);
    }
}
