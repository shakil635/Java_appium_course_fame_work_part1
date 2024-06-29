package org.example.pageobject.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

public class DataProviderTestSameDataDiffirentTest extends BaseTest {

    @Test(dataProvider = "getData")
    /*
    dataProvider akti default abastrak method.@DataProvider er method er name getData k bole deya hoice.
    dataProviderTest method er modde parameter gula pass kora hoice.
    first create  @DataProvider  method.
    pass it @Test  dataProvider default method take a string  @DataProvider method name pass  as string
    and lastly Test method er modde bole sete hobe parameter gula.
     */
    public void dataProviderTest(HashMap<String,String> input) throws InterruptedException {

        //FromPage fromPage = new FromPage(driver);  //this object call BaseTest blew manage
        //ProductCatalog productCatalog1 = new ProductCatalog(driver);

        fromPage.setNameFailed(input.get("name"));
        fromPage.setGender(input.get("gender"));
        fromPage.setCountrySelection(input.get("country"));

        ProductCatalog productCatalog = fromPage.submitButton();

        productCatalog.addItemToCartByIndex(0);
        productCatalog.addItemToCartByIndex(0);
        CartPage cartPage = productCatalog.gotToCartPage();

        double totalSum = cartPage.getProductSum();
        double displayeFormatedSum = cartPage.getTotalAmountDisplay();
        Assert.assertEquals(totalSum, displayeFormatedSum);
        cartPage.acceptTermCondition();
        Thread.sleep(3000);
    }



    @BeforeMethod
    public  void preSetup(){

        try {
            driverStart();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }



/*
    @DataProvider
    public  Object [][] getData() throws IOException {

        return  new Object [][] {{"Alice","Female","India"},{"Bod","male","Bangladesh"}};
    }

    without json also work it. but if you want to add json not change code change only jons file you can do blew system.
 */


    @DataProvider
    public  Object [][] getData() throws IOException {

      List<HashMap<String,String>> data= getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//en.json");
        System.out.println(data + ">>>>>>>>>>>>>>>>>");
        //[{country=India, gender=Female, name=Alice}, {country=Chad, gender=male, name=Bod}]
         return new Object [][] {{data.get(0)},{data.get(1)}};
    }

/*


DataProvider deya data send er madhome akoi test  multiple data deya test kora jay.
jamon name,gender and country multiple vabe set kore test korte pari.
first create @DataProvider method
pass it @Test.
and test method pass parametar
getData method return multidumontion array. multidumontion array pass diffirent valu for multiple test.

multidumontion array er modde ami joto gula array rakbo toto bar test test run hobe jodi dui ta thake tahole dui bar jodi 3ta thake tahole 3bar

AppiumUtils -> BaseTest -> DataProviderTestSameDataDiffirentTest getJsonData k call kora hoice.en.json file er path ta dekha deya hoice.

D:\java\javafameworkpart\ + src\test\java\testData\en.json
code bivinno matching e run korle path gula diffirent hobe error asbe tai System.getProperty method deya first part tuku dynamicly generate kortese jano onno matching o tar path ta nite pare.
second part tuku sobsumoy akoi thakbe tai first part tuku daynamic vabe generate kora hocce tar sate second part tuku concatenation kore deya hocce.



 */

    @AfterMethod
    public  void afterMethoid(){
        driver.quit();
    }

}


//WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
