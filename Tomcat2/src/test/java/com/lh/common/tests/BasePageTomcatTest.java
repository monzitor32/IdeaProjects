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



//    @Test
//    public void verifyBasePageHomeLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageHomeLink();
//    }

//    @Test
    public void verifyBasePageHelpLink() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageHelpLink();
    }

//    @Test
    public void verifyBasePageResetPasswordLink() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageResetPasswordLink();
    }

//    @Test
    public void verifyBasePageCreateAccountLink() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageCreateAccountLink();
    }

//    @Test
    public void verifyBasePageLoginLink() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageLoginLink();
    }

//    @Test
    public void verifyBasePageWelcomeToPortalText() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageWelcomeToPortalText();
    }

//    @Test
    public void verifyBasePageNavigatePortalText() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageNavigatePortalText();
    }

//    @Test
    public void verifyBasePageSubmitButton() throws Exception{
        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
        basePageTomcat.verifyBasePageSubmitButton();
    }


}