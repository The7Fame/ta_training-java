package page.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;


public class GoogleHome extends AbstractPage {

    public static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement formInput;


    public GoogleHome(WebDriver driver) {
        super(driver);
    }

    public GoogleHome pressSearchInput(){
        formInput.click();
        return this;
    }

    public GoogleHome pasteTextAndPressEnter(){
        formInput.sendKeys(SEARCH_TEXT, Keys.ENTER);
        return this;
    }
}
