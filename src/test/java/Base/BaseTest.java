package Base;

import Pages.SecureareaPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
/*
Domaci:
Pokusati login na sledecem sajtu: http://the-internet.herokuapp.com/login
Testirati:
1. valid username, valid password
2. invalid username, valid password
3. valid username, invalid password
4. invalid username, invalid password
Koristiti ucitavanje username-a i password-a iz excel-a
 */
public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public SecureareaPage secureareaPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        secureareaPage = new SecureareaPage(driver);

        excelReader = new ExcelReader("C:\\Users\\EKI TRANSFERS\\Downloads\\Testfajl2.xlsx");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
