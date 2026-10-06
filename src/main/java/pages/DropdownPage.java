package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {

    private static final String URL = "/dropdown";

    private final By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        return this;
    }

    private Select select() {
        return new Select(driver.findElement(dropdownLocator));
    }

    public List<String> getAllOptionsText() {
        return select().getOptions().stream().map(o -> o.getText().trim()).toList();
    }

    public void selectByIndex(int index) {
        select().selectByIndex(index);
    }

    public String getSelectedOptionText() {
        return select().getFirstSelectedOption().getText().trim();
    }
}
