package page.google.calculatorPageElements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import utils.Scroller;


public class EmailBlock extends AbstractPage {

    private Scroller scroller = new Scroller();
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[contains(@ng-model,'emailQuote.user.email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    public EmailBlock(WebDriver driver) {
        super(driver);
    }

    public EmailBlock putDataIntoEmailBlock(String emailAddress){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        logger.info("Put email: {" + emailAddress +" }");
        emailInput.sendKeys(emailAddress);
        return this;
    }

    public EstimateBlock sendEmail(){
        scroller.scrollToElement(emailInput);
        sendEmail.click();
        logger.info("email have been sent");
        return new EstimateBlock(driver);
    }

}
