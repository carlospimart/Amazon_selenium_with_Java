package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.Pages.WelcomePageObject;
import com.amazon.co.uk.Pages.YourAccount;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryingToContactCustomerServices extends TestUtilities{

    private By nav_locator = By.xpath("//*[@id='nav-xshop']/a[2]");

    private By contact_Us = By.xpath("//*[@id='a-page']/div[2]/div[5]/div/div[1]/div[3]/div[3]/a/div/div/div");
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


        welcomePage.click(nav_locator);


        sleep(1000);

        /*** We click on Contact Us ***/

        YourAccount yourAccount = new YourAccount(driver,log);

        String actualNoSuccessMessage = yourAccount.Contact_Us();

        sleep(2000);

        /*** Verify that the account linked to this email doesn't exist ***/

        String expected = "To better protect your account, please re-enter your password and then " +
                "enter the characters as they are shown in the image below.";


        Assert.assertEquals(expected, actualNoSuccessMessage, "Error");
    }
}
