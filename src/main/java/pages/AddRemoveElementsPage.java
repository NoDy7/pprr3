package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    private static final String URL = "/add_remove_elements/";

    private final By addButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public AddRemoveElementsPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        return this;
    }

    public void clickAddElement() {
        driver.findElement(addButton).click();
    }

    public void clickDeleteElement() {
        List<org.openqa.selenium.WebElement> deletes = driver.findElements(deleteButtons);
        if (!deletes.isEmpty()) {
            deletes.get(0).click();
        }
    }

    public int getElementsCount() {
        return driver.findElements(deleteButtons).size();
    }
}
