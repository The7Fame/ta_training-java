package page.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import java.time.Duration;

public class MainPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public ResultPage invokeNewSearchRequest(String text){
        findElemOnThePage(searchInput);
        searchInput.click();
        searchInput.sendKeys(text,Keys.ENTER);
        logger.info("Search request invoked");
        return new ResultPage(driver);
    }
}
