package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage {
    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CompletedOrderPage clickOnFinishButton() {
        finishButton.click();
        return new CompletedOrderPage(webDriver);
    }
}
