package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    JavascriptExecutor js; // menambahkan atribut dari kelas JavascriptExecutor untuk scroll
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver; // casting dari WebDriver menjadi JavascriptExecutor
    }

    // Locator @FindBy
    @FindBy(xpath = "//a[normalize-space()='Dismiss']") // locator dismiss
    WebElement closeDismiss;
    @FindBy(xpath = "//a[normalize-space()='My Account']") // locator button my account
    WebElement btnMyAccount;
    @FindBy(id = "username") // locator field username
    WebElement username;
    @FindBy(id = "password") // locator field password
    WebElement password;
    @FindBy(name = "login") // locator button login
    WebElement btnLogin;
    @FindBy(className = "woocommerce-MyAccount-content") // locator text Login success
    WebElement textLoginSuccess;

    // Custom Method
    public void login(String username, String password){
        closeDismiss.click(); // click dismiss
        btnMyAccount.click(); // click button my account
        js.executeScript("window.scrollBy(0,500)"); // scroll ke bawah
        this.username.sendKeys(username); // input ke dalam field username
        this.password.sendKeys(password); // input ke dalam field password
        btnLogin.click(); // click button login
        js.executeScript("window.scrollBy(0,500)"); // scroll ke bawah
    }
    public  String getTextLoginSuccess(){
        return textLoginSuccess.getText();
    }



}
