package com.insider.pages;

import static com.insider.core.PropertiesFile.*;
import static com.insider.core.DriverManager.*;
import static com.insider.base.BasePage.*;

public class HomePage {

    public static void goToHomePage(){

        driver.navigate().to(homePage);
        log.info("*** Ana sayfa aciliyor. ***");
    }
}
