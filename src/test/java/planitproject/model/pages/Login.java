package planitproject.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {
    public Login(WebDriver driver) {
        super(driver);
    }

    public Login clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
        return this;
    }

    public String getUserName() {
        return driver.findElement(By.id("id")).getText();
    }

    public String getPassword() {
        return driver.findElement(By.id("id")).getText();

    }

    public Login setUserName(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        return this;
    }

    public Login setPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public String getUserNameErrorMessage() {
        // couldnot found better unique class or id has to work with xpath
        // did not work with combined class too , throws error
        return driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
    }

    public String getPassWordErrorMessage() {
        return driver.findElement(By.className("error")).getText();
    }

}
