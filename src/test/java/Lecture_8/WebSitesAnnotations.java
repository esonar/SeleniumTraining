package Lecture_8;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSitesAnnotations {

    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Before
    public void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    @Test (timeout = 500)
    public void GooglePage() {

        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void LinkedinPage() {
        driver.navigate().to("https://linkedin.com");
    }


    @Ignore // bunu yapma

    public static void tearDown() {
        driver.quit();
    }


//@RepeatedTest(5) --> aynı testi 5 defa tekrar etme annotation


    /*public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.get("w")

    }*/
}
