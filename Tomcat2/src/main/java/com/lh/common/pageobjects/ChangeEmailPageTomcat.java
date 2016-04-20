package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangeEmailPageTomcat {
    private WebDriver driver;

    private By headerPageText = By.cssSelector(".hidden-small");
    private By createAccountLink = By.id("link-signup");
    //	private By emailTextBox = By.id("Email");
//	private By passwordTextBox = By.id("Passwd");
    private By logoutBtn = By.xpath("//input[@type='submit']");
    private By changeButton	= By.xpath("//button[@id='form_submit']");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");

    private By changeEmailPageHeadText = By.xpath("//span[@class='form-header']");
    private By currentPasswordTextBox = By.xpath("//input[@type='password']");
    private By emailTextBox = By.xpath("//input[@name='email']");
    private By confirmEmailTextBox = By.xpath("//input[@title='Confirm E-mail']");
    private By emailErrMessageText = By.xpath("//label[contains(@id,'email-error')]");
    private By emailConfirmErrMessage = By.xpath("//label[contains(@id,'confirmEmail-error')]");

    private String validEmailErrorMessage = "Please enter a valid email address.";
    /**
     *
     * @param driver
     * alternate way to use the FindBy
     */
//	@FindBy(xpath ="//input[contains(@id,'idOfInputField')]")
//    private WebElement someWebElement;


    public ChangeEmailPageTomcat(WebDriver driver) {
        this.driver=driver;
    }

    public String getSignInPageTitle() {
        System.out.println("getSignInPage Title;");
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "Sign in - Google Accounts";
        return getSignInPageTitle().contains(expectedTitle);
    }

    public boolean verifySignInPageText() {
        WebElement element = driver.findElement(headerPageText);
        String pageText = element.getText();
        String expectedPageText = "Sign in with your Google Account";
        return pageText.contains(expectedPageText);
    }


    /**
     * disable until Create account page is ready
     * @param userName
     */

//    public CreateAccountPage clickonCreateAnAccount() {
//        WebElement element=driver.findElement(createAccountLink);
//        if(element.isDisplayed()||element.isEnabled())
//            element.click();
//        return new CreateAccountPage(driver);
//    }

//			public boolean verifySignIn() {
//				enterUserName("test");
//				enterPassword("pass");
//				clickOnSignIn();
//				return getErrorMessage().contains("incorrect");
//			}

    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if(emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

//			public void enterPassword(String password) {
//				WebElement passwordTxtBox = driver.findElement(passwordTextBox);
//				if(passwordTxtBox.isDisplayed())
//					passwordTxtBox.sendKeys(password);
//			}
//
//			public void clickOnSignIn() {
//				WebElement signInBtn = driver.findElement(loginBtn);
//				if(signInBtn.isDisplayed())
//					signInBtn.click();
//			}

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgTxt);
        if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }



    public Boolean enterEmail(String email) throws InterruptedException {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        //if(emailTxtBox.isDisplayed())
        emailTxtBox.sendKeys(email);
        Thread.sleep(1000);
        emailTxtBox.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        return getEmailErrorMessage().contains(validEmailErrorMessage);
    }


    public String getEmailErrorMessage() throws InterruptedException {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(emailErrMessageText);
        Thread.sleep(1000);
        if(errorMsg.isDisplayed())
            strErrorMsg = errorMsg.getText();

        return strErrorMsg;
    }


    public void emailErrorCheck() throws InterruptedException{
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        //if(emailTxtBox.isDisplayed())
        emailTxtBox.sendKeys("eee");
        Thread.sleep(1000);
        emailTxtBox.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        WebElement errorMsg = driver.findElement(emailErrMessageText);
        String strErrorMsg = null;
        if(errorMsg.isDisplayed())
            strErrorMsg = errorMsg.getText();
        System.out.println("==" + strErrorMsg);
        System.out.println("====" + validEmailErrorMessage);
        Thread.sleep(1000);
        Assert.assertEquals(validEmailErrorMessage, strErrorMsg);

    }

}
