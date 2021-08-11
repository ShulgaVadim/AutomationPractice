package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private String prod = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']";
    private String productForAddingToCart = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']//a[@title='Add to cart']";
    private String productForAddingToWishlist = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']/following-sibling::div//a[contains(text(), 'Add to Wishlist')]";
    private static final By ACCOUNT_NAME = By.xpath("//div[@class='header_user_info']//a//span");
    private static final By CLOSE_POP_UP_BUTTON = By.className("cross");
    Actions actions = new Actions(driver);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product {productName} to cart")
    public ProductPage addProductsToCart(String productName) {
        WebElement product = driver.findElement(By.xpath(String.format(prod, productName)));
        actions.moveToElement(product).build().perform();
        driver.findElement(By.xpath(String.format(productForAddingToCart, productName))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_POP_UP_BUTTON)).click();
        return this;
    }

    @Step("Add product {productName} to wishlist")
    public ProductPage addProductToWishlist(String productName) {
        WebElement product = driver.findElement(By.xpath(String.format(prod, productName)));
        actions.moveToElement(product).build().perform();
        driver.findElement(By.xpath(String.format(productForAddingToWishlist, productName))).click();
        return this;
    }


    @Step("Click Account Name button")
    public AccountPage clickAccountNameButton() {
        driver.findElement(ACCOUNT_NAME).click();
        return new AccountPage(driver);
    }
}
