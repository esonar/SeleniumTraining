package Gherkin_Cucumber.StepDefinitions;

import Gherkin_Cucumber.ConfigReader;
import Gherkin_Cucumber.Driver;
import Gherkin_Cucumber.LoginPageG;
import Gherkin_Cucumber.SearchPageG;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchTelefon {

    WebDriver driver = Driver.getDriver();
    LoginPageG loginpage = new LoginPageG(driver);
    SearchPageG searchPage = new SearchPageG(driver);

    @Given("user is logged in")
    public void userIsOnTheLoginPage() throws InterruptedException {
        driver.get(ConfigReader.getProperty("loginPageUrl"));
        Thread.sleep(2000);
        loginpage.enterUsername(ConfigReader.getProperty("validUsername"));
        Thread.sleep(2000);
        loginpage.enterPassword(ConfigReader.getProperty("validPassword"));
        Thread.sleep(2000);
        loginpage.clickLogin();
    }

    @When("user searches for \"Telefon\" item")
    public void userSearchesforTelefon() throws InterruptedException {
        Thread.sleep(5000);
        searchPage.searchTelefon("Telefon");
    }

    @Then("user should see a list of \"Telefon\" items")
    public void userIsOnTheSearchPage() throws InterruptedException {
        Thread.sleep(2000);
        String expectedLink = "https://www.trendyol.com/sr?q=Telefon&qt=Telefon&st=Telefon&os=1";
        Assert.assertEquals(expectedLink, driver.getCurrentUrl());
    }


    @Given("user has searched for \"Telefon\"")
    public void userOnTheSearchPageStart() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.trendyol.com/sr?q=Telefon&qt=Telefon&st=Telefon&os=1");
    }

    @Then("user should see a total count of the \"Telefon\" items")
    public void totalCountTelefon() throws InterruptedException {
            Thread.sleep(2000);
            Assert.assertTrue(!searchPage.telefonItems.isEmpty());
    }

}
