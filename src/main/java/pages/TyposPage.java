package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TyposPage extends BasePage {

    private static final String URL = "/typos";

    // The example text sits inside <div class="example"><p>...</p></div>
    private final By paragraphLocator = By.cssSelector(".example p");

    public TyposPage(WebDriver driver) {
        super(driver);
    }

    public TyposPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paragraphLocator));
        return this;
    }

    public String getParagraphText() {
        return driver.findElement(paragraphLocator).getText().trim();
    }
}
