package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationMessagePage extends BasePage {

    private static final String URL = "/notification_message";

    private final By clickHereLink = By.linkText("Click here");
    private final By notification = By.id("flash");

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public NotificationMessagePage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereLink));
        return this;
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    public String waitForNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notification)).getText().trim();
    }
}
