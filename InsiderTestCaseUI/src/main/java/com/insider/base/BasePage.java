package com.insider.base;

import com.insider.core.*;
import org.apache.log4j.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static com.insider.util.Utility.*;

public class BasePage extends DriverManager {

    public static Logger log = Logger.getLogger("InsiderlTestCase");

    @Parameters({"browser"})
    @BeforeTest()
    public void initialize(@Optional String browser) {
        PropertyConfigurator.configure("log4j.properties");
        PropertiesFile.readProperties();
        DriverManager.setUpDriver(PropertiesFile.browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus())
        {
            takeScreenShot(driver,result.getName());
        }

        log.info("*** Browser kapatildi. ***");
        DriverManager.quitDriver();
    }
}
