package org.example.pageobject.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utis.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FromPage extends AndroidAction {

    AndroidDriver fromPageDriver;


    public  FromPage(AndroidDriver driver)

    {
        super(driver);
   this.fromPageDriver =driver;
   PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }


/*
FromPage er constroctor er modde AndroidDriver k pass kore TatalAmountGenerateEcommerc class From page Er akta object banano hoice.
Android driver k call korar por ta oi scope er modde sudhu call kora jay tai globally call korar jonno akta variable declar deya hoice driver.
this deya variable fromPageDriver mane ai class er ai field k bujayci r driver k store kora hoice.

PageFactory.initElements deya page er sob webElement gula k khuje ber kore and tader k babohar korar jonno ready kore.
AppiumFieldDecorator akta desing patarn ja appium er madhome driver k babohar kore.

this deya bujano hocce PageFactory.initElements kai class er element gula inshilize koror.

 */




    //  driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Emma khan");
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameFiled;

    public  void setNameFailed(String name){
        nameFiled.sendKeys(name);
        fromPageDriver.hideKeyboard();
    }

//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private  WebElement femaleOption;
    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private  WebElement maleOption;


    public  void setGender(String gender){

        if(gender.contains("Female"))
            femaleOption.click();
            else
                maleOption.click();


    }

    /*
    radio button two option male and female.if condition deya duitai handle kora hoce.
    jodi gender contains female tahole female e click korbe r na hole male e click korbe.


     */

    @AndroidFindBy(id="android:id/text1")
    private WebElement countryList;

    public  void setCountrySelection(String countryName){
        countryList.click();
        scrollToText(countryName);
        //reuable method for scrolling
        fromPageDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
/*
first click kortese country list er upo tar por scroll kortese.country name alada alada hote pare tai dynamicly deya hoice jano
country name jay hok na kno problem ba error na hoy.

 */




    // driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    @AndroidFindBy(id= "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    public  ProductCatalog submitButton() throws InterruptedException {

        shopButton.click();
        Thread.sleep(2000);
        return new ProductCatalog(fromPageDriver);
    }

    /*
    shpeButton e click deya por onno page ejay.oi page er element gula onno class er madhome handle kora hocce tai oi
    class er object jano toiri na kore method er madhome banano hoce.
    shopeButton e click deyar por ProductCatalog class theke baki elemet gula jano call kora jay tai ProductCatalog er akta object banano hocce.
    submitButton method retun kore ProductCatalog type.


     */

}
