package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Common base class for all Page Objects: holds the driver reference
 * and a shared explicit wait.
 */
public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected static final String BASE_URL = "https://the-internet.herokuapp.com";

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigates to the page's relative path (e.g. "/checkboxes").
     */
    public void open(String relativePath) {
        driver.get(BASE_URL + relativePath);
    }
}
