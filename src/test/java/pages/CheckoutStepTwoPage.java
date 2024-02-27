package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.pages.BasePage;

public class CheckoutStepTwoPage extends BasePage {
    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CompletedOrderPage clickOnFinishButton() {
        if(isElementClickable(finishButton))
            finishButton.click();
        return new CompletedOrderPage(webDriver);
    }
}
