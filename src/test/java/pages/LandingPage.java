package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private static final By SIGN_IN_BUTTON = By.className("login");
    private static final By CART_BUTTON = By.xpath("//div[@class='shopping_cart']/a");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Sign In button")
    public LoginPage login() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Click Cart button")
    public CartPage goToCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

}
