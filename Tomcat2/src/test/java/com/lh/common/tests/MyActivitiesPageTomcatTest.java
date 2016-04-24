package com.lh.common.tests;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.WebDriver;

        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.Test;

        import com.lh.base.TestBaseSetup;
        import com.lh.common.pageobjects.BasePageTomcat;
//      import com.lh.common.pageobjects.CreateAccountPageTomcat;
        import com.lh.common.pageobjects.SignInPageTomcat;
        import com.lh.common.pageobjects.MyActivitiesPageTomcat;

//      import lh.com.utility.Log;

public class MyActivitiesPageTomcatTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPageTomcat signInPageTomcat;
    private BasePageTomcat basePageTomcat;
    private MyActivitiesPageTomcat myActivitiesPageTomcat;

    //private CreateAccountPageTomcat createAccountPageTomcat;

    @BeforeClass
    public void setUp() {
        driver=getDriver();

//        Log.startTestCase("MyActivitiesPageTomcat");

    }

    @AfterClass
    public void setDown() {

//        Log.endTestCase("MyActivitiesPageTomcat");

    }


    @Test
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


    @Test
    public void verifyPageTitle() throws Exception {
        System.out.println("MyActivities Functions second  section gegins");
        Thread.sleep(1000);
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        Thread.sleep(1000);
        myActivitiesPageTomcat.verifyMyActivitiesPageTomcatTitle();
        Thread.sleep(1000);
        System.out.println("MyActivities verify pageTitle Ends..");
    }


    @Test
    public void verifyPageText() throws Exception {
        System.out.println("MyActivities Functions second  section gegins");
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageTomcatText();
        System.out.println("MyActivities verify pageText Ends..");
    }

    @Test
    public void verifyAccountProfileLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        Thread.sleep(2000);
        myActivitiesPageTomcat.verifyMyActivitiesPageAccountProfileLink();
    }

    @Test
    public void verifyNewLodgementLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageNewLodgementLink();
    }


    @Test
    public void verifyHomeLink() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageHomeLink();
    }


    @Test
    public void verifyLogoutButton() throws Exception{
        myActivitiesPageTomcat = new MyActivitiesPageTomcat(driver);
        myActivitiesPageTomcat.verifyMyActivitiesPageLogoutButton();
    }


    @Test
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