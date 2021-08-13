package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private static final By PRODUCTS_BUTTON = By.className("sf-with-ul");
    private static final By LOGOUT_BUTTON = By.className("logout");
    private static final By CART_BUTTON = By.xpath("//div[@class='shopping_cart']/a");
    private static final By ERROR_ALERT = By.xpath("//div[@class='alert alert-danger']//li");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @Step("Click Products button")
    public ProductPage clickProductsButton() {
        driver.findElement(PRODUCTS_BUTTON).click();
        return new ProductPage(driver);
    }

    @Step("Click Cart button")
    public CartPage clickCartButton() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Logout")
    public LandingPage logout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON)).click();
        return new LandingPage(driver);
    }

    @Step("Validate Alert text")
    public String verifyAlertText() {
        return driver.findElement(ERROR_ALERT).getText();
    }
}

