package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SortableDataTablesPage;

public class SortableDataTablesTest extends BaseTest {

    @Test(description = "Verify contents of several cells in the first sortable table")
    public void verifyTableCellsContent() {
        SortableDataTablesPage page = new SortableDataTablesPage(driver).openPage();

        Assert.assertEquals(page.getCellText(1, 1), "Smith");
        Assert.assertEquals(page.getCellText(1, 2), "John");
        Assert.assertEquals(page.getCellText(2, 1), "Bach");
        Assert.assertEquals(page.getCellText(2, 2), "Frank");
        Assert.assertEquals(page.getCellText(4, 1), "Conway");
    }
}
