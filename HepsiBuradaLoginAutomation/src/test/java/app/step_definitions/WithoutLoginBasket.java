package app.step_definitions;

import app.pages.BasketPage;
import app.pages.BooksPage;
import app.pages.HomePage;
import app.utilities.BrowserUtils;
import app.utilities.ConfigurationReader;
import app.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WithoutLoginBasket {
    private WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    BrowserUtils utils = new BrowserUtils();
    BooksPage booksPage = new BooksPage();
    BasketPage basketpage = new BasketPage();

    @Given("The user go to homepage")
    public void the_user_go_to_homepage() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("User choice products.")
    public void user_choice_products() {
        homePage.writeFriedrich();
        utils.waitFor(10);
        homePage.searchButtonClick();
    }

    @Then("products from two different vendors are selected and added to the cart.")
    public void products_from_two_different_vendors_are_selected_and_added_to_the_cart() {
        utils.PageScrolldown();
        booksPage.NietzscheBookClick();
        booksPage.add_basket();
        utils.waitFor(10);
        booksPage.back_to_books();
        utils.waitFor(10);
        utils.PageScrolldown();
        utils.waitFor(10);
        booksPage.add_second_book();
        utils.waitFor(10);
        booksPage.add_my_basket();
        utils.waitFor(10);
    }

    @Then("Verify my basket")
    public void verify_my_basket() {
        basketpage.checkBookName();
    }
}
