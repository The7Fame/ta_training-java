package maxim.naumovich.page;

import org.openqa.selenium.WebDriver;

abstract public class AbstractPage {
    protected WebDriver driver;
    AbstractPage(WebDriver driver){
        this.driver=driver;
    }

}
