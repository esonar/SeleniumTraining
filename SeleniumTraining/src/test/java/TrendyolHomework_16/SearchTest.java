package TrendyolHomework_16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends Driver {
    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        searchPage= new SearchPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement popUp = driver.findElement(By.xpath("//*[@id=\"Combined-Shape\"]"));
        popUp.click();
    }

    @Test (priority = 1)
    public void searchItemTest() {
        searchPage.searchItem("Elbise");
        String expectedURL="https://www.trendyol.com/sr?q=Elbise&qt=Elbise&st=Elbise&os=1";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test (priority = 2)
    public void elbiseCount() {

        driver.navigate().to("https://www.trendyol.com/sr?q=Elbise&qt=Elbise&st=Elbise&os=1");
        Assert.assertTrue(!searchPage.elbiseItems.isEmpty());
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
