package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"checkout\"]") // using CSS-> @FindBy(css = "button#checkout")
    private WebElement checkoutButton;

    @FindBys({@FindBy(css = "button.cart_button")})
    private List<WebElement> removeButtons;

    @FindBys({@FindBy(className = "removed_cart_item")})
    private List<WebElement> removedCartItem;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutStepOnePage clickOnCheckoutButton() {
        if(isElementClickable(checkoutButton))
            checkoutButton.click();
        return new CheckoutStepOnePage(webDriver);
    }

    public void removeAllProducts() {
        for(WebElement removeButton : removeButtons) {
            if(isElementClickable(removeButton))
                removeButton.click();
        }
    }

    public int getRemovedProductsAmount() {
        return removedCartItem.size();
    }
}
