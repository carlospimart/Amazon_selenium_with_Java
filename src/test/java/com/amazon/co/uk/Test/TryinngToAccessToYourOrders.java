package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.Pages.WelcomePageObject;
import com.amazon.co.uk.Pages.YourAccount;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TryinngToAccessToYourOrders extends TestUtilities {

    private By elementLocator = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");

    private By yourAccount = By.xpath("//*[@id='nav-al-your-account']/a[1]/span");
    protected By cookiesAlert = By.id("sp-cc-accept");



    @Test
    public void orderTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        sleep(1000);
        welcomePage.OpenPage();
        /** we close the cookies alert ***/

        AlertPageObject alert = new AlertPageObject(driver, log);
        alert.acceptCookie(cookiesAlert);

        sleep(2000);

        /*** We hover our pointer over 'Account&List' element ***/

        welcomePage.hoverOverElement(elementLocator);

        sleep(1000);
        /*** We click on 'Your Account' ***/

        welcomePage.click(yourAccount);

        sleep(1000);

        YourAccount yourAccount = new YourAccount(driver,log);

        String actualNoSuccessMessage = yourAccount.YourOrders();

        sleep(2000);

        /*** Verify that the account linked to this email doesn't exist ***/

        String expected = "We cannot find an account with that e-mail address";


        Assert.assertEquals(expected, actualNoSuccessMessage, "Error");
    }
}