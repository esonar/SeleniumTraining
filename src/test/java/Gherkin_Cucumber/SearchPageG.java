package Gherkin_Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPageG {

    private final WebDriver driver;


    public SearchPageG (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div[1]/input")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/i")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='resultCount']")
    public WebElement resultCount;

    @FindBy(css = ".image-overlay-header")
    public List<WebElement> telefonItems;

    public void searchTelefon(String product) {
        searchBar.sendKeys(product);
        searchButton.click();
    }

}
