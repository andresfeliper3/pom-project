package utils.tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {

    public static final String DRIVER_PATH = "utils/chromedriver.exe";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    protected WebDriver webDriver;

    protected Faker faker = new Faker();


    @BeforeMethod
    @Parameters({"url"})
    public void setup(String url) {
        System.getProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
        navigateTo(url);
    }

    @DataProvider(name = "userLoginData")
    public Object[][] getUserLoginData() {
        return new Object[][] {{USERNAME, PASSWORD}};
    }

    @DataProvider(name = "userLoginAndFakePurchaseData")
    public Object[][] getUserData() {
        return new Object[][] {{USERNAME, PASSWORD, generateFakeFirstName(), generateFakeLastName(), generateFakeZipCode()}};
    }


    private String generateFakeFirstName() {
        return faker.name().firstName();
    }

    private String generateFakeLastName() {
        return faker.name().lastName();
    }

    private String generateFakeZipCode() {
        return faker.address().zipCode();
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public InventoryPage loginAndGetInventoryPage(String username, String password) {
        LoginPage loginPage = getLoginPage();
        return loginPage.login(username, password);

    }

    public void navigateTo(String url) {
        webDriver.get(url);
    }

    @AfterMethod
    public void close() {
        webDriver.close();
    }

}
