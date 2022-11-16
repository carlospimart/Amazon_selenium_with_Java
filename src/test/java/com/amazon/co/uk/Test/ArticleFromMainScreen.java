package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.Pages.WelcomePageObject;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ArticleFromMainScreen extends TestUtilities {
    protected By cookiesAlert = By.id("sp-cc-accept");
    int i;
    boolean exists;
    protected By right_Arrow = By.xpath("//*[@id='gw-desktop-herotator']/div/div/div/div[3]/a/i");
    protected By AlexaEcho = By.xpath("//a[contains(@aria-label, 'Echo Family')]");
    protected By echo = By.xpath("//*[@id='acs-product-block-1']/a/span/span[2]");

    private By AddToBasket = By.id("add-to-cart-button");
    private By ProceedToCheckout = By.id("sc-buy-box-ptc-button");
    private By quantity = By.id("quantity");
    private By AmazonDevices = By.xpath("//*[@id='searchDropdownBox']");

    protected By noThanks = By.id("a-autoid-3");
    @Test
    public void purchaseArticleTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        sleep(1000);
        welcomePage.OpenPage();

        AlertPageObject alert = new AlertPageObject(driver, log);
        alert.acceptCookie(cookiesAlert);

        sleep(1000);

        for(i=0;i<4;i++){
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);


            exists = driver.findElements(AlexaEcho).size() != 0;

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            sleep(1000);

            if(exists == true){
                break;
            }
            welcomePage.click(right_Arrow);


        }

        welcomePage.click(AlexaEcho);
        sleep(1000);

        welcomePage.scrollToY_cord("200");

        sleep(1000);

        welcomePage.click(echo);
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
