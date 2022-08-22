package page.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;

public class GenerateMail extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String PAGE_URL ="https://yopmail.com/ru/email-generator";

    @FindBy(xpath = "//button[@onclick=\"egengo();\"]")
    private WebElement checkEmail;


    public GenerateMail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }
    public GenerateMail openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CheckMail openPost(){
        checkEmail.click();
        logger.info("Post page opened");
        return new CheckMail(driver);
    }
}
