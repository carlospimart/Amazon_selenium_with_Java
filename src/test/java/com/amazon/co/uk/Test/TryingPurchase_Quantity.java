package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.Pages.WelcomePageObject;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryingPurchase_Quantity extends TestUtilities {

    private By SearchBar = By.id("twotabsearchtextbox");
    private By SearchButton = By.id("nav-search-submit-button");
    private By ItemSearched = By.xpath("//span[contains(text(),'Echo Dot (4th generation)')]");
    private By AddToBasket = By.id("add-to-cart-button");
    private By ProceedToCheckout = By.id("sc-buy-box-ptc-button");
    private By quantity = By.id("quantity");
    private By AmazonDevices = By.xpath("//*[@id='searchDropdownBox']");
    protected By cookiesAlert = By.id("sp-cc-accept");
    protected By noThanks = By.id("a-autoid-3");
    private By AlexaLocator_i = By.xpath("//*[@id='ZG6cV5DgJGnZ6o2WdeK7yA']/div[2]/div[1]/div[2]/a/div[1]/img");
    @Test
    public void purchaseTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        sleep(1000);
        welcomePage.OpenPage();

        AlertPageObject alert = new AlertPageObject(driver, log);
        alert.acceptCookie(cookiesAlert);

        sleep(2000);

        welcomePage.selectOption(2, AmazonDevices);
        sleep(2000);

        welcomePage.click(SearchButton);
        sleep(1000);
        welcomePage.scrollToY_cord("50");

        sleep(2000);

        welcomePage.click(ItemSearched);

        sleep(2000);

        welcomePage.scrollToY_cord("100");
        sleep(1000);
        welcomePage.selectOption(2, quantity);

        sleep(2000);

        welcomePage.click(AddToBasket);

        sleep(2000);

        alert.acceptCookie(noThanks);

        welcomePage.click(ProceedToCheckout);

        sleep(1000);

        SignInPageObject signIn = new SignInPageObject(driver, log);

        String actualNoSuccessMessage =
                signIn.SignIn("atank88@hotmail.com", "continue");

        sleep(2000);

        /*** Verify that the account linked to this email doesn't exist ***/

        String expected = "We cannot find an account with that e-mail address";

        Assert.assertEquals(expected, actualNoSuccessMessage, "Error");




    }
}
