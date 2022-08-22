package page.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;

import java.util.List;

public class ResultPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/s/results?q";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private List<WebElement> googleCloudPricingCalculatorLink;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CalculatorPage openPricingCalculatorLink(){
        int tryCount = 0;
        while(googleCloudPricingCalculatorLink.size()==0 && tryCount<5){
            logger.info("try to refresh number: " + tryCount + "/5");
            logger.info("costInTheLetter.size() == " + googleCloudPricingCalculatorLink.size());
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            tryCount++;
        }
        logger.info("all tryings are done, try ro get cost from the letter");
        logger.info("Cost in the letter text: " + googleCloudPricingCalculatorLink.get(0).getText());
        googleCloudPricingCalculatorLink.get(0).click();
        logger.info("Link opened");
        return new CalculatorPage(driver);
    }
}
