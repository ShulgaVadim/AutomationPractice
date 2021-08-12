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

    @Description("Verify error message with empty email")
    @Test
    public void loginWithEmptyEmail() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login("", user.getPassword());
        Assertions.assertEquals(loginPage.verifyAlertText(), "An email address required.");
    }

    @Description("Verify error message with empty password")
    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login(user.getEmail(), "");
        Assertions.assertEquals(loginPage.verifyAlertText(), "Password is required.");
    }

    @Description("Verify error message with invalid emil")
    @Test
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login("invalidEmail@gmail.com", user.getPassword());
        Assertions.assertEquals(loginPage.verifyAlertText(), "Authentication failed.");
    }

    @Description("Verify error message with invalid password")
    @Test
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login(user.getEmail(), "invalidPassword");
        Assertions.assertEquals(loginPage.verifyAlertText(), "Authentication failed.");
    }
}
