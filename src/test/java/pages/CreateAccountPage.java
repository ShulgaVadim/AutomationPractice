package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@Log4j2
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
    }

    @Step("Set First Name: {firstName}")
    public CreateAccountPage setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_INPUT));
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        return this;
    }

    @Step("Set Last Name: {lastName}")
    public CreateAccountPage setLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        return this;
    }

    @Step("Set Password: {password}")
    public CreateAccountPage setPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Set Address: {address}")
    public CreateAccountPage setAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        return this;
    }

    @Step("Set City: {city}")
    public CreateAccountPage setCity(String city) {
        driver.findElement(CITY_INPUT).sendKeys(city);
        return this;
    }

    @Step("Set State: {state}")
    public CreateAccountPage setState(String state) {
        driver.findElement(STATE_SELECT).click();
        new Select(driver.findElement(STATE_SELECT)).selectByVisibleText(state);
        return this;
    }

    @Step("Set Postal Code: {postalCode}")
    public CreateAccountPage setPostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
        return this;
    }

    @Step("Set Phone: {phone}")
    public CreateAccountPage setPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    @Step("Click Register button")
    public AccountPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return new AccountPage(driver);
    }
}
