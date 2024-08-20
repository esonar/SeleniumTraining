package Lecture_345;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Xpath_CssSelector {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();

        Thread.sleep(5000);
        // driver.close(); // o anki driver'ı kapatır

        WebElement form = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span/div/div[1]"));
        form.click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/div")).click();
        Thread.sleep(5000);

        WebElement practice_form_button = driver.findElement(By.xpath("//div[@class='element-list collapse show']"));
        practice_form_button.click();

        Thread.sleep(5000);

        WebElement name_field = driver.findElement(By.cssSelector("#firstName"));
        name_field.sendKeys("Ece");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        email.sendKeys("test@gmail.com");
        email.sendKeys(Keys.PAGE_UP); // en yukarı scroll et
        Thread.sleep(2000);

        //isEnabled() --> checkbox veya radio button'ının aktif olup olmadığını valide eder
        //isDisplayed() --> checkbox veya radio button görünür mü değil mi
        //isSelected() --> checkbox'In veya radio button'ın checked olduktan sonraki validasyonu


        driver.quit(); //driver'ı kapatır


    }
}
