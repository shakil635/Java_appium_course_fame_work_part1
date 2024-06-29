package org.example.utis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


/*
AppiumUtils class Er modde oi sokal method gula rakha hoice j gula ios and android both platfrom e babohar kora jay.

AndroidDriver / Iosdriver duitar kaj akta t hobe AppiunDriver deya.
AppiumUtils class k IosAction and AndroidAction both class extends kore supper key madhome parent class er Appium driver k acces kortese.



 */
public class AppiumUtils {

//    AppiumDriver utilsDriver;
//
//    public  AppiumUtils(AppiumDriver driver){
//        this.utilsDriver =driver;
//
//
//    }


    public Double reuseSTringFormate(String str) {
        double amount = Double.parseDouble(str.substring(1));
        return amount;

    }


    public void waitForElementsToAppears(WebElement element, AppiumDriver utilsDriver) {
        WebDriverWait wait = new WebDriverWait(utilsDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element), "text", "Cart"));

    }


    ///System.getProperty("user.dir")+ "D://java//javafameworkpart//src//test//java//testData//en.json")
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();

        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
    /*
    getJsonData parameter hisabe akta String pass kora hocce, return type list,List er modde akta HashMap thakbe jar key and value both String.

   jsonFilePath : address of en.json file j file ta amra porte chaitesi
   FileUtils.readFileToString: ai method deya amra en.json file porar chesta (prokriya)kortesi.
  objectMapper deya amra en.json file ta portesi.

  objectMapper.readValue deya jsonContent /en.json k portesi and oi json file theke prottekta onshow k soto HashMap kore list er modde raktesi.
  ai HashMap er list ta k data modde store kortesi and lastly aita return kortesi.


     */





}

//WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));