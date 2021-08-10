package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Description("Login with registered User")
    @Test
    public void loginWithRegisteredUser() {
        AccountPage accountPage = new LoginPage(driver).login(user.getEmail(),user.getPassword());
        Assertions.assertEquals(user.getFirstName() + " " + user.getLastName(), accountPage.getAccountName());
    }
}
