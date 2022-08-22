package page.google.calculator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class EmailBlock extends AbstractPage {

    @FindBy(xpath = "(//input[@name='description'])[3]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public EmailBlock(WebDriver driver) {
        super(driver);
    }

    public EmailBlock pasteEmailIntoEmailEstimate(){
        emailInput.sendKeys(Keys.CONTROL + "V");
        return this;
    }

    public EmailBlock clickOnSendEmailButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return this;
    }
}
