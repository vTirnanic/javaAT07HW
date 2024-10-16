package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureareaPage {

    WebDriver driver;
    WebElement logoutButton;
    WebElement loginMessage;

    public SecureareaPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".button.secondary.radius"));
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public WebElement getLoginMessage() {
        return driver.findElement(By.id("flash"));
    }
}
