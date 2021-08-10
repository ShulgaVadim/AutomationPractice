package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

    private static final String PRODUCTS_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    private String productForAddingToCart = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']//a[@title='Add to cart']";
    private String productForAddingToWishlist = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']/following-sibling::div//a[contains(text(), 'Add to Wishlist')]";
    private static final By CLOSE_POP_UP_BUTTON = By.className("cross");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page: " + PRODUCTS_URL)
    public ProductPage openPage() {
        driver.get(PRODUCTS_URL);
        return this;
    }

    @Step("Add product {productName} to cart")
    public ProductPage addProductsToCart(List<String> productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(productForAddingToCart, productName))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_POP_UP_BUTTON)).click();
        }
        return this;
    }

    @Step("Add product {productName} to wishlist")
    public ProductPage addProductToWishlist(String productName) {
        driver.findElement(By.xpath(String.format(productForAddingToWishlist, productName))).click();
        return this;
    }
}
