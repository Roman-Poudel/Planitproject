package planitproject.model.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public Login gotoLandingPage() {
        return new Login(driver);
    }

    public Product productPage() {
        return new Product(driver);
    }

    public CartInfo cartPages() {
        return new CartInfo(driver);
    }

    public Checkout checkoutPages() {
        return new Checkout(driver);
    }
}
