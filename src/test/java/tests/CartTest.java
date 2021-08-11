package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductPage;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    private ProductPage productPage;
    private LandingPage landingPage;
    private CartPage cartPage;
    private String product1 = "Faded Short Sleeve T-shirts";
    private String product2 = "Printed Chiffon Dress";
    private String product3 = "Blouse";

    @Test
    @Description("Add Products to Cart from Product page")
    public void addProductToCartFromProductPage() {
        productPage = new ProductPage(driver);
        landingPage = new LandingPage(driver);
        landingPage.clickProductsButton();
        productPage.addProductsToCart(product1).addProductsToCart(product2).addProductsToCart(product3);
        cartPage = landingPage.clickCartButton();
        Assertions.assertAll(
                () -> assertEquals(cartPage.getTotalPrice(), cartPage.getProductPrices()),
                () -> assertTrue(cartPage.isProductAdded(product1)),
                () -> assertTrue(cartPage.isProductAdded(product2)),
                () -> assertTrue(cartPage.isProductAdded(product3)));
    }
}
