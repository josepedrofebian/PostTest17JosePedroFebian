package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductToCartPage {
    private WebDriver driver;
    JavascriptExecutor js; // menambahkan atribut dari kelas JavascriptExecutor untuk scroll
    public AddProductToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver; // casting dari WebDriver menjadi JavascriptExecutor
    }

    @FindBy(className = "cart-button") // locator button cart
    WebElement btnCart;
    @FindBy(xpath = "//a[@class='button wc-backward wp-element-button']") // locator button return shop
    WebElement btnReturnShop;
    @FindBy(className = "noo-product-inner") // locator item produk
    WebElement productItem;
    @FindBy(id = "pa_color") // locator warna item
    WebElement colorItem;
    @FindBy(id = "pa_size") // locator ukuran item
    WebElement sizeItem;
    @FindBy(className = "single_add_to_cart_button") // locator button add to cart
    WebElement btnAddToCart;
    @FindBy(className = "woocommerce-message") // locator message add to cart success
    WebElement messageAddToCartSuccess;
    @FindBy(xpath = "//a[contains(text(),'clear shopping cart')]") // locator button clear shopping cart
    WebElement btnClearShoppingCart;

    public void addToCartProduct(){
//        login.login(); // memanggil method login() pada kelas LoginPage karena depedency
        js.executeScript("window.scrollBy(0,-500)"); // scroll ke atas
        btnCart.click(); // click button cart
        /*
        * Membuat try and catch untuk mengatasi history cart user ketika ada item pada cart
        * */
        try {
            try {
                js.executeScript("window.scrollBy(0,500)");
                btnClearShoppingCart.click();
                js.executeScript("window.scrollBy(0,500)");
            }catch (Exception e){
                System.out.println("button clear shopping cart tidak ditemukan");
            }
        }catch (Exception e){
            System.out.println("Terdapat kesalahan pada scope try");
        }
        btnReturnShop.click(); // click button return shop
        js.executeScript("window.scrollBy(0,500)"); // scroll ke bawah
        productItem.click(); // click item produk
        js.executeScript("window.scrollBy(0,500)"); // scroll ke bawah
        colorItem.sendKeys("Beige"); // memilih warna item
        sizeItem.sendKeys("Large"); // memilih ukuran item
        btnAddToCart.click(); // click button add to cart
        String txtMessageAddToCartSuccess = messageAddToCartSuccess.getText(); // scraping text message add to cart success
        // memanggil method dari kelas DriverSingleton untuk assert
        DriverSingleton.assertEqual(txtMessageAddToCartSuccess,"View cart\n" +
                "“Black Cross Back Maxi Dress” has been added to your cart.");
    }
}
