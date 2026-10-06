package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;

import java.util.List;

public class NotificationMessageTest extends BaseTest {

    // The site randomly shows one of these three notification variants
    // (including an intentionally unstable "Action unsuccessful" case).
    private static final List<String> ACCEPTABLE_VARIANTS = List.of(
            "Action successful",
            "To Insanity and Back",
            "Action unsuccessful, please try again"
    );

    @Test(description = "Click the link, wait for the notification, verify it matches an acceptable variant")
    public void clickAndVerifyNotificationText() {
        NotificationMessagePage page = new NotificationMessagePage(driver).openPage();

        page.clickHere();
        String notificationText = page.waitForNotificationText();

        boolean matchesAny = ACCEPTABLE_VARIANTS.stream().anyMatch(notificationText::contains);
        Assert.assertTrue(matchesAny,
                "Unexpected notification text (site content is known to vary): " + notificationText);
    }
}
