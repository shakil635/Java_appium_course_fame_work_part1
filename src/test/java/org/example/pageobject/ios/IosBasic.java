package org.example.pageobject.ios;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IosBasic extends IosBaseTest {

    @Test
    public  void iosBaseTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        AlertViews alertViews = homePage.selectAlertView();
        alertViews.fillTextLbel("Hello");
        String actualMessage = alertViews.getConfirmMessage();
        Assert.assertEquals(actualMessage , "A message should be a short, complete sentence.");
        alertViews.clickConfrom();

    }


}
