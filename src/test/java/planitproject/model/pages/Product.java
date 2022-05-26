package planitproject.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product extends BasePage {

    public Product(WebDriver driver) {
        super(driver);
    }

    public Product selectItem() {
        new WebDriverWait(driver,
                Duration.ofSeconds(20))
                .until(d -> d.findElement(By.id("add-to-cart-sauce-labs-backpack"))).click();
        return this;
    }

    public String hoverCartButton() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();

    }

    public String getProductPageTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    public Product clickOnShoppingCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        return this;
    }

}
