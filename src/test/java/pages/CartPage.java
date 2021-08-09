package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private static final String CART_URL = URL + "index.php?controller=order";
    private static final By TOTAL_PRICE = By.id("total_price");
    private static final By PRODUCT_PRICE = By.xpath("//td[@class='cart_total']//span[@class='price']");
    private static final By PRODUCT_NAME = By.xpath("//td[@class='cart_description']//p[@class='product-name']/a");
    List<WebElement> productPrices;
    List<WebElement> productNames;
    int totalShipping = 2;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page: " + CART_URL)
    public CartPage openPage() {
        driver.get(CART_URL);
        return this;
    }

    @Step("Get total cart price")
    public double getTotalPrice() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_PRICE)).getText().substring(1));
    }

    @Step("Get total products price")
    public double getProductsPrice() {
        productPrices = driver.findElements(PRODUCT_PRICE);
        double sum = 0;
        for (WebElement price : productPrices) {
            double priceProduct = Double.parseDouble(price.getText().substring(1));
            sum += priceProduct;
        }
        return sum + totalShipping;
    }

    @Step("Get products names")
    public List<String> getProductNames() {
        productNames = driver.findElements(PRODUCT_NAME);
        List<String> names = new ArrayList<>();
        for (WebElement name : productNames) {
            String productName = name.getText();
            names.add(productName);
        }
        return names;
    }
}
