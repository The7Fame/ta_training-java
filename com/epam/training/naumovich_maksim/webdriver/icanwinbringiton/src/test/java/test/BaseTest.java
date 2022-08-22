package maxim.naumovich.test;

import maxim.naumovich.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    protected HomePage page;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new HomePage(driver);
        page.openPage(HOMEPAGE_URL);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }
}
