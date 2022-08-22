package page.google.calculator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;


public class FillBlock extends AbstractPage {

    private static final String mdSelect = "//md-select[contains(@ng-model,'computeServer.";
    private static final String mdOption = "//md-option[contains";

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfElementInput;

    @FindBy(xpath = mdSelect + "os')]")
    private WebElement operationSystemSoftwareMenu;

    @FindBy(xpath = mdSelect + "series')]")
    private WebElement seriesMenu;

    @FindBy(xpath = mdOption + "(@value,'n1')]")
    private WebElement seriesMenuOptionN1;

    @FindBy(xpath = mdSelect + "instance')]")
    private WebElement machineTypeMenu;

    @FindBy(xpath = mdOption + "(@value,'N1-STANDARD-8')]")
    private WebElement getMachineTypeMenuStandart;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'computeServer.addGPUs')]")
    private WebElement computeServerAddGPUs;

    @FindBy(xpath = mdSelect + "gpuType')]")
    private WebElement gpuTypeMenu;

    @FindBy(xpath = mdOption + "(@value,'NVIDIA_TESLA_V100')]")
    private WebElement gpuTypeMenuTeslaV100;

    @FindBy(xpath = mdSelect + "gpuCount')]")
    private WebElement numberOfGpuMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'supportedGpuNumbers') and @value='1']")
    private WebElement numberOfGpuMenuElement1;

    @FindBy(xpath = mdSelect + "ssd')]")
    private WebElement localSSDMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'dynamicSsd.computeServer') and @value='2']")
    private WebElement localSSDMenuElement2x375Gb;

    @FindBy(xpath = mdSelect + "location')]")
    private WebElement dataCenterLocationMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'inputRegionText.computeServer') and @value='europe-west3']")
    private WebElement dataCenterLocationMenuElementFrankfurt;

    @FindBy(xpath = mdSelect + "cud')]")
    private WebElement committedUsageMenu;

    @FindBy(xpath = "//div[contains(@class,'md-active')]//md-option[@ng-value='1']")
    private WebElement committedUsageMenuElement1Year;

    @FindBy(xpath = "//button[contains(@ng-click,'addComputeServer(ComputeEngineForm)')]")
    private WebElement addToEstimateEngineFormButton;

    public FillBlock(WebDriver driver) {
        super(driver);
    }

    private FillBlock scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public FillBlock pasteTextToNumberOfElementInput(){
        numberOfElementInput.sendKeys("4");
        return this;
    }

    public FillBlock scrollToOperationSystemSoftwareMenu(){
        findElemOnThePage(operationSystemSoftwareMenu);
        scrollToElement(operationSystemSoftwareMenu);
        return this;
    }

    public FillBlock clickToSeriesMenu(){
        seriesMenu.click();
        return this;
    }

    public FillBlock clickToSeriesMenuOptionN1(){
        findElemOnThePage(seriesMenuOptionN1);
        seriesMenuOptionN1.click();
        return this;
    }

    public FillBlock clickToMachineTypeMenu(){
        machineTypeMenu.click();
        return this;
    }

    public FillBlock clickToMachineTypeMenuStandart(){
        findElemOnThePage(getMachineTypeMenuStandart);
        getMachineTypeMenuStandart.click();
        return this;
    }

    public FillBlock clickToComputeServerAddGPUs(){
        computeServerAddGPUs.click();
        return this;
    }

    public FillBlock clickToGpuTypeMenu(){
        gpuTypeMenu.click();
        return this;
    }

    public FillBlock clickToGpuTypeMenuTeslaV100(){
        findElemOnThePage(gpuTypeMenuTeslaV100);
        gpuTypeMenuTeslaV100.click();
        return this;
    }

    public FillBlock clickToNumberOfGpuMenu(){
        numberOfGpuMenu.click();
        return this;
    }

    public FillBlock clickToNumberOfGpuMenuElement1(){
        findElemOnThePage(numberOfGpuMenuElement1);
        numberOfGpuMenuElement1.click();
        return this;
    }

    public FillBlock clickToLocalSSDMenu(){
        localSSDMenu.click();
        return this;
    }

    public FillBlock clickToLocalSSDMenuElement2x375Gb(){
        findElemOnThePage(localSSDMenuElement2x375Gb);
        localSSDMenuElement2x375Gb.click();
        return this;
    }

    public FillBlock clickToDataCenterLocationMenu(){
        dataCenterLocationMenu.click();
        return this;
    }

    public FillBlock clickToDataCenterLocationMenuElementFrankfurt(){
        findElemOnThePage(dataCenterLocationMenuElementFrankfurt);
        dataCenterLocationMenuElementFrankfurt.click();
        return this;
    }

    public FillBlock scrollToDataCenterLocationMenu(){
        scrollToElement(dataCenterLocationMenu);
        return this;
    }

    public FillBlock clickToCommittedUsageMenu(){
        committedUsageMenu.click();
        return this;
    }

    public FillBlock clickToCommittedUsageMenuElement1Year(){
        findElemOnThePage(committedUsageMenuElement1Year);
        committedUsageMenuElement1Year.click();
        return this;
    }

    public FillBlock clickToAddToEstimateEngineFormButton(){
        addToEstimateEngineFormButton.click();
        return this;
    }
}
