package app.step_definitions;

import app.pages.BasketPage;
import app.pages.BooksPage;
import app.pages.HomePage;
import app.pages.LoginPage;
import app.utilities.BrowserUtils;
import app.utilities.ConfigurationReader;
import app.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginBasket {
    private WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    BrowserUtils utils = new BrowserUtils();
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();
    BasketPage basketpage = new BasketPage();

    @Given("The user visits Hepsiburada.com")
    public void theUserVisitsHepsiburadaCom() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("User login")
    public void userLogin() {
        homePage.clickmyAccount();
        homePage.clickLogin();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickButtonGoHomePage();

    }

    @And("After the redirect, the user login is verified on the homepage")
    public void afterTheRedirectTheUserLoginIsVerifiedOnTheHomepage() {
        homePage.veriyfyLoginHomePage();
        utils.waitFor(10);

    }

    @And("The user will search for the product he wants to buy here.")
    public void theUserWillSearchForTheProductHeWantsToBuyHere() {
        utils.waitFor(10);
        homePage.writeFriedrich();
        utils.waitFor(10);
        homePage.searchButtonClick();

    }

    @And("The user can choose from the list of products displayed as a result of the Search select products.")
    public void theUserCanChooseFromTheListOfProductsDisplayedAsAResultOfTheSearchSelectProducts() {
        utils.PageScrolldown();
        booksPage.NietzscheBookClick();
    }

    @And("For the selected product, products from two different vendors are selected and added to the cart.")
    public void forTheSelectedProductProductsFromTwoDifferentVendorsAreSelectedAndAddedToTheCart() {
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

    @Then("Verify on the My Cart page that the selected product has been added correctly")
    public void verifyOnTheMyCartPageThatTheSelectedProductHasBeenAddedCorrectly() {
        basketpage.checkBookName();
    }
}
