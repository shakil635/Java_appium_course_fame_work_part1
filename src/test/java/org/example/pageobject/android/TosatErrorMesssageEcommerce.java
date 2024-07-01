package org.example.pageobject.android;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TosatErrorMesssageEcommerce extends BaseTest{

    @Test
    public  void  totastErrorMessageMethode() throws InterruptedException {

        //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Emma khan");
       // driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    // String toast =  driver.findElement(AppiumBy.xpath("(//android.widget.Toast[1])")).getAttribute("Text");

         String toast =  driver.findElement(AppiumBy.xpath("//android.widget.Toast[@text='Please enter your name']")).getAttribute("Text");

        Assert.assertEquals(toast, "Please your name");
        Thread.sleep(3000);
    }

    @BeforeMethod()
    public  void preSetup(){

        try {
            driverStart();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }


    @AfterMethod()
    public  void afterMethoid(){
        driver.quit();
    }

}
