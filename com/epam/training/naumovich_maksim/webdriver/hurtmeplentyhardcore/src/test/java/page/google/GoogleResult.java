package page.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;


public class GoogleResult extends AbstractPage {

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private WebElement googleCloudPricingCalculatorLink;

    public GoogleResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleResult clickOnPricingCalculatorLink(){
        findElemOnThePage(googleCloudPricingCalculatorLink);
        googleCloudPricingCalculatorLink.click();
        return this;
    }
}
