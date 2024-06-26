package org.example.pageobject.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utis.IosAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IosAction {


    IOSDriver homePageDriver;


    public  HomePage(IOSDriver driver)

    {
        super(driver);
        this.homePageDriver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


    //driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name='Alert Views']")
    private WebElement alertView;

    public AlertViews selectAlertView(){
        alertView.click();
        return new AlertViews(homePageDriver);
    }

}
