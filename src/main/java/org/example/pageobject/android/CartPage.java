package org.example.pageobject.android;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utis.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage  extends AndroidAction {
    AndroidDriver cartPageDriver;
    public  CartPage(AndroidDriver driver)

    {
        super(driver);
        this.cartPageDriver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    public  List<WebElement> productList;
    //String displySum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    public  WebElement totalAmount;
    //List<WebElement> productCount =   driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    public  WebElement terms;
    /*
    productCount findElements pulural ja akta list tai productList k akta list hisabe deya hoice.
     */
    @AndroidFindBy(id="android:id/button1")
    public  WebElement acceptButton;
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public  WebElement precced;
    @AndroidFindBy(id="android.widget.CheckBox")
    public  WebElement checkBox;


    public  List<WebElement> getProductList(){
        return  productList;
    }


    public double getProductSum(){

      int count = productList.size();
      double totalSum =0;
        for (int i = 0; i < count; i++) {

            String amountString  = productList.get(i).getText();
            Double price = reuseSTringFormate(amountString);
            totalSum = totalSum + price;

        }
        return  totalSum;
    }
    /*
    productList er size ta count er modde rakha hocce.
    for loop er madhome akta strin hisabe amountString er modde rakha hocce.
    amountString k double e convert kora hocce an d samne theke $ bad deya hocce subString er madhome.
     */


    public  Double getTotalAmountDisplay(){

        return  reuseSTringFormate(totalAmount.getText());
    }

 public void acceptTermCondition(){

        longPressAction(terms);
        //reusable method come from AndroidAction for long press
        acceptButton.click();
 }



}
//
// public  Double getFormattedAmount(String amount){
//
// Double price =Double.parseDouble(amount.substring(1));
// return price;
//
// }


// public  void submitOder(){
//  checkBox.click();
//  precced.click();
//
//
// }