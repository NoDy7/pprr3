package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test(description = "Verify initial state and toggling of both checkboxes")
    public void toggleCheckboxesAndVerifyState() {
        CheckboxesPage page = new CheckboxesPage(driver).openPage();

        // First checkbox starts unchecked
        Assert.assertFalse(page.isChecked(0), "First checkbox should start unchecked");
        page.toggle(0);
        Assert.assertTrue(page.isChecked(0), "First checkbox should be checked after toggle");

        // Second checkbox starts checked
        Assert.assertTrue(page.isChecked(1), "Second checkbox should start checked");
        page.toggle(1);
        Assert.assertFalse(page.isChecked(1), "Second checkbox should be unchecked after toggle");
    }
}
