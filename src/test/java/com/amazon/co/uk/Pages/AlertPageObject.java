package com.amazon.co.uk.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AlertPageObject extends BasePageObject {



    public AlertPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /*** This Methods is used to open a JS Alert ***/
    public void acceptCookie(By cookiesAlert) {

        log.info("Clicking JS Alert");
        click(cookiesAlert);

    }


}