package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
    private WebDriver driver;

    public BooksPage() {
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    private By NietzscheBook =By.xpath("//a[@data-sku='KISBANK03535']");
    private By add_to_basket =By.id("addToCart");
    private By back_to_page = By.xpath("//a[contains(@class, 'checkoutui-Modal-2iZXl')]");
    private By add_to_different_seller = By.xpath("(//button[@class='add-to-basket button small'])[1]");
    private By basket = By.xpath("//button[text()='Sepete git']");


    public void NietzscheBookClick(){
        driver.findElement(NietzscheBook).click();
    }

    public void add_basket(){
        driver.findElement(add_to_basket).click();
    }

    public void back_to_books(){
        driver.findElement(back_to_page).click();
    }

    public void add_second_book(){
        driver.findElement(add_to_different_seller).click();
    }
    public void add_my_basket(){
        driver.findElement(basket).click();
    }
}
