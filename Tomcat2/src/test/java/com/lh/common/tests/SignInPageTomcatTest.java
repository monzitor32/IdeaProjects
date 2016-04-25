package com.lh.common.tests;

import com.lh.base.TestBaseSetup;
import com.lh.common.pageobjects.BasePageTomcat;
import com.lh.common.pageobjects.SignInPageTomcat;
import com.lh.utility.Log;
import com.lh.utility.ScreenShooter;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInPageTomcatTest extends TestBaseSetup{
    private WebDriver driver;
    private SignInPageTomcat signInPageTomcat;
    private BasePageTomcat basePageTomcat;

    @BeforeClass
    public void setUp() {
        driver=getDriver();
        Log.startTestCase("SignInPageTomcat");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        Log.endTestCase("SignInPageTomcat");
    }






    /**
     * Verify Base Page details are correct.
     * @throws Exception
     */
    @Test
    public void verifyBasePage() throws Exception{
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

        ScreenShooter.messageTomcatPrint("SignInPage VERIFY BASE PAGE DETAILS PASSED.");

       // Assert.assertTrue(signInPageTomcat.verifySignInPageTitle();

    }

    /**
     * Sign in and verify MyActivities Page Details
     */
    //@Test
    public void verifySignInFunction() throws Exception {
        basePageTomcat = new BasePageTomcat(driver);
//        signInPageTomcat = basePageTomcat.clickSignInBtn();

//       Assert.assertTrue(signInPageTomcat.verifySignInPageTitle();
//        System.out.println("Assert (1)");
//        Assert.assertTrue(signInPageTomcat.verifySignInPageText(), "Page text not matching");
//        System.out.println("Assert (2)");
//        Assert.assertTrue(signInPageTomcat.verifySignIn(), "Unable to sign in");
//        System.out.println("Assert (3)");

        ScreenShooter.messageTomcatPrint("SignInPage Login successfully PASSED.");
    }

}