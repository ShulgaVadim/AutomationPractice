package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WishlistPage extends BasePage {
    private static final String WISHLIST_URL = URL + "index.php?fc=module&module=blockwishlist&controller=mywishlist";
    private static final By NAME_INPUT = By.id("name");
    private static final By SAVE_BUTTON = By.id("submitWishlist");
    private static final By LOGOUT_BUTTON = By.className("logout");
    String autoCreatedWishlist = "//table//a[contains(text(), '%s')]";
    String productLocator = "s_title";
    String deleteWishlist = "//a[contains(text(), '%s')]/ancestor::table//i";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page: " + WISHLIST_URL)
    public WishlistPage openPage() {
        driver.get(WISHLIST_URL);
        return this;
    }

    @Step("Checking {wishlist} is present in account settings")
    public boolean isWishlistPresent(String wishlist) {
        return driver.findElement(By.xpath(String.format(autoCreatedWishlist, wishlist))).isDisplayed();
    }

    @Step("Open {wishlist}")
    public WishlistPage openWishlist(String wishlist) {
        driver.findElement(By.xpath(String.format(autoCreatedWishlist, wishlist))).click();
        return this;
    }

    @Step("Checking {wishlistProduct} is present in wishList")
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

    @Step("Logout")
    public void logout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON)).click();
    }
}

