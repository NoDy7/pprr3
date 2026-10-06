package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HoversTest extends BaseTest {

    @Test(description = "Hover over each profile, verify caption and that the profile link is not a 404")
    public void hoverOverEachProfileAndVerifyLink() throws IOException {
        HoversPage page = new HoversPage(driver).openPage();
        int count = page.getFiguresCount();
        Assert.assertEquals(count, 3, "Expected 3 hoverable profiles");

        for (int i = 0; i < count; i++) {
            page.hoverOverFigure(i);

            String caption = page.getCaptionName(i);
            Assert.assertTrue(caption.startsWith("name:"),
                    "Caption should show a name for figure " + i + " but was: " + caption);

            String href = page.getProfileLinkHref(i);
            Assert.assertFalse(isPageNotFound(href),
                    "Profile link for figure " + i + " returned 404: " + href);
        }
    }

    private boolean isPageNotFound(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        return responseCode == 404;
    }
}
