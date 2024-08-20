package Lecture_11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class Exercise_1_2 {

    static WebDriver driver;

    @BeforeClass
            public void openDriver() {
        driver = new ChromeDriver();
        driver.navigate().to("https://webdriveruniversity.com/IFrame/index.html");
        driver.manage().window().maximize();
    }

    @Test
    public void exercise1() throws InterruptedException {

        Thread.sleep(2000);
        driver.switchTo().frame("frame");
        WebElement ourProducts = driver.findElement(By.xpath("//*[@id=\"div-main-nav\"]/div/ul/li[2]/a"));
        ourProducts.click();
        Thread.sleep(2000);
        WebElement desktopSystems = driver.findElement(By.xpath("//*[@id=\"container-product6\"]/div[1]/p"));
        desktopSystems.click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[1]/h4")).getText());
        driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[1]/button")).click();

        Thread.sleep(2000);
        driver.navigate().back();
        String expectedURL ="https://webdriveruniversity.com/IFrame/index.html";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

    }

    @Test
    public void exercise2() throws InterruptedException {
        driver.navigate().to("https://webdriveruniversity.com/");
        Thread.sleep(2000);
        WebElement loginPortal = driver.findElement(By.xpath("//*[@id=\"login-portal\"]/div/div[1]/h1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginPortal);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPortal);
       // loginPortal.click();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("text"));
        username.click();
        Thread.sleep(2000);
        username.sendKeys("username");
        WebElement password = driver.findElement(By.id("password"));
        Thread.sleep(2000);
        password.sendKeys("password");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String exptectedAlert ="validation failed";
        Assert.assertEquals(alert.getText(), exptectedAlert);
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
        String exptectedLink ="https://webdriveruniversity.com/";
        Assert.assertEquals(driver.getCurrentUrl(), exptectedLink);




    }

}
