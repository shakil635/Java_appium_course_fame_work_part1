package org.example.utis;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IosAction {

    IOSDriver iosActionDriver;
    public  IosAction(IOSDriver driver ){
        this.iosActionDriver=driver;

    }
    public  void longPressIos(WebElement element){

        Map<String, Object> params = new HashMap<>();

        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",5);
        iosActionDriver.executeScript("mobile:touchAndHold", params);
    }





    public  void  scrollIos(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)element).getId());

        iosActionDriver.executeScript("mobile:scroll",params);
    }




}
