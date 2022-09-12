package com.insider.pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import static com.insider.base.BasePage.*;
import static com.insider.util.Utility.*;

public class CareerPage {
    public static By acceptCookies= By.cssSelector("a[id='wt-cli-accept-all-btn']");
    public static By moreTabElement= By.xpath("//*[text()='More']");
    public static By clickCareersElement= By.xpath("//h5[contains(text(),'Careers')]");
    public static By teamsElement= By.cssSelector("div[data-id='b6c45b2']");
    public static By locationElement= By.cssSelector("div[data-id='b1a909d']");
    public static By lifeAtInsiderElement= By.cssSelector("div[data-id='87842ec']");
    public static By allTeamsElement= By.xpath("//*[text()='See all teams']");
    public static By qualityElement=  By.xpath("//*[text()='Quality Assurance']");
    public static By allQaJobElement=  By.xpath("//*[text()='See all QA jobs']");

    public static void goToCareerPageControl(){

        clickElement(acceptCookies);
        log.info("*** Cookies kabul edildi. ***");

        clickElement(moreTabElement);
        log.info("*** More tabina tiklandi. ***");

        clickElement(clickCareersElement);
        log.info("*** Career sayfasina yonlendirildi. ***");

        Assert.assertTrue(getCareerPageControl());
        log.info("*** Career sayfasinin acilip acilmadigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(teamsElement));
        log.info("*** Teams blok yuklenip yuklenmedigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(locationElement));
        log.info("*** Location blok yuklenip yuklenmedigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(lifeAtInsiderElement));
        log.info("*** Life at Insider blok yuklenip yuklenmedigi kontrol edildi. ***");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2500)");

        waitBySeconds(2);
        clickElement(allTeamsElement);
        log.info("*** See all teams butonuna tiklandi. ***");

        js.executeScript("window.scrollBy(0,1800)");
        waitBySeconds(2);
        clickElement(qualityElement);
        log.info("*** Quality Assurance containerina tiklandi. ***");

        clickElement(allQaJobElement);
        log.info("*** See all Qa jobs butonuna tiklandi. ***");
    }
}
