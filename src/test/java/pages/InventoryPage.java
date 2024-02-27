package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.pages.BasePage;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {

    @FindBys({@FindBy(className = "inventory_item")})
    private List<WebElement> inventoryItems;

    @FindBy(css = "a[class=\"shopping_cart_link\"]")
    private WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement navigationBars;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addRandomItemToCart() {
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        addItemToCart(randomNumber);
    }

    public void addItemToCart(int index) {
        WebElement randomlySelectedItem = inventoryItems.get(index);
        WebElement addToCartButton = randomlySelectedItem.findElement(new By.ByCssSelector("button"));
        if(isElementClickable(addToCartButton))
            addToCartButton.click();
    }

    public CartPage clickOnShoppingCartLink() {
        if(isElementClickable(shoppingCartLink))
            shoppingCartLink.click();
        return new CartPage(webDriver);
    }

    public void clickOnNavigationBars() {
        if(isElementClickable(navigationBars))
            navigationBars.click();
    }

    public LoginPage clickOnLogoutLink() {
        if(isElementClickable(logoutLink))
            logoutLink.click();
        return new LoginPage(webDriver);
    }

}
