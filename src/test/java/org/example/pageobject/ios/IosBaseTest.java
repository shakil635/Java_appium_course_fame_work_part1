package org.example.pageobject.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.example.utis.IosAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class IosBaseTest {


    IOSDriver driver;
    AppiumDriverLocalService service;


    @BeforeClass
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                //Appium code --> Appium server --> mobile.
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//index.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4749)
                .build();

        service.start();




        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Plus");
        options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
        //options.setApp("//Users//mobile_2//Downloads//resources//TestApp3.app");
        options.setPlatformVersion("16.4");
        options.setWdaLocalPort(8149);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));




        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); support java 20. after 20 it deprecate

        driver = new IOSDriver(new URI("http://127.0.0.1:4749").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        IosAction iosAction = new IosAction(driver);

    }







    @AfterClass
    public void tearDown() {


        driver.quit();
        service.stop();
        System.out.println("AfterClass");
    }


}


