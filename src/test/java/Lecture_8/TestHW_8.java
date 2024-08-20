package Lecture_8;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHW_8 {

    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String expectedURL= "https://practicetestautomation.com/logged-in-successfully/";
        String outcomeURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,outcomeURL);
    }

    @Test
    public void invalidUsername() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("invalid username");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue("Error message is not displayed.", errorMessage.isDisplayed());
        String expectedError= "Your username is invalid!";
        Assert.assertEquals(expectedError,errorMessage.getText());

    }

    @Test
    public void invalidPassword() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("invalidpassword");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue("Error message is not displayed.", errorMessage.isDisplayed());
        String expectedError= "Your password is invalid!";
        Assert.assertEquals(expectedError,errorMessage.getText());

    }

    @Test
    public void pageTitleLogin() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        String expectedTitle = "Test Login | Practice Test Automation";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @Test
    public void titleAfterLogIn() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @Test
    public void successfulLogOut(){
        driver.navigate().to("https://practicetestautomation.com/logged-in-successfully/");
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
        logoutButton.click();
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(expectedURL,driver.getCurrentUrl());
    }


    @After
    public void closeWebsite() {
        driver.quit();
    }
}
