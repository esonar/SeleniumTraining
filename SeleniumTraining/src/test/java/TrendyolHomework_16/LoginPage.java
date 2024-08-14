package TrendyolHomework_16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-email")
    public WebElement usernameField;

    @FindBy(id = "login-password-input")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-register\"]/div[3]/div[1]/form/button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"error-box-wrapper\"]/span[2]")
    public WebElement errorMessage;

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }




}



