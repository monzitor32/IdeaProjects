package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class SignInPageTomcat {

    private WebDriver driver;

    //private By headerPageText = By.cssSelector(".hidden-small");
    private By createAccountLink = By.id("link-signup");
    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Passwd");
    private By loginBtn = By.id("signIn");
    private By errorMsgTxt = By.xpath("//h3[contains(.,'There was a problem logging into your account.')]");

//Tomcat2 links begin here

//private By homeLink = By.xpath("//span[@id='HomeMenuText']");

    private By homeLink = By.xpath("//span[@id='HomeMenuText']");
    private By myActivitiesLink = By.xpath("//span[@id='HomeMenuText']");
    private By newLodgementLink = By.xpath("//span[@id='HomeMenuText']");
    private By logoutLink = By.xpath("//input[@type='submit']");
    private By userName = By.xpath("//span[contains(.,'wheel37xr')]");

    private	By userNameLoginBox = By.xpath("//input[@id='j_username']");
    private	By passwordLoginBox = By.xpath("//input[@id='j_password']");
    private	By loginButton = By.xpath("//input[@type='submit']");
    private By signInPageWelcomeText = By.xpath("//span[contains(@id,'specTitle')]");
    private String userNameSI;
    private String passwordSI;

    public SignInPageTomcat(WebDriver driver) {
        this.driver=driver;
    }

    public String getSignInPageTitle() {
        System.out.println("getSignInPage Title;");
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "Welcome to Portal";
        return getSignInPageTitle().contains(expectedTitle);
    }

    public boolean verifySignInPageText() {
        System.out.println("signINPageTomcat verifySignInPageTest START.");
        WebElement element = driver.findElement(signInPageWelcomeText);
        String pageText = element.getText();
        System.out.println("signINPageTomcat verifySignInPageTest MIDDLE. + pageText");
        String expectedPageText = "Navigate Portal";
        System.out.println("signINPageTomcat verifySignInPageTest END.");
        return pageText.contains(expectedPageText);
    }

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

    //    public CreateAccountPage clickonCreateAnAccount() {
//        WebElement element=driver.findElement(createAccountLink);
//        if(element.isDisplayed()||element.isEnabled())
//            element.click();
//        return new CreateAccountPage(driver);
//    }

//    public boolean verifySignIn() {
//        System.out.println("verifySignIn BEGIN.");
//        enterUserName("wheel37xr");
//        enterPassword("Portal32");
//        clickOnSignIn();
//        System.out.println("verifySignIn END.");
////        return getErrorMessage().contains("All OK");
//        return
//    }
    public MyActivitiesPageTomcat verifySignIn()throws Exception{
        System.out.println("verifySignIn BEGIN.");
        enterUserName(userNameSI);
        enterPassword(passwordSI);
        clickOnSignIn();
        Thread.sleep(1000);
        System.out.println("verifySignIn END.");
        return new MyActivitiesPageTomcat(driver);
    }



    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(userNameLoginBox);
        if(emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordLoginBox);
        if(passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public void clickOnSignIn() throws Exception {
        WebElement signInBtn = driver.findElement(loginButton);
        System.out.println("clickOn SignIn button start.");
        if(signInBtn.isDisplayed())
            //System.out.println("SignIn button is displayed.");
            signInBtn.click();
        Thread.sleep(1000);
        System.out.println("SignIn button was clicked.");

    }


    public String getErrorMessage() {
        String strErrorMsg = "All OK";
//			WebElement errorMsg = driver.findElement(errorMsgTxt);
//			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
//				strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }


}