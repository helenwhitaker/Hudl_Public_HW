package com.testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HudlMainPage extends com.testautomation.pageobjects.BasePage {

    // Locators for elements on the homepage
    private By onetrustAcceptLocator = By.cssSelector("#onetrust-accept-btn-handler");
    private By onetrustRejectLocator = By.cssSelector("#onetrust-reject-all-handler");
    private By adrollAcceptLocator = By.cssSelector("#adroll_allow_all");
    private By adrollRejectLocator = By.cssSelector("#adroll_reject");
    private By loginSelectButtonLocator = By.cssSelector("a[data-qa-id=login-select]");
    private By firstSubMenuItemLocator = By.xpath("//span[text()='Hudl']");


    public HudlMainPage(WebDriver driver) {
        super(driver);

    }

    public void visit() {
        super.visit("http://www.hudl.com/");
    }

    //check if the accept cookies button is clickable and if so click it
    public boolean clickAcceptCookiesIfClickable() {
        try {

            WebElement element = waitForElementClickable(onetrustAcceptLocator);

            // If the element is clickable, click it and return true
            if (element != null) {
                element.click();
                return true;
            }
        } catch (TimeoutException e) {
            // Handle case where element is not clickable within timeout
            System.out.println("The 'Accept Cookies' button was not clickable within the wait time.");
        }
        return false; // Return false if not clickable or any exception occurred
    }


    public boolean clickRejectCookiesIfClickable() {
        try {

            WebElement element = waitForElementClickable(onetrustRejectLocator);

            // If the element is clickable, click it and return true
            if (element != null) {
                element.click();
                return true;
            }
        } catch (TimeoutException e) {
            // Handle case where element is not clickable within timeout
            System.out.println("The 'Reject Cookies' button was not clickable within the wait time.");
        }
        return false; // Return false if not clickable or any exception occurred
    }

    // Wait for the accept Ad Roll button to be displayed and click it
    public void clickAcceptAdRollButton() {
        // Wait for the reject cookies button to be displayed and clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(adrollAcceptLocator));
        // Click the button
        element.click();
    }
    // Wait for the accept Ad Roll button to be displayed and click it
    public void clickRejectAdRollButton() {
        // Wait for the reject cookies button to be displayed and clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(adrollRejectLocator));
        // Click the button
        element.click();
    }


    // Wait for the login select button to be displayed and click it
    public void clickloginSelectButton() {
        // Wait for the login select button to be displayed and clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginSelectButtonLocator));
        // Click the button
        element.click();
    }

    //click the first sub-menu option Hudl
    public void clickfirstSubMenuItemButton() {
        driver.findElement(firstSubMenuItemLocator).click();
    }


    //combining clicking login on the main menu and clicking the Hudl sub-menu option
    public void accessLoginPage() {
        clickloginSelectButton();
        clickfirstSubMenuItemButton();

    }

}


