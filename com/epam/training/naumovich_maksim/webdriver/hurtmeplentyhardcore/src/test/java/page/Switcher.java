package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Switcher extends AbstractPage {
    ArrayList<String> tabs;
    JavascriptExecutor js;

    public Switcher(WebDriver driver){
        super(driver);
    }

    public void switchToNewTab(){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToOldTab(){
        driver.switchTo().window(tabs.get(0));
    }

}
