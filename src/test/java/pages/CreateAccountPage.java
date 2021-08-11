package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    private static final By REGISTER_BUTTON = By.id("submitAccount");
    private static final By FIRST_NAME_INPUT = By.id("customer_firstname");
    private static final By LAST_NAME_INPUT = By.id("customer_lastname");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By ADDRESS_INPUT = By.id("address1");
    private static final By CITY_INPUT = By.id("city");
    private static final By STATE_SELECT = By.id("id_state");
    private static final By POSTAL_CODE_INPUT = By.id("postcode");
    private static final By PHONE_INPUT = By.id("phone_mobile");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_INPUT));
    }

    @Step("Provide First Name: {firstName}")
    public CreateAccountPage provideFirstName(String firstName) {

        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        return this;
    }

    @Step("Provide Last Name: {lastName}")
    public CreateAccountPage provideLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        return this;
    }

    @Step("Provide Password: {password}")
    public CreateAccountPage providePassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Provide Address: {address}")
    public CreateAccountPage provideAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        return this;
    }

    @Step("Provide City: {city}")
    public CreateAccountPage provideCity(String city) {
        driver.findElement(CITY_INPUT).sendKeys(city);
        return this;
    }

    @Step("Provide State: {state}")
    public CreateAccountPage provideState(String state) {
        driver.findElement(STATE_SELECT).click();
        new Select(driver.findElement(STATE_SELECT)).selectByVisibleText(state);
        return this;
    }

    @Step("Provide Postal Code: {postalCode}")
    public CreateAccountPage providePostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
        return this;
    }

    @Step("Provide Phone: {phone}")
    public CreateAccountPage providePhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    @Step("Click Register button")
    public AccountPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return new AccountPage(driver);
    }
}
