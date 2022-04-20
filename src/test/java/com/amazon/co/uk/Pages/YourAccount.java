package com.amazon.co.uk.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourAccount extends BasePageObject {

    private By contact_Us = By.xpath("//*[@id='a-page']/div[2]/div[5]/div/div[1]/div[3]/div[3]/a/div/div/div");

    private By yourOrders = By.xpath("//*[@id='a-page']/div[2]/div/div[2]/div[1]/a/div/div");

    SignInPageObject signIn = new SignInPageObject(driver, log);

    /*** Constructor***/
    public YourAccount(WebDriver driver, Logger log) {
        super(driver, log);
    }



    public String YourOrders() {
        log.info("You have to log in");
        click(yourOrders);

        /*** We are addressed over 'Sign In Page' and we introduce an email chosen by the user ***/

        String actualNoSuccessMessage =
                signIn.SignIn("atank88@hotmail.com", "continue");

        return actualNoSuccessMessage;
    }

    public String Contact_Us() {

        log.info("You have to log in");

        click(contact_Us);

        /*** We are addressed over 'Sign In Page' and we introduce an email chosen by the user ***/

        String actualNoSuccessMessage =
                signIn.SignIn("atank88@hotmail.com", "signInSubmit");

        return actualNoSuccessMessage;
    }
}