package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputsPage extends BasePage {

    private static final String URL = "/inputs";

    private final By inputLocator = By.tagName("input");

    public InputsPage(WebDriver driver) {
        super(driver);
    }

    public InputsPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        return this;
    }

    private WebElement input() {
        return driver.findElement(inputLocator);
    }

    public void clear() {
        input().clear();
    }

    public void enterValue(String value) {
        input().sendKeys(value);
    }

    public void pressArrowUp() {
        input().sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        input().sendKeys(Keys.ARROW_DOWN);
    }

    public String getValue() {
        return input().getAttribute("value");
    }
}
