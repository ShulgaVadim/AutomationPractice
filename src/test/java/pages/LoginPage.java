package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {
    private static final String LOGIN_URL = URL + "index.php?controller=authentication&back=my-account";
    private static final By EMAIL_CREATE_INPUT = By.id("email_create");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By LOGIN_BUTTON = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page: " + LOGIN_URL)
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    @Step("Set Email Create: {email}")
    public CreateAccountPage setEmail(String email) {
        driver.findElement(EMAIL_CREATE_INPUT).sendKeys(email);
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new CreateAccountPage(driver);
    }


    @Step("Login with Email: {email}, password: {password}")
    public void login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
