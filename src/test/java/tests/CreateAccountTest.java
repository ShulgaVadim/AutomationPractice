package tests;

import io.qameta.allure.Description;
import models.User;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.LoginPage;
import utils.data.TestDataGenerator;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {
    private User newUser = TestDataGenerator.createNewUser();


    @Description("New User creation with valid data")
    @Test
    public void createNewUser() {
        CreateAccountPage createAccountPage = new LoginPage(driver).provideEmail(newUser.getEmail());
        AccountPage accountPage = createAccountPage
                .provideFirstName(newUser.getFirstName())
                .provideLastName(newUser.getLastName())
                .providePassword(newUser.getPassword())
                .provideAddress(newUser.getAddress())
                .provideCity(newUser.getCity())
                .provideState(newUser.getState())
                .providePostalCode(newUser.getPostalCode())
                .providePhone(newUser.getPhone())
                .clickRegisterButton();
        assertEquals(accountPage.getAccountName(), newUser.getFirstName() + " " + newUser.getLastName());
    }
}
