package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductToCartPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        LoginPage loginPage = new LoginPage();
        System.out.println("Test Login Success");
        loginPage.login(); // menjalankan method login dari kelas loginPage

        AddProductToCartPage addProductToCart = new AddProductToCartPage();
        System.out.println("Test Add Product To Cart Success");
        addProductToCart.addToCartProduct(); // menjalankan method addProductToCart dari kelas AddProductToCart

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
