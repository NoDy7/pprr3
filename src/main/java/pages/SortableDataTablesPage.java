package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SortableDataTablesPage extends BasePage {

    private static final String URL = "/tables";

    private final By firstTable = By.id("table1");

    public SortableDataTablesPage(WebDriver driver) {
        super(driver);
    }

    public SortableDataTablesPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstTable));
        return this;
    }

    /**
     * Returns the text of a cell in table #1 (1-based row/column indices,
     * row 1 = first data row, header excluded).
     */
    public String getCellText(int row, int column) {
        By cellLocator = By.xpath(
                String.format("//table[@id='table1']//tbody//tr[%d]//td[%d]", row, column));
        return driver.findElement(cellLocator).getText().trim();
    }
}
