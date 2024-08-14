package TrendyolHomework_16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Driver{
    WebDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement popUp = driver.findElement(By.xpath("//*[@id=\"Combined-Shape\"]"));
        popUp.click();
    }

    @Test (priority = 2)
    public void validLoginTest() throws InterruptedException {
        driver.navigate().to("https://www.trendyol.com/giris?cb=%2F");
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(2000);
        String expectedLink = "https://www.trendyol.com/";
        Assert.assertEquals(expectedLink, driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void invalidLoginTest() throws InterruptedException {
        driver.navigate().to("https://www.trendyol.com/giris?cb=%2Fsepet");
        Thread.sleep(2000);
        loginPage.login("invalid_user",ConfigReader.getProperty("password"));
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        String expectedError= "Lütfen geçerli bir e-posta adresi giriniz.";
        Assert.assertEquals(expectedError,loginPage.errorMessage.getText());
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
