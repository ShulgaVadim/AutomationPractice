package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By EMAIL_CREATE_INPUT = By.id("email_create");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By LOGIN_BUTTON = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(LOGIN_URL);
    }

    @Step("Provide Email Create: {email}")
    public CreateAccountPage provideEmail(String email) {
        driver.findElement(EMAIL_CREATE_INPUT).sendKeys(email);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new CreateAccountPage(driver);
    }

    @Step("Login with Email: {email}, password: {password}")
    public AccountPage login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new AccountPage(driver);
    }
}
