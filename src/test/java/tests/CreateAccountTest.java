package tests;

import io.qameta.allure.Description;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.data.TestDataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountTest extends BaseTest {
    private User newUser = TestDataGenerator.createNewUser();
    LoginPage loginPage;
    CreateAccountPage createAccountPage;
    AccountPage accountPage;
    MyAddressesPage myAddressesPage;


    @Description("New User creation with valid data")
    @Test
    public void createNewUser() {
        loginPage = new LandingPage(driver).clickSignInButton();
        createAccountPage = loginPage.provideEmail(newUser.getEmail());
        accountPage = createAccountPage
                .provideFirstName(newUser.getFirstName())
                .provideLastName(newUser.getLastName())
                .providePassword(newUser.getPassword())
                .provideAddress(newUser.getAddress())
                .provideCity(newUser.getCity())
                .provideState(newUser.getState())
                .providePostalCode(newUser.getPostalCode())
                .providePhone(newUser.getPhone())
                .clickRegisterButton();
        myAddressesPage = accountPage.clickMyAddressesButton();
        Assertions.assertAll(
                () -> assertEquals(myAddressesPage.getFirstName(), newUser.getFirstName()),
                () -> assertEquals(myAddressesPage.getLastName(), newUser.getLastName()),
                () -> assertEquals(myAddressesPage.getAddress(), newUser.getAddress()),
                () -> assertEquals(myAddressesPage.getCity(), newUser.getCity()),
                () -> assertEquals(myAddressesPage.getState(), newUser.getState()),
                () -> assertEquals(myAddressesPage.getPostalCode(), newUser.getPostalCode()),
                () -> assertEquals(myAddressesPage.getPhone(), newUser.getPhone()));
    }
}
