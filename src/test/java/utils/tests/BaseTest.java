package utils.tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.LoginPage;

public class BaseTest {

    public static final String DRIVER_PATH = "utils/chromedriver.exe";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FINAL_URL = "https://www.saucedemo.com/checkout-complete.html";
    protected WebDriver webDriver;

    @BeforeTest
    @Parameters({"url"})
    public void setup(String url) {
        System.getProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
        navigateTo(url);
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postalCode = faker.address().zipCode();
        return new Object[][] {{USERNAME, PASSWORD, firstName, lastName, postalCode}};
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public void navigateTo(String url) {
        webDriver.get(url);
    }

    @AfterTest
    public void close() {
        webDriver.close();
    }

}
