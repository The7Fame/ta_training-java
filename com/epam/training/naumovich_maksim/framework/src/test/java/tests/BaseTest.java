package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Switcher;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected Switcher tabManager;

    @BeforeMethod
    public void setUp(){
        driver = DriverSingleton.getDriver();
        tabManager = new Switcher(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }
}
