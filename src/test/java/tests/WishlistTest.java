package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

public class WishlistTest extends BaseTest {

    String autoCreatedWishlist = "My wishlist";
    String createdWishlist = "Test wishlist";
    String product = "Blouse";

    @BeforeEach
    public void login() {
        loginPage
                .openPage()
                .login(user.getEmail(), user.getPassword());
    }

    @Description("Wishlist was created automatically and added product is in the list")
    @Test
    public void wishlistCanBeCreatedAutomatically() {
        womanProductPage
                .openPage()
                .addProductToWishlist(product);
        wishlistPage
                .openPage();
        Assertions.assertTrue(wishlistPage.isWishlistPresent(autoCreatedWishlist));
        wishlistPage
                .openWishlist(autoCreatedWishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
        wishlistPage
                .deleteWishlist(autoCreatedWishlist);
    }

    @Description("Product was added to Wishlist created by user")
    @Test
    public void productWasAddedToWishlist() {
        wishlistPage
                .openPage()
                .createWishlist(createdWishlist);
        womanProductPage
                .openPage()
                .addProductToWishlist(product);
        wishlistPage
                .openPage()
                .openWishlist(createdWishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
        wishlistPage
                .deleteWishlist(createdWishlist);
    }

    @AfterEach
    public void logout() {
        wishlistPage.logout();
    }
}
