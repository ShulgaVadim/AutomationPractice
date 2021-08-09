package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class WomanProductPage extends BasePage {

    private static final String WOMAN_PRODUCT_URL = URL + "index.php?id_category=3&controller=category";
    String productForAddingToCart = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']//a[@title='Add to cart']";
    String productForAddingToWishlist = "//a[@class= 'product-name' and (contains(@title, '%s'))]/ancestor::div[@class='right-block']/following-sibling::div//a[contains(text(), 'Add to Wishlist')]";
    private static final By CLOSE_POP_UP_BUTTON = By.className("cross");

    public WomanProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page: " + WOMAN_PRODUCT_URL)
    public WomanProductPage openPage() {
        driver.get(WOMAN_PRODUCT_URL);
        return this;
    }

    @Step("Add product {productName} to cart")
    public WomanProductPage addProductsToCart(List<String> productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(productForAddingToCart, productName))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_POP_UP_BUTTON)).click();
        }
        return this;
    }

    @Step("Add product {productName} to wishlist")
    public WomanProductPage addProductToWishlist(String productName) {
        driver.findElement(By.xpath(String.format(productForAddingToWishlist, productName))).click();
        return this;
    }
}
