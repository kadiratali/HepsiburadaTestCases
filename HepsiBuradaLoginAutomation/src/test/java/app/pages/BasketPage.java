package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasketPage {
    private WebDriver driver;

    public BasketPage() {
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    private By book_name = By.xpath("(//a[text()='Böyle Söyledi Zerdüşt (Ciltsiz) - Friedrich Wilhelm Nietzsche'])[1]");
    private By second_book_name = By.xpath("(//a[text()='Böyle Söyledi Zerdüşt (Ciltsiz) - Friedrich Wilhelm Nietzsche'])[2]");

    public void checkBookName(){
        Assert.assertEquals(driver.findElement(book_name).getText(),driver.findElement(second_book_name).getText());
    }
}
