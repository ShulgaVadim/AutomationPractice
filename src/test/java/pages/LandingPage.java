package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private static final String URL = "http://automationpractice.com/";
    private static final By SIGN_IN_BUTTON = By.className("login");

    public LandingPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    @Step("Click Sign In button")
    public LoginPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }


}
