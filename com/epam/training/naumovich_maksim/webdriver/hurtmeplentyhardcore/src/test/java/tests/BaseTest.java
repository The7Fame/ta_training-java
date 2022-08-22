package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.Switcher;
import page.google.GoogleHome;
import page.google.GooglePricing;
import page.google.GoogleResult;
import page.mail.FakeMailPage;


public abstract class BaseTest {
    protected static WebDriver driver = new ChromeDriver();
    protected static Switcher switcher = new Switcher(driver);
    protected static GoogleHome CloudHomePage = new GoogleHome(driver);
    protected static GoogleResult cloudGoogleSearchPage = new GoogleResult(driver);
    protected static GooglePricing cloudGooglePricingCalculatorPage = new GooglePricing(driver);
    protected static FakeMailPage mailPage = new FakeMailPage(driver);

    @BeforeTest
    public static void inputData(){
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
        CloudHomePage
                .pressSearchInput()
                .pasteTextAndPressEnter();
        cloudGoogleSearchPage.clickOnPricingCalculatorLink();
        cloudGooglePricingCalculatorPage
                .switchToMyFrame()
                .clickOnComputeEngineElement()
                .fillInstancesBlock();
    }

    @AfterTest(alwaysRun = true)
    public static void closeDriver(){
        driver.quit();
        driver=null;
    }
}
