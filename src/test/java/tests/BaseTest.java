package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {

    public static final String DRIVER_PATH = "utils/chromedriver.exe";
    protected WebDriver webDriver;

    @BeforeMethod
    public void setup() {
        System.getProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
    }

    public LoginPage getLoginPage(String url) {
        navigateTo(url);
        return new LoginPage(webDriver, url);
    }

    public void navigateTo(String url) {
        webDriver.get(url);
    }

    @AfterMethod
    public void close() {
       // webDriver.close();
    }

}
