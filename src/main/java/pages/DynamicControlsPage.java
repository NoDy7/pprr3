package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage {

    private static final String URL = "/dynamic_controls";

    private final By checkbox = By.id("checkbox");
    private final By toggleButton = By.cssSelector("#checkbox-example button");
    private final By message = By.id("message");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
        return this;
    }

    public void clickToggleAndWaitForMessage() {
        driver.findElement(toggleButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

    public void waitForCheckboxGone() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }

    public void waitForCheckboxVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
    }
}
