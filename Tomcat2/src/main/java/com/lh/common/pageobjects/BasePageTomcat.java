package com.lh.common.pageobjects;

import com.lh.utility.Log;
import com.lh.utility.ScreenShooter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePageTomcat {

    protected WebDriver driver;
    //private By signInButton = By.linkText("Sign in");
    private By usernameText = By.xpath("//td[contains(.,'Username:')]");
    //private By homeLink = By.xpath("//span[@id='HomeMenuText']");
    //private By helpLink = By.xpath("//a[contains(.,'Help')]");
    //private By resetPasswordLink = By.xpath("//a[contains(.,'Reset Password')]");
    //private By createAccountLink = By.xpath("//a[contains(.,'Create Account')]");
    //private By loginLink = By.xpath("//input[@type='submit']");
    //private By welcometoPortalText = By.xpath("//h3[contains(.,'Welcome to Portal')]");
    //private By navigatePortalText = By.xpath("//span[@id='specTitle']");
    private By signInButton = By.xpath("//input[@type='submit']");

    // added from signin
    private	By userNameLoginBox = By.xpath("//input[@id='j_username']");
    private	By passwordLoginBox = By.xpath("//input[@id='j_password']");
    private	By loginButton = By.xpath("//input[@type='submit']");

    @FindBy (xpath = "//span[@id='HomeMenuText']")
    private WebElement homeLink;
    @FindBy (xpath = "//a[contains(.,'Help')]")
    private WebElement helpLink;
    @FindBy (xpath = "//a[contains(.,'Reset Password')]")
    private WebElement resetPasswordLink;
    @FindBy (xpath = "//a[contains(.,'Create Account')]")
    private WebElement createAccountLink;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement loginLink;
    @FindBy (xpath = "//h3[contains(.,'Welcome to Portal')]")
    private WebElement welcometoPortalText;
    @FindBy (xpath = "//span[@id='specTitle']")
    private WebElement navigatePortalText;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement basePageSubmitButton;

    static String basePageTitle = "Welcome to Portal";


    public BasePageTomcat(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //original start
    public SignInPageTomcat clickSignInBtn() {

        WebElement signInBtnElement=driver.findElement(signInButton);
        if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
            signInBtnElement.click();

        else System.out.println("Element not found");

        return new SignInPageTomcat(driver);
    }

    public void clickImagesLink() {
        //It should have a logic to click on images link
        //And it should navigate to google images page
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        Log.info("Page Title is " + title);
        Log.info("Base Page Title is " + basePageTitle);
        return title;
    }

    public Boolean verifyBasePageTitle()throws Exception{
        String pageTitleText = basePageTitle;
        try{

            Assert.assertEquals(basePageTitle,driver.getTitle());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Title Test: FAILED");
            Log.error("BasePageTitle Found : " + driver.getTitle());
            Log.error("BasePageTitle Wanted: " + basePageTitle);
            ScreenShooter.getscreenshot("bingo", driver);
            return false;
        }
    }


    public Boolean verifyBasePageHomeLink() throws Exception{
        try{

            Assert.assertTrue(homeLink.isDisplayed()||homeLink.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Home Link: NOT FOUND");
            return false;
        }
    }

    public Boolean verifyBasePageHelpLink() throws Exception{

        try{

            Assert.assertTrue(helpLink.isDisplayed()||helpLink.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Help Link: NOT FOUND");
            return false;
        }

//        Assert.assertTrue(helpLink.isDisplayed()||helpLink.isEnabled());
    }

    public Boolean verifyBasePageResetPasswordLink() throws Exception{

        try{

            Assert.assertTrue(resetPasswordLink.isDisplayed()||resetPasswordLink.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Reset Password Link: NOT FOUND");
            return false;
        }

//        Assert.assertTrue(resetPasswordLink.isDisplayed()||resetPasswordLink.isEnabled());
    }

    public Boolean verifyBasePageCreateAccountLink() throws Exception{

        try{

            Assert.assertTrue(createAccountLink.isDisplayed()||createAccountLink.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Create Account Link: NOT FOUND");
            return false;
        }


//        Assert.assertTrue(createAccountLink.isDisplayed()||createAccountLink.isEnabled());
    }

    public Boolean verifyBasePageLoginLink() throws Exception{

        try{

            Assert.assertTrue(loginLink.isDisplayed()||loginLink.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Login Link: NOT FOUND");
            return false;
        }

 //       Assert.assertTrue(loginLink.isDisplayed()||loginLink.isEnabled());
    }

    public Boolean verifyBasePageWelcomeToPortalText() throws Exception{

        try{

            Assert.assertTrue(welcometoPortalText.isDisplayed()||welcometoPortalText.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Portal Welcome Text : NOT FOUND");
            return false;
        }

 //       Assert.assertTrue(welcometoPortalText.isDisplayed()||welcometoPortalText.isEnabled());
    }

    public Boolean verifyBasePageNavigatePortalText() throws Exception{

        try{

            Assert.assertTrue(navigatePortalText.isDisplayed()||navigatePortalText.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Navigate Text: NOT FOUND");
            return false;
        }

 //       Assert.assertTrue(navigatePortalText.isDisplayed()||navigatePortalText.isEnabled());
    }

    public Boolean verifyBasePageSubmitButton()throws Exception {

        try{

            Assert.assertTrue(basePageSubmitButton.isDisplayed()||basePageSubmitButton.isEnabled());
            return true;

        }catch(Throwable t){
            Log.error("BasePageTomcat Page Login Button: NOT FOUND");
            return false;
        }

        //Assert.assertTrue(basePageSubmitButton.isDisplayed()||basePageSubmitButton.isEnabled());
    }

    public void basePageTomcatPrint(String messageOut){
        Log.info(messageOut);
    }

    public void tearDown() {
        Log.warn("Tear Down BasePageTomcat after error....");
        driver.quit();
    }

}