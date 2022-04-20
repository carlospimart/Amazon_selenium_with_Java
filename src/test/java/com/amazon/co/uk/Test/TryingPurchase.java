package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.co.uk.Pages.WelcomePageObject;

public class TryingPurchase extends TestUtilities {

    private By SearchBar = By.id("twotabsearchtextbox");
    private By SearchButton = By.id("nav-search-submit-button");
    private By ItemSearched = By.xpath("//span[contains(text(),'AOVOPRO Electric Scooter Pro')]");
    private By AddToBasket = By.id("add-to-cart-button");
    private By ProceedToCheckout = By.id("sc-buy-box-ptc-button");
    protected By cookiesAlert = By.id("sp-cc-accept");
    @Test
    public void purchaseTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        sleep(1000);
        welcomePage.OpenPage();

        AlertPageObject alert = new AlertPageObject(driver,log);
        alert.acceptCookie(cookiesAlert);

        sleep(2000);

        /*** Typing eScooter in the search bar ****/
        welcomePage.type("eScooter", SearchBar);

        sleep(1000);

        /*** Click search button ****/

        welcomePage.click(SearchButton);

        sleep(1000);

        /*** move the Slide Bar  ***/

        welcomePage.scrollToY_cord("400");

        sleep(2000);

        /*** Click the Link with the locator contain ***/

        welcomePage.click(ItemSearched);
        sleep(1000);

        /*** Click add to the basket ***/

        welcomePage.click(AddToBasket);

        sleep(1000);

        /*** Click Proceed to checkout ***/

        welcomePage.click(ProceedToCheckout);

        sleep(1000);

        /*** Type wrong address and click continue ***/

        SignInPageObject signIn = new SignInPageObject(driver, log);

        String actualNoSuccessMessage =
                signIn.SignIn("atank88@hotmail.com", "continue");

        sleep(2000);

        /*** Verify that the account linked to this email doesn't exist ***/

        String expected = "We cannot find an account with that e-mail address";

        Assert.assertEquals(expected, actualNoSuccessMessage, "Error");



    }
}
