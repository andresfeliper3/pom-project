package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.pages.BasePage;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"checkout\"]") // using CSS-> @FindBy(css = "button#checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutStepOnePage clickOnCheckoutButton() {
        checkoutButton.click();
        return new CheckoutStepOnePage(webDriver);
    }
}
