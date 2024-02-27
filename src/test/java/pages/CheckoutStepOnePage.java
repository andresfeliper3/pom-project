package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.pages.BasePage;

public class CheckoutStepOnePage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;
    @FindBy(id = "continue")
    private WebElement submitButton;

    public CheckoutStepOnePage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutStepTwoPage enterUserData(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(postalCode);
        submitButton.click();
        return new CheckoutStepTwoPage(webDriver);
    }
}
