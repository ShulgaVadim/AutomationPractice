package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

    @Description("Login with registered User")
    @Test
    public void loginWithRegisteredUser() {
        loginPage
                .openPage()
                .login(user.getEmail(),user.getPassword());
        Assertions.assertEquals(user.getFirstName() + " " + user.getLastName(), accountPage.getAccountName());
    }
}
