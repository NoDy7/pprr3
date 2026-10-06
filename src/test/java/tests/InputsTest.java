package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test(description = "Enter numeric value and adjust it via ARROW_UP/ARROW_DOWN")
    public void enterNumberAndUseArrowKeys() {
        InputsPage page = new InputsPage(driver).openPage();

        page.enterValue("5");
        Assert.assertEquals(page.getValue(), "5");

        page.pressArrowUp();
        Assert.assertEquals(page.getValue(), "6", "ARROW_UP should increment the value");

        page.pressArrowDown();
        page.pressArrowDown();
        Assert.assertEquals(page.getValue(), "4", "ARROW_DOWN should decrement the value");
    }

    @Test(description = "Non-numeric input should be rejected by the number field")
    public void nonNumericInputIsRejected() {
        InputsPage page = new InputsPage(driver).openPage();

        page.enterValue("abc");
        Assert.assertEquals(page.getValue(), "", "Non-numeric characters should not be accepted");
    }
}
