package tests;

import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.*;

import utils.MyTestWatcher;

import utils.data.TestDataGenerator;
import wevdriver.WebDriverSingleton;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MyTestWatcher.class)
public class BaseTest {

    public LoginPage loginPage;
    public CreateAccountPage createAccountPage;
    public AccountPage accountPage;
    public WomanProductPage womanProductPage;
    public WishlistPage wishlistPage;
    public CartPage cartPage;
    public WebDriver driver;
    User user = TestDataGenerator.getRegisteredUser();

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountPage = new AccountPage(driver);
        womanProductPage = new WomanProductPage(driver);
        wishlistPage = new WishlistPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            WebDriverSingleton.closeBrowser();
        }
    }
}
