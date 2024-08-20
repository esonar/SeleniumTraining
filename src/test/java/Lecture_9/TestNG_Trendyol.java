package Lecture_9;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;

public class TestNG_Trendyol {

    static WebDriver driver;

@BeforeClass
    public void openBrowser() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.navigate().to("https://www.trendyol.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement popUp = driver.findElement(By.xpath("//*[@id=\"Combined-Shape\"]"));
        popUp.click();

    }

    @Test (priority = 2)
    public void successfulLogin() throws InterruptedException {

        driver.navigate().to("https://www.trendyol.com/giris?cb=%2F");
        WebElement emailGiris = driver.findElement(By.id("login-email"));
        emailGiris.sendKeys("ecenur2008@gmail.com");
        Thread.sleep(2000);
        WebElement sifreGiris = driver.findElement(By.id("login-password-input"));
        sifreGiris.sendKeys("morcivert");
        Thread.sleep(2000);
        WebElement submit= driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button"));
        submit.click();

        Thread.sleep(3000);
        String expectedLink = "https://www.trendyol.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedLink);

    }

    @Test (priority = 1)
    public void unsuccessfulLogin() throws InterruptedException {
        WebElement girisYap = driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]/p"));
        girisYap.click();
        WebElement emailGiris = driver.findElement(By.id("login-email"));
        emailGiris.sendKeys("invalid");
        Thread.sleep(2000);
        WebElement sifreGiris = driver.findElement(By.id("login-password-input"));
        sifreGiris.sendKeys("morcivert");
        Thread.sleep(2000);
        WebElement submit= driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button"));
        submit.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"error-box-wrapper\"]/span[2]"));
        Assert.assertTrue(errorMessage.isDisplayed());
        String expectedError= "Lütfen geçerli bir e-posta adresi giriniz.";
        Assert.assertEquals(expectedError,errorMessage.getText());


    }

    @Test (priority = 3)
    public void searchElbise() throws InterruptedException {

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div[1]/input"));
        searchBar.sendKeys("Elbise");
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/i"));
        searchButton.click();

        String expectedURL="https://www.trendyol.com/sr?q=Elbise&qt=Elbise&st=Elbise&os=1";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test (priority = 4)
    public void elbiseCount() throws InterruptedException {

        driver.navigate().to("https://www.trendyol.com/sr?q=Elbise&qt=Elbise&st=Elbise&os=1");
        List<WebElement> elbiseItems = driver.findElements(By.cssSelector(".image-overlay-header"));
        System.out.println(elbiseItems.size());
        Assert.assertNotEquals(elbiseItems.size(), 0);
    }



    @Test (priority = 5)
    public void addElbiseToCart() throws InterruptedException {

        WebElement elbise = driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[4]/div[1]/div/div[2]/div[1]/a/div[1]/div[2]/div[2]"));
        elbise.click();
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement sizeElbise= driver.findElement(By.xpath("//div[@class='sp-itm' and @title='Beden seçmek için tıklayınız' and text()='XL']"));
        sizeElbise.click();
        Thread.sleep(2000);
        WebElement sepeteEkle= driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[5]/button/div[1]"));
        sepeteEkle.click();

        Thread.sleep(2000);

        WebElement popupCart= driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[2]/div"));
        Assert.assertTrue(popupCart.isDisplayed());

    }

    @AfterClass
    public void shutDown() {
    driver.quit();
    }
}
