package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    private By signIn =By.id("myAccount");
    private By login =By.id("login");
    private By verifyLogin = By.xpath("//span[text()='Hesabım']");
    private By Friedrich = By.xpath("//input[@class='desktopOldAutosuggestTheme-input']");
    private By searchFriedrich = By.xpath("//div[contains(text(),'ARA')]");

    public void clickmyAccount(){
        driver.findElement(signIn).click();
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }

    public void veriyfyLoginHomePage(){
        Assert.assertEquals("Hesabım",driver.findElement(verifyLogin).getText());
    }

    public void writeFriedrich(){
        driver.findElement(Friedrich).sendKeys("Friedrich Nietzsche");
    }
    public void searchButtonClick(){
        driver.findElement(searchFriedrich).click();

    }

}
