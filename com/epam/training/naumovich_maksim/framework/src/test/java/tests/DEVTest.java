package tests;

import model.Instances;
import org.testng.annotations.Test;
import page.google.MainPage;
import page.google.calculatorPageElements.EmailBlock;
import page.mail.CheckMail;
import page.mail.MailPage;
import service.ConstantData;
import service.InstancesCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DEVTest extends BaseTest {

    @Test
    public void postPriceCheck(){
        Instances testDataInstances = InstancesCreator.getParametersFromProperty();
        EmailBlock emailGoogleCloudBlock = new MainPage(driver)
                                                .openPage()
                                                .invokeNewSearchRequest(ConstantData.getSearchingRequest())
                                                .openPricingCalculatorLink()
                                                .chooseComputeEngineElement()
                                                .putDataIntoInstancesBlock(testDataInstances)
                                                .clickOnSendEstimationByEmail();
        tabManager.openNewTab();
        CheckMail checkingEmailPage =new MailPage(driver)
                                                    .openPage()
                                                    .generateRandomEmail()
                                                    .openPost()
        ;
        String emailAddress = checkingEmailPage.getEmailAddress();
        tabManager.openOldTab();
        String estimatedCost = emailGoogleCloudBlock
                                    .putDataIntoEmailBlock(emailAddress)
                                    .sendEmail()
                                    .getEstimatedCost()
        ;
        tabManager.openCreatedTab();
        String costFromLetter = checkingEmailPage.getCost();
        tabManager.openOldTab();
        assertThat(estimatedCost,is(equalTo(costFromLetter)));
    }
}
