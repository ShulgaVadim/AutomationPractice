package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {

    private ArrayList<String> productNames = new ArrayList<>(Arrays.asList("Faded Short Sleeve T-shirts", "Printed Chiffon Dress"));

    @Test
    @Description("Add Products to Cart from Product page")
    public void addProductToCartFromProductPage() {
        womanProductPage
                .openPage()
                .addProductsToCart(productNames);
        cartPage
                .openPage();
        Assertions.assertAll(
                () -> assertEquals(cartPage.getTotalPrice(), cartPage.getProductsPrice()),
                () -> assertEquals(cartPage.getProductNames(), productNames));
    }
}
