package tests;

import io.qameta.allure.Description;
import models.User;
import org.junit.jupiter.api.Test;
import utils.data.TestDataGenerator;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {
    User newUser = TestDataGenerator.createNewUser();


    @Description("New User creation with valid data")
    @Test
    public void createNewUser() {
        loginPage
                .openPage()
                .setEmail(newUser.getEmail());
        createAccountPage
                .setFirstName(newUser.getFirstName())
                .setLastName(newUser.getLastName())
                .setPassword(newUser.getPassword())
                .setAddress(newUser.getAddress())
                .setCity(newUser.getCity())
                .setState(newUser.getState())
                .setPostalCode(newUser.getPostalCode())
                .setPhone(newUser.getPhone())
                .clickRegisterButton();
        assertEquals(accountPage.getAccountName(), newUser.getFirstName() + " " + newUser.getLastName());
    }
}
