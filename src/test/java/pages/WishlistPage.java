package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishlistPage extends BasePage {
    private static final By NAME_INPUT = By.id("name");
    private static final By SAVE_BUTTON = By.id("submitWishlist");
    private String autoCreatedWishlist = "//table//a[contains(text(), '%s')]";
    private String productLocator = "s_title";
    private String deleteWishlist = "//a[contains(text(), '%s')]/ancestor::table//i";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }


    @Step("Validate {wishlist} is present in account settings")
    public boolean isWishlistPresent(String wishlist) {
        return driver.findElement(By.xpath(String.format(autoCreatedWishlist, wishlist))).isDisplayed();
    }

    @Step("Open {wishlist}")
    public WishlistPage openWishlist(String wishlist) {
        driver.findElement(By.xpath(String.format(autoCreatedWishlist, wishlist))).click();
        return this;
    }

    @Step("Get product in wishlist")
    public String getProductInWishlist() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(productLocator))).getText();
    }

    @Step("Create wishlist: {wishlistName}")
    public WishlistPage createWishlist(String wishlistName) {
        driver.findElement(NAME_INPUT).sendKeys(wishlistName);
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    @Step("Delete wishlist: {wishlistName}")
    public WishlistPage deleteWishlist(String wishlistName) {
        driver.findElement(By.xpath(String.format(deleteWishlist, wishlistName))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }
}

