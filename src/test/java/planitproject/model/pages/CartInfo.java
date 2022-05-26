package planitproject.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartInfo extends HomePage {

    public CartInfo(WebDriver driver) {
        super(driver);

    }

    public CartInfo clickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
        return this;
    }

}
