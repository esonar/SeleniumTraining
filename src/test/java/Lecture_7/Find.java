package Lecture_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class Find {

    /*

    *xpath*
    //tagName[contains(@attributeName,'attributeValue')] attributeValue'yu içeren attributename'i bul
    //tagName[starts-with(@attributeName,'attributeValue')] attributeValue ila başlayan (
        örn: //button[starts-with(@id,'u_0_5')] --> facebook örneği; id attribute, button ise tag
    //tagName[contains(text(),'StringText')] --> websitede yazan herhangi bir texte ulaşma (using text)
    //tagName --> value'ları verir (using index)
    (//tagName)[1] --> 1. indexteki değeri  (using index)
    //div[@data-test='inventory-item'[1]] attribute'ta birden fazla element var bu şekilde, ilkini bulmak için
    //div[@data-test='inventory-item'[1]] / div... slash kullanıldığında ilk kullanılan kısmın aşağısından bir şeyler aratılabilir
    //button[@name='login']

    *css selector*

    div.inventory_list --> tag: div, class ise nokta kullanılır, id ise diyez
    div[class='inventory_list'] --> diğer bir yazımı
    .inventory_List --> diğer bir yazımı
    div#inventory_container --> id ile aratmak için
    div[data-test='inventory-item'] --> data test attribute'u bulmak için
    div.inventory_list>div.nth-child(6) TAGİSMİ --> aradaki boşluk bir alt sınıfı temsil eder
    starts with: TAG[attributeName^='buraya string'i yaz']
    ends with: TAG[attributeName$='buraya string'i yaz']
    contains text: TAG[attributeName*='buraya string'i yaz']
    locating siblings: TAG[attributeName='buraya string'i yaz'] + TAG


     */
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /*
        driver.get("https://money.rediff.com/index.html");
        driver.manage().window().maximize();
        List<WebElement> trial = driver.findElements(By.xpath("//ul[contains(@class, 'ul_top_tabs')]//a[contains(@onclick, 'topbar_logurl')]"));
        for (int i = 0; i < trial.size(); i++) {
            System.out.println(trial.get(i).getText());
        }
        System.out.println(trial.size());

        */

    }


}
