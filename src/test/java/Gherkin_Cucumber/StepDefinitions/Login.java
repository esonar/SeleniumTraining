package Gherkin_Cucumber.StepDefinitions;

import Gherkin_Cucumber.ConfigReader;
import Gherkin_Cucumber.Driver;
import Gherkin_Cucumber.LoginPageG;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

    WebDriver driver = Driver.getDriver();
    LoginPageG loginpage = new LoginPageG(driver);


    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get(ConfigReader.getProperty("loginPageUrl"));
    }

    @When("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() throws InterruptedException {
        Thread.sleep(2000);
        loginpage.enterUsername(ConfigReader.getProperty("validUsername"));
        Thread.sleep(2000);
        loginpage.enterPassword(ConfigReader.getProperty("validPassword"));
        Thread.sleep(2000);
        loginpage.clickLogin();
    }

    @Then("user should see the homepage")
    public void userShouldSeeTheHomepage() throws InterruptedException {
        Thread.sleep(2000);
        String expectedLink = "https://www.trendyol.com/";
        Assert.assertEquals(expectedLink, driver.getCurrentUrl());
    }



    @When("user enters invalid username and valid password")
    public void userEntersInvalidUsernameAndValidPassword() throws InterruptedException {
        Thread.sleep(2000);
        loginpage.enterUsername(ConfigReader.getProperty("invalidUsername"));
        Thread.sleep(2000);
        loginpage.enterPassword(ConfigReader.getProperty("validPassword"));
        loginpage.clickLogin();
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());
        String expectedError= "Lütfen geçerli bir e-posta adresi giriniz.";
        Assert.assertEquals(expectedError,loginpage.errorMessage.getText());
        Thread.sleep(2000);
    }


}
