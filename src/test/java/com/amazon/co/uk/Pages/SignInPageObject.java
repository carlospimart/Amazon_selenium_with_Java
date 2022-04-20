package com.amazon.co.uk.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageObject extends BasePageObject {

    private By result = By.xpath("//*[@id='auth-error-message-box']/div/div/ul/li/span");
    private By result2 = By.xpath("//*[@id='auth-warning-message-box']/div/div/ul/li/span");
    private By emailBox = By.id("ap_email");
    private By emailPassword = By.id("ap_password");
    private By Button;


    /*** Constructor ***/
    public SignInPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /*** Method to type email address and click continue ***/

    public String SignIn(String email, String id) {
        String actualNoSuccessMessage ="";


        Button = By.id(id);

        type(email, emailBox);

        /*** We establish the condition if we are managing a Sign In button or Continue button
         * We keep the message that we got when we type an unregistered email ***/

        if(id=="signInSubmit"){
            type("BadPassword", emailPassword);
            click(Button);
            actualNoSuccessMessage = getResultText(result2);
        }else{
            click(Button);
            actualNoSuccessMessage = getResultText(result);
        }


        return actualNoSuccessMessage;
    }
}