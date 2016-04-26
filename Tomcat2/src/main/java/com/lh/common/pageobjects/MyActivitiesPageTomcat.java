package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */

import com.lh.utility.Log;
import com.lh.utility.ScreenShooter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyActivitiesPageTomcat {

    private WebDriver driver;
//    private By headerPageText = By.xpath("//span[@class='form-header']");
//    private By navigateHeadingText = By.xpath("//td[@id='MyAccountHeading']");
//    private By myActivitiesLink = By.xpath("//span[contains(@id,'MyAccountMenuText')]");
    private By accountProfileLink = By.xpath("//span[contains(@id,'AccountProfileMenuText')]");
//    private By newLodgementLink = By.xpath("//span[@id='NewLodgementMenuText']");
//    private By homeLink = By.xpath("//span[@id='HomeMenuText']");
    private By panelRight = By.xpath("//p[contains(.,'PanelRight')]");
    private By panelLeft = By.xpath("//p[contains(.,'PanelLeft')]");
//    private By loginButton = By.xpath("//input[@type='submit']");
    private By accountUsername = By.xpath("//span[contains(.,'wheel37xr')]");

    @FindBy(xpath = "//span[contains(@id,'MyAccountMenuText')]")
    private WebElement myActivitiesLink;
    @FindBy(xpath = "//span[@id='HomeMenuText']")
    private WebElement homeLink;
    @FindBy(xpath = "//span[@id='NewLodgementMenuText']")
    private WebElement newLodgementLink;
    @FindBy(xpath ="//span[@class='form-header']")
    private WebElement headerPageText;
    @FindBy(xpath ="//td[contains(@id,'MyAccountHeading')]")
    private WebElement navigatePageText;
    @FindBy(xpath = "//span[contains(@id,'AccountProfileMenuText')]")
    private WebElement profileLink;
    @FindBy(xpath = "//input[contains(@id,'j_username')]")
    private WebElement userNameLoginTextBox;
    @FindBy(xpath = "//input[contains(@name,'j_password')]")
    private WebElement userPasswordTextBox;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement loginButton;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement logoutButton;
    @FindBy(xpath = "//h3[contains(.,'There was a problem logging into your account.')]")
    private WebElement basePageProblemLoginMessage;
    @FindBy(css = "input[type='submit'][value='Log out']")
    private WebElement submitCSS;

    private String userNameSI = "wheel37uv";
    //    private String userNameSI = "wheel37xr";
    private String passwordSI = "Portal32";
    private String problemLoginText = "There was a problem logging into your account.";
    private String validNavigatePageText ="This is your My Activities page. Only sections relating to you are displayed.";
    private String validHeaderPageText = "My Activities";

    public MyActivitiesPageTomcat(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    /** setters and getters for ligin username and passwd until profileCOnfig ready
     *
     *
     */

    public void setUserNameSI(String userNameSI) {
        this.userNameSI = userNameSI;
    }

    public void setPasswordSI(String passwordSI) {
        this.passwordSI = passwordSI;
    }

    public String getUserNameSI() {
        return userNameSI;
    }

    public String getPasswordSI() {
        return passwordSI;
    }



    public Boolean verifySignIn()throws Exception{

        enterUserName(userNameSI);
        enterPassword(passwordSI);
        try{
            Assert.assertFalse(clickOnSignIn());
            return false;
        }catch(Throwable t){
            return true;
        }
    }
//        Thread.sleep(1000);
//        System.out.println("verifySignIn END.");
//        return new MyActivitiesPageTomcat(driver);


    public void enterUserName(String userName) {
//        WebElement emailTxtBox = driver.findElement(userNameLoginTextBox);
        if(userNameLoginTextBox.isDisplayed())
            userNameLoginTextBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
//        WebElement passwordTxtBox = driver.findElement(userPasswordTextBox);
        if(userPasswordTextBox.isDisplayed())
            userPasswordTextBox.sendKeys(password);
    }

    public Boolean clickOnSignIn() throws Exception {
//        WebElement signInBtn = driver.findElement(loginButton);
        if(loginButton.isDisplayed())
            loginButton.click();
        Thread.sleep(1000);

        try{
            Assert.assertEquals(problemLoginText, basePageProblemLoginMessage);
            Log.error("MyActivitiesPage login FAILED.");
            return true;

        }catch (Throwable t){
            return false;
        }
    }

    public String getErrorMessage() {
        String strErrorMsg = "All OK";
//			WebElement errorMsg = driver.findElement(errorMsgTxt);
//			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
//				strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }




    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public void verifyMyActivitiesPageTomcatTitle() {
        String pageTitle = "Welcome to Portal";
//        return getPageTitle().contains(pageTitle);
        Assert.assertEquals(pageTitle, driver.getTitle());

    }

    public Boolean verifyHeaderPageText(){
        try{
            Assert.assertEquals(validHeaderPageText, headerPageText.getText());
            return true;
        }catch(Throwable t){
            Log.error("MyActivitiesPage Header Page Text Verify FAILED");
            return false;
        }
    }


    public Boolean verifyMyActivitiesNavigatePageText()throws Exception {
        try{
        Assert.assertEquals(validNavigatePageText, navigatePageText.getText());
        return true;
        }catch(Throwable t){
            Log.error("MyActivitiesPage Navigate Text Verify FAILED");
            return false;
        }
    }

//    public void verifyMyActivitiesPageAccountProfileLink() {
//        WebElement element = driver.findElement(accountProfileLink);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //Assert.assertTrue(element.isDisplayed());
//        element.click();
//    }

    public Boolean verifyMyActivitiesPageAccountProfileLink() throws Exception {
        try {
            Assert.assertTrue(profileLink.isDisplayed());
            ScreenShooter.messageTomcatPrint("Profile link text= " + profileLink.getText());
            return true;
        } catch (Throwable t) {
            Log.error("MyActivitiesPage Account Profile Link Verify FAILED");
            return false;
        }

    }


    public Boolean verifyMyActivitiesPageNewLodgementLink() {
        try {
            Assert.assertTrue(newLodgementLink.isDisplayed());
            ScreenShooter.messageTomcatPrint("Profile link text= " + newLodgementLink.getText());
            return true;
        } catch (Throwable t) {
            Log.error("MyActivitiesPage New Lodgement Link Verify FAILED");
            return false;
        }
    }

    public Boolean verifyMyActivitiesPageHomeLink() {
        try {
            Assert.assertTrue(homeLink.isDisplayed());
            ScreenShooter.messageTomcatPrint("MyActivitiesPage Home link text= " + homeLink.getText());
            return true;
        } catch (Throwable t) {
            Log.error("MyActivitiesPage Home Link Verify FAILED");
            return false;
        }
    }


    public Boolean verifyMyActivitiesLink() {
        try {
            Assert.assertTrue(homeLink.isDisplayed());
            ScreenShooter.messageTomcatPrint("MyActivitiesPage MyActivities link text= " + myActivitiesLink.getText());
            return true;
        } catch (Throwable t) {
            Log.error("MyActivitiesPage MyActivities Link Verify FAILED");
            return false;
        }
    }



    public Boolean verifyMyActivitiesPageLogoutButton() {
        try {
            Assert.assertTrue(submitCSS.isDisplayed()||submitCSS.isEnabled());
            ScreenShooter.messageTomcatPrint("MyActivitiesPage Logout Button link text= " + submitCSS.getCssValue("value"));
            return true;
        } catch (Throwable t) {
            Log.error("MyActivitiesPage MyActivities Logout Button Verify FAILED");
            return false;
        }

    }

    public String getMyActivitiesPageUsernameText() {
        WebElement element = driver.findElement(accountUsername);
        String pageText = element.getText();
        return pageText;
    }

    public void clickOnLogoutButton() {
 //       WebElement signInBtn = driver.findElement(logoutButton);
        System.out.println("clickOn SignIn button start.");
        if(submitCSS.isDisplayed())
            //System.out.println("SignIn button is displayed.");
            submitCSS.click();
    }


//	public void createAccount() {
//		//need to write steps for creating an account
//	}


}