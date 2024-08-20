package Lecture_345;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Checkbox {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();
        String baseURL = "https://demo.guru99.com/test/radio.html";
        driver.get(baseURL);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement checkBox1 = driver.findElement(By.cssSelector("#vfb-6-0"));
        checkBox1.click();
        System.out.println("CheckBox1 görünür durumdadır: " + checkBox1.isDisplayed());
        System.out.println("CheckBox1 enable durumdadır: " + checkBox1.isEnabled());
        System.out.println("ChechBox1 seçilidir: " + checkBox1.isSelected());

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        WebElement radioButton1 = driver.findElement(By.cssSelector("#vfb-7-2"));
        radioButton1.sendKeys(Keys.SPACE); // Space'e basarak da oluyor, click'in yanı sıra




    }
}
