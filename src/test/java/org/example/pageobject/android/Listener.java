package org.example.pageobject.android;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.example.utis.AppiumUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;

public class Listener extends AppiumUtils implements ITestListener {
    ExtentTest test;
    /*
    Listener class implements ITestListener and take all abastrak method and  use it for report.
    line ta holo ekta notun page ready rakha, jekhane specific test Er sob information ba result likha hobe.
     */
    ExtentReports extent =  ExtentReportNg.getReportobject();
    AppiumDriver driver;



    @Override
    public void onTestStart(ITestResult result) {

         test = extent.createTest(result.getMethod().getMethodName());
    }
/*
Jakhon test shuru hoy, ei method ta call hoy. Ekhane, se test object ta create kore, ja test-er naam ke dhorbe.

 */

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");

    }
    /*
    Jakhon test shafol hoy (pass kore), ei method ta call hoy. Ekhane, test log korche je test passed.

     */

    @Override
    public void onTestFailure(ITestResult result) {
       test.fail(result.getThrowable());

        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            /*
            ITestResult er object deya Test class Er info collect kore,getRealClass deya actual class return kore,getField deya
            driver er sate connect kortese.driver filed Er man return kore.

            get deya test class er akta object return kora hocce.ai object ti driver filed er man return kore.

            finaly (AppiumDriver) e type cast kora hocce.get j driver filed er man decce ta AppiumDriverType.

             */
        } catch (Exception e) {
           e.printStackTrace();
        }

        try {
            test.addScreenCaptureFromPath(getScreenShot(driver,result.getMethod().getMethodName()),result.getMethod().getMethodName());
            /*
            test object deya addScreenCaptureFromPath method call Er madhome screen short add kora hocce sate testCase Er name.
            getScreenShot method come from AppiumUtils.
            getScreenShot duita parameter nay.akta driver r akta testCaseName(String type).
             */
        } catch (IOException e) {
           e.printStackTrace();
        }


    }
    /*
    Jakhon test fail hoy, ei method ta call hoy. Ekhane, se fail hoyar karon ta log korche.
    line ta sei fail hobar karon ta capture kore rakhe, jeno poroborti te bujha jay test ta keno fail holo. Ei line ta test fail hobar karon ta log kore safe kore rakhe, jeno poroborti te bujhte subidha hoy.




     */




    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);

    }
    /*
    Jodi kono test skip hoye jay, ei method ta call hoy.
     */

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }
    /*
    Kono test fail hoileo, jodi specific ekta percentage successful thake, ei method ta call hoy.
     */

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);

    }
    /*
    Kono test time shesh hoye jodi fail kore, ei method ta call hoy.

     */

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }
    /*
    Jakhon test suite shuru hoy, ei method ta call hoy.
     */

    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }
    /*
    Jakhon test suite shesh hoy, ei method ta call hoy. Ekhane, se report save kore.
    Tahole, extent.flush(); mane holo, je somoy test shesh hoye jay, takhon oi somoy-er test-er sob report gulo ke safe kore rakha.
     */

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
    /*
    Eita check kore je ei listener ta on (enabled) kina.
     */


}
