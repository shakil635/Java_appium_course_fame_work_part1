package org.example.utis;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;

public class AndroidAction  extends  AppiumUtils{

  public   AndroidDriver driver;
    public  AndroidAction(AndroidDriver driver ){
       // super(driver); //parent class AppiumUtils theke arse
        this.driver=driver;

    }


    public  void longPressAction(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)webElement).getId(),"duration",2000
                ));

    }


    public  void scrolloToAction(){

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));

        }while (canScrollMore);
    }

    public  void scrollToText(String text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }





    public  void swipeToAction(WebElement element, String str){


        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", str,
                "percent", 0.50
        ));

    }


}
