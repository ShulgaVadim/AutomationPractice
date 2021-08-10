package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductPage;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {

    private ProductPage productPage;
    private CartPage cartPage;
    private ArrayList<String> productNames = new ArrayList<>(Arrays.asList("Faded Short Sleeve T-shirts", "Printed Chiffon Dress"));

    @Test
    @Description("Add Products to Cart from Product page")
    public void addProductToCartFromProductPage() {
        productPage = new ProductPage(driver);
        productPage.openPage().addProductsToCart(productNames);
        cartPage = new LandingPage(driver).goToCart();
        Assertions.assertAll(
                () -> assertEquals(cartPage.getTotalPrice(), cartPage.getProductsPrice()),
                () -> assertEquals(cartPage.getProductNames(), productNames));
    }
}
