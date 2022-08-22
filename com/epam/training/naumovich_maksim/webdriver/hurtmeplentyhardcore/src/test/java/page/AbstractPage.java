package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void findElemOnThePage(WebElement element){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
