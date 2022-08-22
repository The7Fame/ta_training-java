package maxim.naumovich.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "postform-text")
    private WebElement pasteField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement  pasteExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationMinutes;

    @FindBy(id = "postform-name")
    private WebElement pasteNameField;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement pasteButton;


    public HomePage openPage(String url){
        driver.get(url);
        return this;
    }

    public void setFieldPaste(String text){
        pasteField.sendKeys(text);
    }

    public void clickWhereTenMinutes(){
        pasteExpiration.click();
    }

    public void setTimeExpirationTenMin(){
        pasteExpirationMinutes.click();
    }

    public void writePasteName(String name){
        pasteNameField.sendKeys(name);
    }

    public void submitCreation(){
        pasteButton.click();
    }

    public String getText(){
        WebElement textName = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'de1')]")));
        return textName.getText();
    }

    public String getTitle(){
        WebElement textTitle = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'info-top')]/h1")));
        return textTitle.getText();
    }

    public HomePage doStuff(String text, String name){
        setFieldPaste(text);
        clickWhereTenMinutes();
        setTimeExpirationTenMin();
        writePasteName(name);
        submitCreation();
        return new HomePage(driver);
    }
}