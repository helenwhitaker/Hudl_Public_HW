package com.testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HudlHomePage extends com.testautomation.pageobjects.BasePage {

    // Locators for elements on the home page
    private By homeLinkLocator = By.linkText("Home");
    private By watchNowLinkLocator = By.linkText("Watch Now");

    public HudlHomePage(WebDriver driver) {
        super(driver);
    }

    // Method to verify the Home link is displayed
    public boolean isHomeLinkDisplayed() {
        return isDisplayed(homeLinkLocator);
    }

    // Method to verify the Watch Now link is displayed
    public boolean isWatchNowLinkDisplayed() {
        return isDisplayed(watchNowLinkLocator);

    }

    public void load() {
        waitForElement(homeLinkLocator);
    }

    //waiting for the button which will confirm you have moved to the login with Facebook workflow
    public boolean isHomeLinkDisplayedAfterWait() {
        return waitForIsDisplayed(homeLinkLocator);
    }


}