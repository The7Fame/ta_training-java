package page.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.google.calculator.CheckBlock;
import page.google.calculator.FillBlock;

public class GooglePricing extends AbstractPage {

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::md-tab-item")
    private WebElement computeEngineElement;

    public GooglePricing(WebDriver driver) {
        super(driver);
    }

    public GooglePricing switchToMyFrame(){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public GooglePricing clickOnComputeEngineElement(){
        computeEngineElement.click();
        return this;
    }

    public GooglePricing fillInstancesBlock(){
        FillBlock instancesBlock = new FillBlock(driver);
        instancesBlock
                .pasteTextToNumberOfElementInput()
                .scrollToOperationSystemSoftwareMenu()
                .clickToSeriesMenu()
                .clickToSeriesMenuOptionN1()
                .clickToMachineTypeMenu()
                .clickToMachineTypeMenuStandart()
                .clickToComputeServerAddGPUs()
                .clickToGpuTypeMenu()
                .clickToGpuTypeMenuTeslaV100()
                .clickToNumberOfGpuMenu()
                .clickToNumberOfGpuMenuElement1()
                .clickToLocalSSDMenu()
                .clickToLocalSSDMenuElement2x375Gb()
                .clickToDataCenterLocationMenu()
                .clickToDataCenterLocationMenuElementFrankfurt()
                .scrollToDataCenterLocationMenu()
                .clickToCommittedUsageMenu()
                .clickToCommittedUsageMenuElement1Year()
                .clickToAddToEstimateEngineFormButton()
        ;
        return this;
    }

    public GooglePricing checkEstimateBlockValues(){
        CheckBlock estimateBlock = new CheckBlock(driver);
        estimateBlock
                .checkRegion()
                .checkCommitmentTerm()
                .checkInstanceType()
                .checkLocalSSD()
                .checkCostPrice()
        ;
        return this;
    }

    public GooglePricing emailEstimate(){
        CheckBlock estimateBlock = new CheckBlock(driver);
        estimateBlock
                .clickOnEmailEstimateButton()
                .fillEmailEstimateBlock();
        return this;
    }

    public String getCostInCalculator(){
        CheckBlock estimateBlock = new CheckBlock(driver);
        return estimateBlock.getCost();
    }
}
