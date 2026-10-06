package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FormAuthenticationTest extends BaseTest {

    @Test(description = "Positive: valid credentials log the user in")
    public void positiveLogin() {
        LoginPage page = new LoginPage(driver).openPage();
        page.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(page.getFlashMessage().contains("You logged into a secure area!"),
                "Successful login message was not shown");
        Assert.assertTrue(page.isLogoutButtonDisplayed(), "Logout button should be displayed");
    }

    @Test(description = "Negative: invalid password shows an error")
    public void negativeLoginInvalidPassword() {
        LoginPage page = new LoginPage(driver).openPage();
        page.login("tomsmith", "wrong_password");

        Assert.assertTrue(page.getFlashMessage().contains("Your password is invalid!"),
                "Expected an 'invalid password' error message");
    }

    @Test(description = "Negative: invalid username shows an error")
    public void negativeLoginInvalidUsername() {
        LoginPage page = new LoginPage(driver).openPage();
        page.login("nobody", "SuperSecretPassword!");

        Assert.assertTrue(page.getFlashMessage().contains("Your username is invalid!"),
                "Expected an 'invalid username' error message");
    }
}
