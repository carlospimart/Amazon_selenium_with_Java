package com.amazon.co.uk.Test;

import com.amazon.co.uk.Pages.AlertPageObject;
import com.amazon.co.uk.Pages.SignInPageObject;
import com.amazon.co.uk.Pages.WelcomePageObject;
import com.amazon.co.uk.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonPrime extends TestUtilities {

    protected By cookiesAlert = By.id("sp-cc-accept");

    public Boolean key = false;

    protected By All = By.xpath("//*[@id='nav-hamburger-menu']");

    protected By PrimeVideo = By.xpath("//*[@id='hmenu-content']/ul[1]/li[7]/a/div");

    protected By AllVideos = By.xpath("//*[@id='hmenu-content']/ul[2]/li[3]/a");
    protected By spiderman = By.xpath("//a[contains(@aria-label, 'Spider-Man: No Way Home')]");
    protected By trailer = By.xpath("//*[@id='dv-action-box']/div/div/div/div[2]/div/span/div/span[1]/span/label/a/span");
    protected By close = By.xpath("//*[@id='dv-web-player']/div/div[1]/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div/div[2]/button/div/img");
    protected By rent = By.xpath("//*[@id='tvod-btn-ab-movie-hd-tvod_rental']/span/button");
    protected By page = By.id("a-page");
    protected By slide = By.xpath("//*[@id='dv-web-player']/div/div[1]/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[2]/div[1]/div/div[2]/div/div");
    public int index;
    public String n = "";
    List<String> LisVideo_String =  Arrays.asList("//*[@id='index-", "']/b");
    @Test
    public void purchaseArticleTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        sleep(1000);
        welcomePage.OpenPage();

        AlertPageObject alert = new AlertPageObject(driver, log);
        alert.acceptCookie(cookiesAlert);

        sleep(1000);

        welcomePage.click(All);

        sleep(1000);


        welcomePage.scrollToY_cord("50");

        sleep(1000);

        welcomePage.click(PrimeVideo);

        sleep(1000);

        welcomePage.click(AllVideos);

        sleep(1000);

        for(index=0;index<6;index++){

                n = LisVideo_String.get(0) + index + LisVideo_String.get(1) ;
                System.out.println(n);
                welcomePage.click(By.xpath(n));



            sleep(750);
        }


        welcomePage.click(spiderman);

        sleep(1000);

        welcomePage.click(trailer);

        //welcomePage.SlideBar(slide,"4");

        sleep(5000);

        welcomePage.hoverOverElement(page);


        welcomePage.click(close);

        sleep(2000);

        welcomePage.click(rent);

        SignInPageObject signIn = new SignInPageObject(driver, log);

        String actualNoSuccessMessage =
                signIn.SignIn("atank88@hotmail.com", "continue");

        sleep(2000);

        /*** Verify that the account linked to this email doesn't exist ***/

        String expected = "We cannot find an account with that e-mail address";

        Assert.assertEquals(expected, actualNoSuccessMessage, "Error");


    }
}