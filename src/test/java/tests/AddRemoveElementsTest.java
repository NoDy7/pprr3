package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test(description = "Add 2 elements, delete 1, verify remaining count")
    public void addTwoAndDeleteOneElement() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver).openPage();

        Assert.assertEquals(page.getElementsCount(), 0, "Should start with 0 elements");

        page.clickAddElement();
        page.clickAddElement();
        Assert.assertEquals(page.getElementsCount(), 2, "Should have 2 elements after adding");

        page.clickDeleteElement();
        Assert.assertEquals(page.getElementsCount(), 1, "Should have 1 element after deleting");
    }
}
