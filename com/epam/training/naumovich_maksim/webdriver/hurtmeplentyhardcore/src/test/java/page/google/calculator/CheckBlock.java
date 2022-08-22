package page.google.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import page.AbstractPage;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckBlock extends AbstractPage {

    private static final String divContains = "//div[contains(@class,'md-list-item-text') and contains(text(),";

    @FindBy(xpath = divContains + "'Region')]")
    private WebElement region;

    @FindBy(xpath = divContains + "'Commitment term')]")
    private WebElement commitmentTerm;


    @FindBy(xpath = divContains + "'Instance type')]")
    private WebElement instanceType;

    @FindBy(xpath = divContains + "'Instance type')]//sub[@class='ng-scope']")
    private WebElement instanceTypeTextForExclusion;

    @FindBy(xpath = divContains + "'Local SSD')]")
    private WebElement localSSD;

    @FindBy(xpath = divContains + "'Local SSD')]//sub[@class='ng-scope']")
    private WebElement localSSDTextForExclusion;

    @FindBy(xpath = "//div[contains(@class,'md-list-item-text')]/b[contains(text(),'Cost')]")
    private WebElement cost;

    @FindBy(xpath = "//button[@aria-label='Email']")
    private WebElement emailEstimateButton;


    public CheckBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CheckBlock checkRegion(){
        String actualValue = region.getText().replaceAll("Region: ","");
        System.out.println(actualValue);
        Assert.assertEquals(actualValue, "Frankfurt");
        return this;
    }

    public CheckBlock checkCommitmentTerm(){
        String actualValue = commitmentTerm.getText().replaceAll("Commitment term: ","");
        System.out.println(actualValue);
        Assert.assertEquals(actualValue, "1 Year");
        return this;
    }

    public CheckBlock checkInstanceType(){
        String actualValue = instanceType.getText()
                                         .replaceAll("Instance type: ","")
                                         .replaceAll(instanceTypeTextForExclusion.getText(),"")
                                         .replaceAll(" ","")
                                         .replaceAll("\n","");
        Assert.assertEquals(actualValue,"n1-standard-8");
        return this;
    }

    public CheckBlock checkLocalSSD(){
        String actualValue = localSSD.getText()
                .replaceAll("Local SSD: ","")
                .replaceAll(localSSDTextForExclusion.getText(),"")
                .replaceAll(" ","")
                .replaceAll("\n","")
                .replaceAll("GiB"," GiB");
        System.out.println(actualValue);
        Assert.assertEquals(actualValue,"2x375 GiB");
        return this;
    }

    public String getCost(){
        StringBuilder actualValue = new StringBuilder();
        Matcher matcher = Pattern.compile("USD[ ,.\\d]+\\d").matcher(cost.getText());
        while (matcher.find()){
            actualValue.append(cost.getText(), matcher.start(), matcher.end());
        }
        System.out.println(actualValue.toString());
        return actualValue.toString();
    }

    public CheckBlock checkCostPrice(){
        String actualValue = getCost();
        System.out.println(actualValue);
        Assert.assertEquals(actualValue.toString(),"USD 1,081.20");
        return this;
    }

    public CheckBlock clickOnEmailEstimateButton(){
        findElemOnThePage(emailEstimateButton);
        emailEstimateButton.click();
        return this;
    }

    public CheckBlock fillEmailEstimateBlock(){
        EmailBlock emailEstimateBlock = new EmailBlock(driver);
        emailEstimateBlock
                .pasteEmailIntoEmailEstimate()
                .clickOnSendEmailButton();
        return this;
    }
}
