package com.insider.pages;

import com.insider.core.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static com.insider.base.BasePage.*;
import static com.insider.util.Utility.*;

public class JobDetailsPage {

    public static By locationFilterElement=  By.id("select2-filter-by-location-container");
    public static By totalResultValue= By.cssSelector("span[class='totalResult']");
    public static By jobTitleElement= By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']");
    public static By jobLocationElement= By.cssSelector("div[class='position-location text-large']");
    public static By control=  By.xpath("(//div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkey full-timeremote'])[2]");
    public static By applyNowElement= By.xpath("(//*[text()='Apply Now'])[2]");

    public static void goJobDetails(){

        clickElement(locationFilterElement);
        Select select = new Select(driver.findElement(By.id("filter-by-location")));
        select.selectByVisibleText(PropertiesFile.jobLocation);
        log.info("*** Lokasyon olarak Istanbul, Turkey secildi. ***");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        clickElement(control);

        String textElement = getText(totalResultValue);
        Integer count = Integer.valueOf(textElement);
        log.info("*** Istanbul, Turkey lokasyonundan donen tüm QA joblari için title ve lokasyon icin value degeri alindi. ***");

        for (int i=0; i<count; i++)
        {
            Assert.assertEquals(getText(jobTitleElement), PropertiesFile.jobTitle);
            Assert.assertEquals(getText(jobLocationElement),PropertiesFile.jobLocation);
        }

        if (count != 0) {
            clickElement(applyNowElement);
            log.info("*** Apply now butonuna tiklandi. ***");

            switchToNewTab();
            log.info("*** Yonlendirilen sayfaya gecis yapildi. ***");

            Assert.assertTrue(getLeverUrlControl());
            log.info("*** Yonlendirilen sayfanin Url kontrolu yapildi. ***");
        }
    }
}
