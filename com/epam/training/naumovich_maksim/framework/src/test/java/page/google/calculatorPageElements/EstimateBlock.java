package page.google.calculatorPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import utils.StringStuff;


public class EstimateBlock extends AbstractPage {

    private static final String divContains = "//div[contains(@class,'md-list-item-text') and contains(text(),";

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    private WebElement numberOfInstances;
    @FindBy(xpath = divContains + "'Region')]")
    private WebElement region;
    @FindBy(xpath = divContains + "'Commitment term')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = divContains + "'VM class')]")
    private WebElement vmClass;
    @FindBy(xpath = divContains + "'Instance type')]")
    private WebElement instanceType;
    @FindBy(xpath = divContains + "'Local SSD')]")
    private WebElement localSSD;
    @FindBy(xpath = "//div[contains(@class,'md-list-item-text')]/b[contains(text(),'Cost')]")
    private WebElement cost;
    @FindBy(xpath = "//button[@aria-label='Email']")
    private WebElement emailEstimateButton;

    public EstimateBlock(WebDriver driver) {
        super(driver);
    }

    public String getEstimatedCost(){
        return getCost();
    }

    public EmailBlock clickOnSendEstimationByEmail(){
        emailEstimateButton.click();
        return new EmailBlock(driver);
    }

    private String getCost(){
        return StringStuff.getValue(cost,"(?<=Estimated Component Cost: USD\\s)[\\d,.]*");
    }

}
