package TrendyolHomework_16;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
   private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"search-app\"]/div/div/div/div[2]/div[4]/div[1]/div/div[2]/div[1]/a/div[1]/div[2]/div[2]")
    public WebElement firstProduct;

    @FindBy(xpath = "//div[@class='sp-itm' and @title='Beden seçmek için tıklayınız' and text()='XL']")
    public WebElement sizeOfProduct;

    @FindBy(xpath = "//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[5]/button/div[1]" )
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"account-navigation-container\"]/div/div[2]/div" )
    public WebElement popupCart;

    public void addProductToCart() throws InterruptedException {
        firstProduct.click();
        Thread.sleep(8000);
        sizeOfProduct.click();
        Thread.sleep(2000);
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public boolean isItemInCart() {
        return popupCart.isDisplayed();
    }
}
