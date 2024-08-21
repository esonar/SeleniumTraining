package Gherkin_Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageG {


    private final WebDriver driver;

    public LoginPageG(WebDriver driver) {
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

    public void enterUsername (String validUsername) {
        usernameField.sendKeys(validUsername);
    }


    public void enterPassword(String validPassword) {
        passwordField.sendKeys(validPassword);
    }

    public void clickLogin () {
        loginButton.click();
    }


}
