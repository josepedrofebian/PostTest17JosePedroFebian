package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        String path = "C:\\MyTools\\geckodriver.exe";
        String webDriver = "webdriver.gecko.driver";
        System.setProperty(webDriver, path);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
