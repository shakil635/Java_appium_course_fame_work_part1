package org.example.pageobject.android;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportNg {

    static ExtentReports extentReports;
    @Test
    public static ExtentReports getReportobject(){

        String path =   System.getProperty("user.dir")+"//reportes//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Result");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "sk635@");
        return extentReports;
    }



}
/*
getReportobject akta static method banano hoice object sara jano method ta k call kora jay.

ExtentReports Selenium, Appium, TestNG, JUnit ect fame work Er sate  intigation korte pare.
html report, screenshort er moto subidha pao jay.

System.getProperty deya derictory te reportes name akta folde banano hocce.
reports folder Er modde index.html file banano hoce.

reporter.config().setReportName(),reporter.config().setDocumentTitle(); report er name r report er title add kora hocce.

ExtentReports Er object Er sate ak ba akadhik report sonjuktto korte baboriyto hoy.
extentReports.setSystemInfo deya tester er info add kora hoy


 */