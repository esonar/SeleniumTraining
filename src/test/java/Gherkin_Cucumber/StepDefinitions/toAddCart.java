package Gherkin_Cucumber.StepDefinitions;

import Gherkin_Cucumber.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class toAddCart {

    WebDriver driver = Driver.getDriver();
    LoginPageG loginpage = new LoginPageG(driver);
    ToAddToCartG addToCartG = new ToAddToCartG(driver);

    @Given("user is viewing the search results for \"Telefon\"")
    public void user_is_viewing_the_search_results_for() throws InterruptedException {
        driver.get(ConfigReader.getProperty("loginPageUrl"));
        Thread.sleep(2000);
        loginpage.enterUsername(ConfigReader.getProperty("validUsername"));
        Thread.sleep(2000);
        loginpage.enterPassword(ConfigReader.getProperty("validPassword"));
        Thread.sleep(2000);
        loginpage.clickLogin();
        Thread.sleep(2000);
        driver.get("https://www.trendyol.com/sr?q=Telefon&qt=Telefon&st=Telefon&os=1");

    }
    @When("user adds one \"Telefon\" item to the cart")
    public void user_adds_one_item_to_the_cart() throws InterruptedException {
        Thread.sleep(8000);
        addToCartG.addProductToCart();
    }
    @Then("user should see that the item is added to the cart")
    public void user_should_see_that_the_item_is_added_to_the_cart() {
        addToCartG.isItemInCart();

    }
    @Then("user should see the correct number of items (1) in the cart")
    public void user_should_see_correct_number_of_items_in_the_cart() throws InterruptedException {
        Assert.assertEquals("1", addToCartG.isItemInCart());
    }

}

