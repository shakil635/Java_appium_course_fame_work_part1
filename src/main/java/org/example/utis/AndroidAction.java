package org.example.utis;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidAction {

    AndroidDriver androidActionDriver;
    public  AndroidAction(AndroidDriver driver ){
        this.androidActionDriver=driver;

    }


    public  void longPressAction(WebElement webElement){

        ((JavascriptExecutor) androidActionDriver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)webElement).getId(),"duration",2000
                ));

    }


    public  void scrolloToAction(){

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidActionDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));

        }while (canScrollMore);
    }

    public  void scrollToText(String text){

        androidActionDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }





    public  void swipeToAction(WebElement element, String str){


        ((JavascriptExecutor) androidActionDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", str,
                "percent", 0.50
        ));

    }


    public  Double reuseSTringFormate(String str){
        double amount =   Double.parseDouble(str.substring(1));
        return  amount;

    }



}
