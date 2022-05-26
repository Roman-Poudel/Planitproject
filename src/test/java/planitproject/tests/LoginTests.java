package planitproject.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import planitproject.model.pages.HomePage;
import planitproject.model.pages.Login;
import planitproject.model.pages.Product;

public class LoginTests extends BaseTestSuite {

    public void loginCustomer(String username, String password) {
        new HomePage(driver)
                .gotoLandingPage()
                .setUserName(username)
                .setPassword(password)
                .clickLoginButton();
    }

    @Test
    public void verifyRequiredFieldsErrors() {
        var loginPage = new HomePage(driver)
                .gotoLandingPage()
                .clickLoginButton();

        assertEquals("Epic sadface: Username is required", loginPage.getUserNameErrorMessage());
    }

    @Test
    public void loginWithInvalidDetails() {
        loginCustomer("invalidcustomer", "invalidpassword");
        var invalidcustomer = new Login(driver);

        assertEquals("Epic sadface: Username and password do not match any user in this service",
                invalidcustomer.getUserNameErrorMessage());
    }

    @Test
    public void loginWithValidDetails() {
        loginCustomer(
                "standard_user",
                "secret_sauce");

        // assertEquals("https://www.saucedemo.com/inventory.html",
        // driver.getCurrentUrl());
        assertEquals("PRODUCTS", new Product(driver).getProductPageTitle());
    }

}
