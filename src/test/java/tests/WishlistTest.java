package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.*;

public class WishlistTest extends BaseTest {

    private LoginPage loginPage;
    private WishlistPage wishlistPage;
    private ProductPage productPage;
    private AccountPage accountPage;
    private String wishlist;
    private String product = "Blouse";

    @BeforeEach
    public void login() {
        loginPage = new LandingPage(driver).clickSignInButton();
        loginPage.login(user.getEmail(), user.getPassword());
        wishlistPage = new WishlistPage(driver);
        productPage = new ProductPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Description("Wishlist was created automatically")
    @Test
    public void wishlistCanBeCreatedAutomatically() {
        wishlist = "My wishlist";
        accountPage.clickProductsButton();
        productPage.addProductToWishlist(product).clickAccountNameButton();
        accountPage.clickWishlistButton();
        Assertions.assertTrue(wishlistPage.isWishlistPresent(wishlist));
    }

    @Description("Product was added to Wishlist created automatically")
    @Test
    public void productIsInWishlistCreatedAutomatically() {
        wishlist = "My wishlist";
        accountPage.clickProductsButton();
        productPage.addProductToWishlist(product).clickAccountNameButton();
        accountPage.clickWishlistButton();
        wishlistPage.openWishlist(wishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
    }

    @Description("Product was added to Wishlist created by user")
    @Test
    public void productWasAddedToWishlist() {
        wishlist = "Test wishlist";
        accountPage.clickWishlistButton().createWishlist(wishlist).clickProductsButton();
        productPage.addProductToWishlist(product).clickAccountNameButton();
        accountPage.clickWishlistButton().openWishlist(wishlist);
        Assertions.assertEquals(wishlistPage.getProductInWishlist(), product);
    }

    @AfterEach
    public void deleteWishlistAndLogout() {
        wishlistPage.deleteWishlist(wishlist).logout();
    }
}

