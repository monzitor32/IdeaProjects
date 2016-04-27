package com.lh.common.tests;

/**
 * Created by mcs on 19/04/16.
 */


import com.lh.base.TestBaseSetup;
import com.lh.common.pageobjects.BasePageTomcat;
import com.lh.common.pageobjects.MyActivitiesPageTomcat;
import com.lh.common.pageobjects.SignInPageTomcat;
import com.lh.utility.Log;
import com.lh.utility.ScreenShooter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class MyActivitiesPageTomcatTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPageTomcat signInPageTomcat;
    private BasePageTomcat basePageTomcat;
    private MyActivitiesPageTomcat myActivitiesPageTomcat;

    //private CreateAccountPageTomcat createAccountPageTomcat;

    @BeforeClass
    public void setUp() {
        driver=getDriver();

        Log.startTestCase("MyActivitiesPageTomcat");

    }

    @AfterClass
    public void setDown() {

        Log.endTestCase("MyActivitiesPageTomcat");
        driver.close();
//        driver.quit();
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

        ScreenShooter.messageTomcatPrint("MyActivitiesPage VERIFY BASE PAGE DETAILS PASSED.");

        // Assert.assertTrue(signInPageTomcat.verifySignInPageTitle();

        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        Assert.assertFalse(myActivitiesPageTomcat.verifySignIn());


        ScreenShooter.messageTomcatPrint("MyActivitiesPage LEAVING TEST 1.");


    }


    @Test

    public void verifyMyActivitiesNavigatePageText() throws Exception{
        //myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);

        ScreenShooter.messageTomcatPrint("MyActivitiesPage ENTERING TEST 2.");

       myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);

        Assert.assertTrue(myActivitiesPageTomcat.verifyHeaderPageText());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2a.");

        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesNavigatePageText());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2b.");

        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageNewLodgementLink());
        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2c.");

        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageAccountProfileLink());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2d.");
        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageHomeLink());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2e.");
        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesLink());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2f.");

        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageLogoutButton());

        ScreenShooter.messageTomcatPrint("MyActivitiesPage Fisnished  TEST 2g.");

        myActivitiesPageTomcat.clickOnLogoutButton();


        ScreenShooter.messageTomcatPrint("MyActivitiesPage SHOWING LAST LINE.");

    }


//    @Test
    public void verifyMyActivitiesPage() throws Exception {
//        basePageTomcat.basePageTomcatPrint("MyActivities page test BEGINS...");
        basePageTomcat = new BasePageTomcat(driver);
        signInPageTomcat = new SignInPageTomcat(driver);
        myActivitiesPageTomcat	= new MyActivitiesPageTomcat(driver);

        //signInPageTomcat = basePageTomcat.clickSignInBtn();
        //myActivitiesPagePageTomcat = basePageTomcat.clickSignInBtn();
        //createAccountPage = signInPage.clickonCreateAnAccount();

        System.out.println("Sign In functionality details...");
        basePageTomcat = new BasePageTomcat(driver);
        System.out.println("verify SignIn (1)");
        signInPageTomcat = basePageTomcat.clickSignInBtn();
        System.out.println("Verify SignIn (2)");
        Assert.assertTrue(signInPageTomcat.verifySignInPageTitle(), "Sign In page title doesn't match");
        System.out.println("Assert (1)");
        signInPageTomcat.setUserNameSI("wheel37xr");
        signInPageTomcat.setPasswordSI("Portal32");
        Assert.assertTrue(signInPageTomcat.verifySignInPageText(), "Page text not matching");
        System.out.println("Assert (2)");

//        Assert.assertTrue(signInPageTomcat.verifySignIn(), "Unable to sign in");
//        System.out.println("Assert (3)");
//
//        System.out.println("MyActivities Functions begin here..");
        Thread.sleep(1000);
        myActivitiesPageTomcat = signInPageTomcat.verifySignIn();
        Thread.sleep(1000);
        System.out.println("MyActivities Functions first section ends");

    }


//    @Test
    public void verifyPageTitle() throws Exception {
        System.out.println("MyActivities Functions second  section gegins");
        Thread.sleep(1000);
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        Thread.sleep(1000);
        myActivitiesPageTomcat.verifyMyActivitiesPageTomcatTitle();
        Thread.sleep(1000);
        System.out.println("MyActivities verify pageTitle Ends..");
    }


//    @Test
    public void verifyPageText() throws Exception {
        System.out.println("MyActivities Functions second  section gegins");
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesNavigatePageText();
        System.out.println("MyActivities verify pageText Ends..");
    }

//    @Test
    public void verifyAccountProfileLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        Thread.sleep(2000);
        myActivitiesPageTomcat.verifyMyActivitiesPageAccountProfileLink();
    }

//    @Test
    public void verifyNewLodgementLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageNewLodgementLink();
    }


//    @Test
    public void verifyHomeLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageHomeLink();
    }


//    @Test
    public void verifyLogoutButton() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageLogoutButton();
    }


//    @Test
    public void verifyUserName() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);

        myActivitiesPageTomcat.getMyActivitiesPageUsernameText();
    }

//    @Test
//            public void theRest() throws Exception{
//
//        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
//        System.out.println("Assert (4)");
//        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageTomcatText(), "Page text not matching");
//        System.out.println("Assert (5)");
//        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageAccountProfileLink(), "Page link not found");
//        System.out.println("Assert (6)");
//        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageHomeLink(), "Page home link not found");
//        System.out.println("Assert (7)");
//        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageNewLodgementLink(), "Page new lodgement link not found");
//        System.out.println("Assert (8)");
//        Assert.assertTrue(myActivitiesPageTomcat.verifyMyActivitiesPageLogoutButton(), "Page Logout button link not found");
//        System.out.println("Assert (9)");
//        String userName = myActivitiesPageTomcat.getMyActivitiesPageUsernameText();
//        System.out.println("My Activities Page UserName is " + userName + ".");
//        myActivitiesPageTomcat.clickOnLogoutButton();
//        System.out.println("My Activities Page logout button clicked.");
//
//
//
//    }



}