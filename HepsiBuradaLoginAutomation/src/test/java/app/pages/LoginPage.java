package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver= Driver.getDriver();

    }

    private By email =By.id("txtUserName");
    private By password =By.id("txtPassword");
    private By clickLoginButton =By.id("btnLogin");

    public void enterEmail(){
        driver.findElement(email).sendKeys("kadir_atalii@hotmail.com");
    }

    public void enterPassword(){
        driver.findElement(password).sendKeys("Kadir5159.");
    }

    public void clickButtonGoHomePage(){
        driver.findElement(clickLoginButton).click();
    }

}
