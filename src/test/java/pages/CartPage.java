package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    private static final By TOTAL_PRICE = By.id("total_price");
    private static final By PRODUCT_PRICE = By.xpath("//td[@class='cart_total']//span[@class='price']");
    private String productName = "//td[@class='cart_description']//a[contains(text(), '%s')]";
    private List<WebElement> productPrices;
    private static final int TOTAL_SHIPPING = 2;
    private static final int TAX = 0;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get total cart price")
    public double getTotalPrice() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_PRICE)).getText().replace("$", ""));
    }

    @Step("Get total product prices")
    public double getProductPrices() {
        productPrices = driver.findElements(PRODUCT_PRICE);
        double sum = 0;
        for (WebElement price : productPrices) {
            double priceProduct = Double.parseDouble(price.getText().replace("$", ""));
            sum += priceProduct;
        }
        return sum + TOTAL_SHIPPING + TAX;
    }

    @Step("Validate product {product} is added to cart")
    public boolean isProductAdded(String product) {
        return driver.findElement(By.xpath(String.format(productName, product))).isDisplayed();
    }
}
