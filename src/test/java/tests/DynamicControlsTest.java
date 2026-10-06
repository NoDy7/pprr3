package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends BaseTest {

    @Test(description = "Remove the checkbox, wait for it to disappear, then add it back")
    public void removeAndAddCheckbox() {
        DynamicControlsPage page = new DynamicControlsPage(driver).openPage();

        page.clickToggleAndWaitForMessage();
        page.waitForCheckboxGone();
        Assert.assertTrue(page.getMessage().contains("It's gone!"), "Expected 'It's gone!' message");

        page.clickToggleAndWaitForMessage();
        page.waitForCheckboxVisible();
        Assert.assertTrue(page.getMessage().contains("It's back!"), "Expected 'It's back!' message");
    }
}
