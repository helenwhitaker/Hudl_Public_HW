package com.testautomation.tests.login;

import com.testautomation.pageobjects.HudlHomePage;
import com.testautomation.pageobjects.HudlMainPage;
import com.testautomation.pageobjects.HudlLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestDataUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginTests {
    private WebDriver driver;
    private Logger logger;
    private HudlMainPage hudlMainPage;  // Declare the page objects
    private HudlHomePage hudlHomePage;
    private HudlLoginPage hudlLoginPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger = Logger.getLogger(LoginTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running test in " + browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                logger.warning("Configuration for " + browser + " is missing, so running tests in Chrome by default");
                driver = new ChromeDriver();
                break;


        }
        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize page objects
        hudlMainPage = new HudlMainPage(driver);
        hudlHomePage = new HudlHomePage(driver);
        hudlLoginPage = new HudlLoginPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        logger.info("Browser is closed");
    }


    @Test(groups = {"positive", "smoke", "regression"})
    public void testLoginFunctionalityAcceptCookiesIgnoreAdRoll() {
        logger.info("Starting testLoginFunctionalityAcceptCookiesIgnoreAdRoll");
        // Get credentials from the properties file
        String username = TestDataUtil.getProperty("validUsername");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.clickAcceptCookiesIfClickable();
        hudlMainPage.accessLoginPage();
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.executeHudlLogin(username, password);
        logger.info("Verify the login functionality");
        hudlHomePage.isHomeLinkDisplayedAfterWait();
        Assert.assertTrue(hudlHomePage.isHomeLinkDisplayed());
        Assert.assertEquals(hudlHomePage.getCurrentUrl(), "https://www.hudl.com/home");
    }


    @Test(groups = {"positive", "regression"})
    public void testLoginFunctionalityRejectCookiesIgnoreAdRoll() {
        logger.info("Starting testLoginFunctionalityRejectCookiesIgnoreAdRoll");
        // Get credentials from the properties file
        String username = TestDataUtil.getProperty("validUsername");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.clickRejectCookiesIfClickable();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.executeHudlLogin(username, password);
        logger.info("Verify the login functionality");
        Assert.assertTrue(hudlHomePage.isWatchNowLinkDisplayed());
        Assert.assertTrue(hudlHomePage.isHomeLinkDisplayed());
        Assert.assertEquals(hudlHomePage.getCurrentUrl(), "https://www.hudl.com/home");
    }



    @Test(groups = {"positive", "regression"})
    public void testLoginFunctionalityIgnoreCookiesIgnoreAdRoll() {
        logger.info("Starting testLoginFunctionalityIgnoreCookiesIgnoreAdRoll");
        // Get credentials from the properties file
        String username = TestDataUtil.getProperty("validUsername");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.executeHudlLogin(username, password);
        logger.info("Verify the login functionality");
        Assert.assertTrue(hudlHomePage.isWatchNowLinkDisplayed());
        Assert.assertTrue(hudlHomePage.isHomeLinkDisplayed());
        Assert.assertEquals(hudlHomePage.getCurrentUrl(), "https://www.hudl.com/home");
    }


    @Test(groups = {"positive", "regression"})
    public void testSelectGoogleLogin() {
        logger.info("Starting testSelectGoogleLogin");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.clickGoogleSubmitButton();
        hudlLoginPage.isHudlGoogleLoginButtonDisplayedAfterWait();

    }


    @Test(groups = {"positive", "regression"})
    public void testSelectFacebookLogin() {
        logger.info("Starting testSelectFacebookLogin");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.clickHudlFacebookLogin();
        hudlLoginPage.isHudlFacebookCookieTextDisplayedAfterWait();
    }

    @Test(groups = {"positive", "regression"})
    public void testSelectAppleLogin() {
        logger.info("Starting testSelectAppleLogin");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.clickHudlApplebookLogin();
        hudlLoginPage.isHudlAppleLoginTextDisplayedAfterWait();
    }



    @Test(groups = {"negative", "smoke", "regression"})
    public void negativeLoginTestInCorrectPassword() {
        logger.info("Starting negativeLoginTestInCorrectPassword");
        String username = TestDataUtil.getProperty("validUsername");
        String password = TestDataUtil.getProperty("incorrectPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.executeHudlLogin(username, password);
        logger.info("Verify the error message is as expected");
        String actualErrorMessage = hudlLoginPage.getIncorrectPasswordErrorMessage();
        String expectedErrorMessage = "Your email or password is incorrect. Try again.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected!");
    }


    @Test(groups = {"negative", "smoke", "regression"})
    public void negativeLoginTestIncorrectUsername() {
        logger.info("Starting negativeLoginTestIncorrectUsername");
        String username = TestDataUtil.getProperty("incorrectUsername");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        logger.info("Verify the login form has been displayed");
        hudlLoginPage.isCreateAccountTextDisplayedAfterWait();
        hudlLoginPage.executeHudlLogin(username, password);
        logger.info("Verify the error message is as expected");
        String actualErrorMessage = hudlLoginPage.getIncorrectEmailAddressErrorMessage();
        String expectedErrorMessage = "Incorrect username or password.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected!");
    }

    @Test(groups = {"negative", "regression"})
    public void negativeLoginTestInvalidUsername1() {
        logger.info("Starting negativeLoginTestInvalidUsername1");
        String username = TestDataUtil.getProperty("invalidUsername1");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        hudlLoginPage.enterUsername(username);
        hudlLoginPage.clickContinueButton();
        String actualErrorMessage = hudlLoginPage.getInvalidFormatEmailAddressErrorMessage();
        String expectedErrorMessage = "Enter a valid email.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected!");

    }

    @Test(groups = {"negative", "regression"})
    public void negativeLoginTestInvalidUsername2() {
        logger.info("Starting negativeLoginTestInvalidUsername2");
        String username = TestDataUtil.getProperty("invalidUsername2");
        String password = TestDataUtil.getProperty("validPassword");
        HudlMainPage hudlMainPage = new HudlMainPage(driver);
        hudlMainPage.visit();
        hudlMainPage.accessLoginPage();
        hudlLoginPage.enterUsername(username);
        hudlLoginPage.clickContinueButton();
        String actualErrorMessage = hudlLoginPage.getInvalidFormatEmailAddressErrorMessage();
        String expectedErrorMessage = "Enter a valid email.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected!");
    }
}
