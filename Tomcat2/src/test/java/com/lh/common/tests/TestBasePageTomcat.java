package com.lh.common.tests;


import com.lh.base.TestBaseSetup;
import com.lh.common.pageobjects.BasePageTomcat;
import com.lh.utility.Log;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by mcs on 24/04/16.
 */
public class TestBasePageTomcat extends TestBaseSetup {


    private WebDriver driver;
    private BasePageTomcat basePageTomcat;


    @BeforeClass
    public void setUp() {
        driver=getDriver();
        Log.startTestCase("MyActivitiesPageTomcat");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        Log.endTestCase("MyActivitiesPageTomcat");
    }

    @Test
    public void verifyHomePageTitle() throws Exception {

          BasePageTomcat basePageTomcat = new BasePageTomcat(driver);

          Assert.assertTrue(basePageTomcat.verifyBasePageTitle());


    }




////
//
//    @Test
//    public void verifyBasePageHomeLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageHomeLink();
//    }
//
//    @Test
//    public void verifyBasePageHelpLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageHelpLink();
//    }
//
//    @Test
//    public void verifyBasePageResetPasswordLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageResetPasswordLink();
//    }
//
//    @Test
//    public void verifyBasePageCreateAccountLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageCreateAccountLink();
//    }
//
//    @Test
//    public void verifyBasePageLoginLink() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageLoginLink();
//    }
//
//    @Test
//    public void verifyBasePageWelcomeToPortalText() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageWelcomeToPortalText();
//    }
//
//    @Test
//    public void verifyBasePageNavigatePortalText() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageNavigatePortalText();
//    }
//
//    @Test
//    public void verifyBasePageSubmitButton() throws Exception{
//        BasePageTomcat basePageTomcat = new BasePageTomcat(driver);
//        basePageTomcat.verifyBasePageSubmitButton();
//    }
//






}
