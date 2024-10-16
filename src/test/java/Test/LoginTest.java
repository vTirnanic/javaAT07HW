package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        validUsername = excelReader.getStringData("Sheet1",1,0);
        validPassword = excelReader.getStringData("Sheet1",1,2);
        invalidUsername = excelReader.getStringData("Sheet1",1,1);
        invalidPassword = excelReader.getStringData("Sheet1", 1,3);
    }

    @Test
    public void userCanLoginWithValidUsernameAndPassword() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(secureareaPage.getLogoutButton().isDisplayed());
        Assert.assertTrue(secureareaPage.getLoginMessage().getText().contains("You logged into a secure area!"));
    }

    @Test
    public void userCannotLoginWithInvalidUsernameAndValidPassword() {
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("Your username is invalid!"));
    }

    @Test
    public void userCannotLoginWithValidUsernameAndInvalidPassword() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("Your password is invalid!"));
    }

    @Test
    public void userCannotLoginWithInvalidUsernameAndInvalidPassword() {
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("Your username is invalid!"));
    }
}
