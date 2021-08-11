package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    private static final By ACCOUNT_NAME = By.xpath("//div[@class='header_user_info']//a//span");
    private static final By WISHLIST_BUTTON = By.className("lnk_wishlist");
    private static final By MY_ADDRESSES_BUTTON = By.xpath("//a[@title='Addresses']");

    public AccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_NAME));
    }

    @Step("Return Account Name")
    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    @Step("Click Wishlist button")
    public WishlistPage clickWishlistButton() {
        driver.findElement(WISHLIST_BUTTON).click();
        return new WishlistPage(driver);
    }

    @Step("Click My Addresses button")
    public MyAddressesPage clickMyAddressesButton() {
        driver.findElement(MY_ADDRESSES_BUTTON).click();
        return new MyAddressesPage(driver);
    }
}
