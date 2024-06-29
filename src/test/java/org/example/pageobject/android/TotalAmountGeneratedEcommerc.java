package org.example.pageobject.android;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalAmountGeneratedEcommerc extends BaseTest{

    @Test
    public  void  totalAmontGenerateCheck() throws InterruptedException {

        //FromPage fromPage = new FromPage(driver);  //this object call BaseTest blew manage
        //ProductCatalog productCatalog1 = new ProductCatalog(driver);

        fromPage.setNameFailed("Alice");
        fromPage.setGender("Female");
        fromPage.setCountrySelection("Argentina");

        ProductCatalog productCatalog = fromPage.submitButton();

        productCatalog.addItemToCartByIndex(0);
        productCatalog.addItemToCartByIndex(0);
        CartPage cartPage =productCatalog.gotToCartPage();

       double totalSum = cartPage.getProductSum();
       double displayeFormatedSum  = cartPage.getTotalAmountDisplay();
       Assert.assertEquals(totalSum,displayeFormatedSum);
       cartPage.acceptTermCondition();
      // cartPage.submitOder();

        Thread.sleep(3000);
    }

}


//WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
