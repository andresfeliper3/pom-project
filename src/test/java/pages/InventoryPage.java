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

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addRandomItemToCart() {
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        WebElement randomlySelectedItem = inventoryItems.get(randomNumber);
        WebElement addToCartButton = randomlySelectedItem.findElement(new By.ByCssSelector("button"));
        addToCartButton.click();
    }

    public CartPage clickOnShoppingCartLink() {
        shoppingCartLink.click();
        return new CartPage(webDriver);
    }
}
