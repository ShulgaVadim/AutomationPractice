package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

    @Description("Verify error message with invalid/blank data")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void loginWithInvalidData(String email, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login(email, password);
        Assertions.assertEquals(loginPage.verifyAlertText(), expectedErrorMessage);
    }
}
