package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.ProductPage;
import pages.WishlistPage;

public class WishlistTest extends BaseTest {

    private ProductPage productPage;
    private WishlistPage wishlistPage;
    private String wishlist;
    private String product = "Blouse";

    @BeforeEach
    public void login() {
        new LoginPage(driver).login(user.getEmail(), user.getPassword());
        productPage = new ProductPage(driver);
        wishlistPage = new WishlistPage(driver);
    }

    @Description("Wishlist was created automatically")
    @Test
    public void wishlistCanBeCreatedAutomatically() {
        wishlist = "My wishlist";
        productPage.openPage().addProductToWishlist(product);
        wishlistPage.openPage();
        Assertions.assertTrue(wishlistPage.isWishlistPresent(wishlist));
    }

    @Description("Product was added to Wishlist created automatically")
    @Test
    public void productIsInWishlistCreatedAutomatically() {
        wishlist = "My wishlist";
        productPage.openPage().addProductToWishlist(product);
        wishlistPage.openPage().openWishlist(wishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
    }

    @Description("Product was added to Wishlist created by user")
    @Test
    public void productWasAddedToWishlist() {
        wishlist = "Test wishlist";
        wishlistPage.openPage().createWishlist(wishlist);
        productPage.openPage().addProductToWishlist(product);
        wishlistPage.openPage().openWishlist(wishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
    }

    @AfterEach
    public void deleteWishlistAndLogout() {
        wishlistPage.deleteWishlist(wishlist).logout();
    }
}

