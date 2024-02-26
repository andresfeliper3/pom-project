package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.LoginPage;

public class BaseTest {

    public static final String DRIVER_PATH = "utils/chromedriver.exe";
    protected WebDriver webDriver;

    @BeforeTest
    @Parameters({"url"})
    public void setup(String url) {
        System.getProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
        navigateTo(url);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public void navigateTo(String url) {
        webDriver.get(url);
    }

    @AfterTest
    public void close() {
       // webDriver.close();
    }

}
