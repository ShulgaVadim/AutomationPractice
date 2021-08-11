package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Description("Login with registered User")
    @Test
    public void loginWithRegisteredUser() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        AccountPage accountPage = loginPage.login(user.getEmail(), user.getPassword());
        Assertions.assertEquals(user.getFirstName() + " " + user.getLastName(), accountPage.getAccountName());
    }

    @Description("Login with invalid credentials")
    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        Assertions.assertTrue(loginPage.isAlertAppear("invalidEmail", "invalidPassword"));
    }
}
