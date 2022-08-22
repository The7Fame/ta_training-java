package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainTest extends BaseTest {

    @Test
    public static void hurtMePlenty(){
        cloudGooglePricingCalculatorPage.checkEstimateBlockValues();
    }

    @Test
    public static void hardcore() {
        switcher.switchToNewTab();
        driver.get("https://yopmail.com/ru/");
        mailPage
                .clickOnEmailRandomGenerate()
                .clickCopyEmailToClipboard();
        switcher.switchToOldTab();
        cloudGooglePricingCalculatorPage
                .switchToMyFrame()
                .emailEstimate();
        String expectedValue = cloudGooglePricingCalculatorPage.getCostInCalculator();
        switcher.switchToNewTab();
        mailPage
                .clickCheckEmail()
                .refresh()
                .switchToIfMailFrame()
        ;
        String actualValue = mailPage.getCostInTheLetter();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
