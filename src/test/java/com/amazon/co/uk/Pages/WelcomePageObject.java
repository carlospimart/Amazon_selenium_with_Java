package com.amazon.co.uk.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{


    private String pageUrl = "https://www.amazon.co.uk/";
    private By longinLinkLocator = By.linkText("Form Authentication");

    /*** Method to open the page ***/
    public WelcomePageObject(WebDriver driver, Logger log){

        super(driver,log);
    }

    /*** Open WelcomePage with it's url ***/
    public void OpenPage(){
        log.info("Opening Page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page is opened");
    }





}

