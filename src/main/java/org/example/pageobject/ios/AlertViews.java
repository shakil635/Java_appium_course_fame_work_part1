package org.example.pageobject.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.utis.IosAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViews extends IosAction {


    IOSDriver alertViewsDriver;


    public AlertViews(IOSDriver driver)

    {
        super(driver);
        this.alertViewsDriver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }




    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label=='Text Entry'`]")
    private WebElement textEntryMenu;


    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confiromMenuItem;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;


    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptpopUp;



    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;


    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Confirm']")
    private WebElement submit;

  public  void fillTextLbel(String txt){
  textEntryMenu.click();
  textBox.sendKeys(txt);
  acceptpopUp.click();

  }


  public  String getConfirmMessage(){

      confiromMenuItem.click();
    return   confirmMessage.getText();

  }
  public  void clickConfrom(){
      submit.click();
  }




}
