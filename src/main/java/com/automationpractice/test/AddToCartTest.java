package com.automationpractice.test;


import com.automationpractice.pages.AddToCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest {

    WebDriver driver;

    AddToCartPage page;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        page = new AddToCartPage(driver);

    }

    @Test
    public void validateAddoCart(){
        Assert.assertTrue(page.validateAddToCart(driver));
    }

}
