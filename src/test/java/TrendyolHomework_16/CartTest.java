package TrendyolHomework_16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends Driver {
    WebDriver driver;
    CartPage cartPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().window().maximize();
        WebElement popUp = driver.findElement(By.xpath("//*[@id=\"Combined-Shape\"]"));
        popUp.click();
    }

    @Test
    public void addItemToCartTest() throws InterruptedException {
        Thread.sleep(2000);
        searchPage.searchItem("Elbise");
        Thread.sleep(2000);
        cartPage.addProductToCart();
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.isItemInCart());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

