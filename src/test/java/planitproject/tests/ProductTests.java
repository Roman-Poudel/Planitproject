package planitproject.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import planitproject.model.pages.HomePage;

public class ProductTests extends BaseTestSuite {

    public void loginAsValidCustomer(String username, String password) {
        new HomePage(driver)
                .gotoLandingPage()
                .setUserName(username)
                .setPassword(password)
                .clickLoginButton();
    }

    @Test
    public void addItemToCart() {
        loginAsValidCustomer("standard_user", "secret_sauce");
        var productpage = new HomePage(driver).productPage().selectItem();

        assertEquals("1", productpage.hoverCartButton());

    }

    @Test
    public void checkOutCart() {
        loginAsValidCustomer("performance_glitch_user", "secret_sauce");
        var checkout = new HomePage(driver)
                .productPage()
                .selectItem().clickOnShoppingCart()
                .cartPages().clickCheckoutButton()
                .checkoutPages()
                .clickContinueButton()
                .setFirstName("Roman")
                .setLastName("Poudel")
                .setZipCode("2150")
                .clickContinueButton()
                .clickFinishButton();

        assertEquals("CHECKOUT: COMPLETE!", checkout.getProductPageTitle());

    }
}
