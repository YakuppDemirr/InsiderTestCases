package com.insider;

import com.insider.base.BasePage;
import com.insider.util.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.insider.pages.CareerPage.*;
import static com.insider.pages.HomePage.*;
import static com.insider.pages.JobDetailsPage.*;

public class TestCasesUI extends BasePage {

    @BeforeMethod()
    public void openHomePage(){
        goToHomePage();
        Assert.assertTrue(Utility.getHomePageControl());
        log.info("*** Ana sayfa basarili bir sekilde acildi. ***");
    }

    @Test()
    public void casesCareerPage(){
        goToCareerPageControl();
        goJobDetails();
    }
}

