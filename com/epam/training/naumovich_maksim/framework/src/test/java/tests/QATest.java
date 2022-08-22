package tests;

import model.Instances;
import org.testng.annotations.*;
import page.google.MainPage;
import service.ConstantData;
import service.InstancesCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class QATest extends BaseTest {

    @Test
    public void priceCheck(){
        Instances testDataInstances = InstancesCreator.getParametersFromProperty();
        String actualCost = new MainPage(driver)
                .openPage()
                .invokeNewSearchRequest(ConstantData.getSearchingRequest())
                .openPricingCalculatorLink()
                .chooseComputeEngineElement()
                .putDataIntoInstancesBlock(testDataInstances)
                .getEstimatedCost();
        assertThat(actualCost,is(equalTo(ConstantData.getExpectedCost())));
    }

}
