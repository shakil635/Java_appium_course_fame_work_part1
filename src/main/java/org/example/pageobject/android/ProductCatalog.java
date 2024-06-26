package org.example.pageobject.android;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utis.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog  extends AndroidAction {

    AndroidDriver ProductCatalogDriver;


    public  ProductCatalog(AndroidDriver driver)

    {
        super(driver);
        this.ProductCatalogDriver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    //     driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    public  void addItemToCartByIndex(int index){
       addToCart.get(index).click();

    }

    // driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public  CartPage gotToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(ProductCatalogDriver);

    }



}
