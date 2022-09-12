package com.insider.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static com.insider.base.BasePage.*;

import java.time.Duration;

public class DriverManager {

    public static WebDriver driver = null;

    public static void setUpDriver(String browserType){
        switch (browserType){
            case "chrome":
                log.info("*** Launching Chrome Browser ***");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                log.info("*** Launching Firefix Browser ****");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                log.info("*** Launching IE Browser ***");
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesFile.defaultTimeout));
    }

    public static void quitDriver(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
}
