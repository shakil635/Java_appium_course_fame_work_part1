package org.example.pageobject.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.example.utis.AndroidAction;
import org.example.utis.AppiumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;


public class BaseTest extends AppiumUtils {

//BaseTest extends AppiumUtils for pass method getJsonData in grandson DataProviderTestSameDataDiffirentTest like:AppiumUtils -> BaseTest -> DataProviderTestSameDataDiffirentTest

   public   AndroidDriver driver;
   public   AppiumDriverLocalService service;
    FromPage fromPage;
   public AndroidAction androidDriver;



    @BeforeClass (alwaysRun = true)
    public  void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                //Appium code --> Appium server --> mobile.
                .withAppiumJS(new File("C://Users//hp//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
    }
public void driverStart()throws MalformedURLException, URISyntaxException{

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 2 API 34");
            //options.setDeviceName("Pixel 3a API 34");
            // options.setDeviceName("vivo Y12A");

            options.setApp("D://java//javafameworkpart//src//test//java//resources//General-Store.apk");
            //options.setApp("D://java//javafameworkpart//src//test//java//resources//ApiDemos-debug.apk");
            //options.setChromedriverExecutable("D://transfer//chromedriver_win32//chromedriver.exe");


            //driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); support java 20. after 20 it deprecate

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

             androidDriver = new AndroidAction(driver);
            fromPage = new FromPage(driver);


    }






    @AfterClass (alwaysRun = true)
    public  void tearDown()
    {


     //  driver.quit();
        service.stop();
        System.out.println("AfterClass");
    }



}



