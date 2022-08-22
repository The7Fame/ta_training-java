package page.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;


public class FakeMailPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement emailGenerate;

    @FindBy(xpath = "//button[@onclick=\"clipboard('egen')\"]")
    private WebElement copyEmail;

    @FindBy(xpath = "//button[@onclick=\"egengo();\"]")
    private WebElement checkEmail;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//table//td[4]")
    private WebElement costInTheLetter;


    public FakeMailPage(WebDriver driver) {
        super(driver);
    }

    public FakeMailPage clickOnEmailRandomGenerate(){
        emailGenerate.click();
        return this;
    }

    public FakeMailPage clickCopyEmailToClipboard(){
        copyEmail.click();
        return this;
    }

    public FakeMailPage clickCheckEmail(){
        checkEmail.click();
        return this;
    }

    public FakeMailPage refresh(){
        findElemOnThePage(refreshButton);
        refreshButton.click();
        return this;
    }

    public FakeMailPage switchToIfMailFrame(){
        driver.switchTo().frame("ifmail");
        return this;
    }

    public String getCostInTheLetter(){
        findElemOnThePage(costInTheLetter);
        return costInTheLetter.getText();
    }
}
