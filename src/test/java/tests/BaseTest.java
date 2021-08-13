package tests;

import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import utils.MyTestWatcher;

import utils.data.TestDataGenerator;
import wevdriver.WebDriverSingleton;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MyTestWatcher.class)
public class BaseTest {

    public WebDriver driver;
    public User user = TestDataGenerator.getRegisteredUser();

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            WebDriverSingleton.closeBrowser();
        }
    }
}
