package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final String URL = "/checkboxes";

    private final By checkboxLocator = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxesPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxLocator));
        return this;
    }

    private List<WebElement> checkboxes() {
        return driver.findElements(checkboxLocator);
    }

    public boolean isChecked(int index) {
        return checkboxes().get(index).isSelected();
    }

    public void toggle(int index) {
        checkboxes().get(index).click();
    }
}
