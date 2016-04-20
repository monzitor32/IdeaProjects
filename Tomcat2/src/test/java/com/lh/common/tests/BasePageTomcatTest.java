package com.lh.common.tests;

/**
 * Created by mcs on 19/04/16.
 */


import com.lh.base.TestBaseSetup;
import com.lh.common.pageobjects.BasePageTomcat;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasePageTomcatTest extends TestBaseSetup{

    private WebDriver driver;
    private BasePageTomcatTest basePageTomcatTest;

   @BeforeClass
    public void setUp() {
        driver=getDriver();
        System.out.println("Home page test..1.");
    }

    @Test
    public void verifyHomePage() {
        driver=getDriver();
        System.out.println("Home page test..2.");
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        System.out.println("Home page test..3.");
        Assert.assertTrue(basePageTomcat.verifyBasePageTitle(), "Base Page title doesn't match");
        System.out.println("Home page test...");
        Assert.assertTrue(basePageTomcat.verifyBasePageHomeLink(), "Base Page Home Link not present.");
        Assert.assertTrue(basePageTomcat.verifyBasePageHelpLink(), "Base Page Help Link not present.");
        Assert.assertTrue(basePageTomcat.verifyBasePageResetPasswordLink(), "Base Page Create Account Link not present.");
        Assert.assertTrue(basePageTomcat.verifyBasePageCreateAccountLink(), "Base Page Reset Password Link not present.");
        Assert.assertTrue(basePageTomcat.verifyBasePageLoginLink(), "Base Page Login link not present");
        Assert.assertTrue(basePageTomcat.verifyBasePageWelcomeToPortalText(), "Base Page Welcome to Portal Text not present");
        Assert.assertTrue(basePageTomcat.verifyBasePageNavigatePortalText(), "Base Page Navigate Portal Text not present");

    }

}