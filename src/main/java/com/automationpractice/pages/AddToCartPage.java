package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumImplementation.SeleniumImplementation;

public class AddToCartPage {
    @FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
    WebElement itemImage;

    @FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]")
    WebElement btnMore;

    @FindBy(xpath="//*[@id=\"quantity_wanted\"]")
    WebElement txtQuantity;

    //@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[1]/div/div/select")
    @FindBy(xpath="//*[@id=\"group_1\"]")
    WebElement selectSize;

    @FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
    WebElement btnAddToCart;

    //@FindBy(css="div#layer cart a > span")
    //
    //@FindBy(xpath="*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    @FindBy(css="div#layer_cart a > span")
    WebElement btnCheckout;

    @FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
    WebElement cartText;

    SeleniumImplementation seleniumImplementation;

    public AddToCartPage(WebDriver driver){
        //System.out.println("**********************");
        PageFactory.initElements(driver, this);
        seleniumImplementation = new SeleniumImplementation();
    }

    public boolean validateAddToCart(WebDriver driver){
        //System.out.println("********************* ingresar al metodo ********************");
        seleniumImplementation.performMouseHower(itemImage, driver);

        //System.out.println("presionar el boton more");
        seleniumImplementation.click(btnMore);
        //System.out.println("limpiar el texto cantidad");
        seleniumImplementation.clear(txtQuantity);
        //System.out.println("limpiar el texto cantidad");
        seleniumImplementation.setText("3", txtQuantity);
        //System.out.println("seleccionar el tamano");
        seleniumImplementation.selectByVisibleText(selectSize, "M");
        //System.out.println("click adicionar al carrito");
        seleniumImplementation.click(btnAddToCart);
        //System.out.println("click ejecutar el boton");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seleniumImplementation.clickUsingJavaScriptExecutor(btnCheckout, driver);
        seleniumImplementation.refresh(driver);
        //seleniumImplementation.validateText(driver, cartText, "3");

        //System.out.println("********************* finalizar el metodo ********************");

        return seleniumImplementation.validateText(driver, cartText, "3");
    }

}
