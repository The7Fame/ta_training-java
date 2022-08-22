package maxim.naumovich.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    static String pasteInField = "Hello from WebDriver";
    static String pasteInName = "helloweb";

    @Test
    public void testEqualPasteIn(){
        page.doStuff(pasteInField, pasteInName);
        String text = page.getText();
        String title = page.getTitle();
        Assert.assertEquals(pasteInField.equals(text), true);
    }

    @Test
    public void testEqualInName(){
        page.doStuff(pasteInField, pasteInName);
        String text = page.getText();
        String title = page.getTitle();
        Assert.assertEquals(pasteInField.equals(text), true);
    }

}
