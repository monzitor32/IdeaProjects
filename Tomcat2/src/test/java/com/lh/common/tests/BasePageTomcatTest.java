package com.lh.common.tests;

import com.lh.base.TestBaseSetup;
import com.lh.common.pageobjects.BasePageTomcat;
import com.lh.utility.Log;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasePageTomcatTest extends TestBaseSetup{

    private WebDriver driver;
    private BasePageTomcat basePageTomcat;


    @BeforeClass
    public void setUp() {
        driver=getDriver();
       Log.startTestCase("BasePageTomcat");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        Log.endTestCase("BasePageTomcat");
    }


    /**Check for the Page Title details
     *
     */
    @Test
    public void verifyHomePageTitle() throws Exception {

        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        Assert.assertTrue(basePageTomcat.verifyBasePageTitle());

        Assert.assertTrue(basePageTomcat.verifyBasePageHomeLink());

        Assert.assertTrue(basePageTomcat.verifyBasePageHelpLink());
        Assert.assertTrue(basePageTomcat.verifyBasePageResetPasswordLink());
        Assert.assertTrue(basePageTomcat.verifyBasePageCreateAccountLink());
        Assert.assertTrue(basePageTomcat.verifyBasePageLoginLink());
        Assert.assertTrue(basePageTomcat.verifyBasePageWelcomeToPortalText());
        Assert.assertTrue(basePageTomcat.verifyBasePageNavigatePortalText());
        Assert.assertTrue(basePageTomcat.verifyBasePageSubmitButton());

        basePageTomcat.basePageTomcatPrint("ALL TESTS PASSED");

    }



}