package planitproject.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends HomePage {

    public Checkout(WebDriver driver) {
        super(driver);

    }

    public Checkout setFirstName(String firstName) {
        new WebDriverWait(driver,
                Duration.ofSeconds(20))
                .until(d -> d.findElement(By.id("first-name"))).sendKeys(firstName);
        // driver.findElement(By.id("first-name")).sendKeys(firstName);
        return this;
    }

    public Checkout setLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        return this;
    }

    public Checkout setZipCode(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        return this;
    }

    public Checkout clickContinueButton() {
        driver.findElement(By.id("continue")).click();
        return this;
    }

    public Checkout clickFinishButton() {
        driver.findElement(By.id("finish")).click();
        return this;
    }

    // Success of checkout message retrieved via title of the pages
    public String getProductPageTitle() {
        return driver.findElement(By.className("title")).getText();
    }

}
