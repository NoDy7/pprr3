package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HoversPage extends BasePage {

    private static final String URL = "/hovers";

    private final By figures = By.className("figure");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public HoversPage openPage() {
        open(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(figures));
        return this;
    }

    public int getFiguresCount() {
        return driver.findElements(figures).size();
    }

    /**
     * Hovers over the figure at the given 0-based index using Actions,
     * per https://stackoverflow.com/questions/17293914
     */
    public void hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figures).get(index);
        new Actions(driver).moveToElement(figure).perform();
        wait.until(ExpectedConditions.visibilityOf(
                figure.findElement(By.tagName("h5"))));
    }

    public String getCaptionName(int index) {
        WebElement figure = driver.findElements(figures).get(index);
        return figure.findElement(By.tagName("h5")).getText().trim();
    }

    public String getProfileLinkHref(int index) {
        WebElement figure = driver.findElements(figures).get(index);
        return figure.findElement(By.tagName("a")).getAttribute("href");
    }

    public void clickViewHereLink(int index) {
        WebElement figure = driver.findElements(figures).get(index);
        figure.findElement(By.tagName("a")).click();
    }

    public List<WebElement> allFigures() {
        return driver.findElements(figures);
    }
}
