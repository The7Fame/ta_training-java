package utils;

import driver.DriverSingleton;
import org.openqa.selenium.*;
import page.AbstractPage;

import java.util.*;

public class Switcher extends AbstractPage {

    private static ArrayList<String> tabs;
    JavascriptExecutor js;

    public Switcher(WebDriver driver){
        super(driver);
    }


    public void switchToTab(int tabNumber){
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public void openNewTab() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void openOldTab(){
        driver.switchTo().window(tabs.get(0));
    }

    public void openCreatedTab(){
        driver.switchTo().window(tabs.get(1));
    }

}
