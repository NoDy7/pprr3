package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test(description = "Verify dropdown options exist and selection works")
    public void selectOptionsAndVerify() {
        DropdownPage page = new DropdownPage(driver).openPage();

        List<String> options = page.getAllOptionsText();
        Assert.assertTrue(options.contains("Option 1"), "Dropdown should contain 'Option 1'");
        Assert.assertTrue(options.contains("Option 2"), "Dropdown should contain 'Option 2'");

        page.selectByIndex(1);
        Assert.assertEquals(page.getSelectedOptionText(), "Option 1");

        page.selectByIndex(2);
        Assert.assertEquals(page.getSelectedOptionText(), "Option 2");
    }
}
