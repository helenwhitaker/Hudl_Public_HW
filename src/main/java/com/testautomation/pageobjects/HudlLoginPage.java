package com.testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HudlLoginPage extends BasePage {

    // Locators for elements on the homepage
    private By emailUsernameFieldLocator = By.cssSelector("#username");
    private By continueButtonLocator = By.cssSelector("button[data-action-button-primary=\"true\"]");
    private By passwordFieldLocator = By.cssSelector("#password");
    private By googleSubmitButtonLocator = By.cssSelector("button[data-provider=\"google\"][data-action-button-secondary=\"true\"]");
    private By googleHudlLoginLocator = By.cssSelector("button[data-destination-info=\"Signing in will redirect you to: https://identity.hudl.com\"]\n");
    private By facebookHudlLoginLocator = By.cssSelector("button[data-provider=\"facebook\"]");
    private By facebookCookieLocator = By.xpath("//span[text()=\"Allow the use of cookies from Facebook on this browser?\"]");
    private By createAccountLocator = By.xpath("//a[text()='Create Account']");
    private By invalidFormatEmailAddress = By.xpath("//span[@class='ulp-input-error-message' and @data-error-code='invalid-email-format']");
    private By incorrectPassword = By.xpath("//span[@class='ulp-input-error-message' and @data-error-code='wrong-email-credentials']");
    private By incorrectEmailAddress = By.xpath("//span[@class='ulp-input-error-message' and @data-error-code='custom-script-error-code_invalid_user_password']");
    private By appleHudlLoginLocator = By.cssSelector("button[data-provider=\"apple\"]");
    private By appleHudlLoginTextLocator = By.xpath("//h1[contains(@class, 'si-container-title')]");


    public HudlLoginPage(WebDriver driver) {
        super(driver);

    }

    //wait for the create account text to appear on the login form
    public boolean isCreateAccountTextDisplayedAfterWait() {
        return waitForIsDisplayed(createAccountLocator);
    }

    // enter username
    public void enterUsername(String username) {
        driver.findElement(emailUsernameFieldLocator).sendKeys(username);
    }

    //click the continue button
    public void clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
    }


    // enter password
    public void enterPassword(String username) {
        driver.findElement(passwordFieldLocator).sendKeys(username);
    }

    //combining all the steps to login
    public HudlHomePage executeHudlLogin(String username, String password) {
        enterUsername(username);
        clickContinueButton();
        enterPassword(password);
        clickContinueButton();
        return new HudlHomePage(driver);
    }


    //waiting for an error message from logging in with incorrect email address details
    public String getIncorrectEmailAddressErrorMessage() {
        WebElement errorMessageElement = waitForElement(incorrectEmailAddress);
        return errorMessageElement.getText();
    }

    //waiting for an error message from logging in with incorrect password details
    public String getIncorrectPasswordErrorMessage() {
        WebElement errorMessageElement = waitForElement(incorrectPassword);
        return errorMessageElement.getText();
    }


    //waiting for an error message from logging in with an invalid format email details
    public String getInvalidFormatEmailAddressErrorMessage() {
        WebElement errorMessageElement = waitForElement(invalidFormatEmailAddress);
        return errorMessageElement.getText();
    }


    //waiting for the button which will confirm you have moved to the login with Google workflow
    public boolean isHudlGoogleLoginButtonDisplayedAfterWait() {
        return waitForIsDisplayed(googleHudlLoginLocator);
    }


    //clicking the login with Google option
    public void clickGoogleSubmitButton() {
        driver.findElement(googleSubmitButtonLocator).click();
    }

    //clicking the login with Facebook option
    public void clickHudlFacebookLogin() {
        driver.findElement(facebookHudlLoginLocator).click();
    }


    //waiting for the button which will confirm you have moved to the login with Facebook workflow
    public boolean isHudlFacebookCookieTextDisplayedAfterWait() {
        return waitForIsDisplayed(facebookCookieLocator);
    }

    //clicking the login with Apple login option
    public void clickHudlApplebookLogin() {
        driver.findElement(appleHudlLoginLocator).click();
    }


    //waiting for the text which will confirm you have moved to the login with Apple workflow
    public boolean isHudlAppleLoginTextDisplayedAfterWait() {
        return waitForIsDisplayed(appleHudlLoginTextLocator);
    }


}