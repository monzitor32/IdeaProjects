package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewLodgementPageTomcat {


    private WebDriver driver;

    private By pageHeaderText = By.xpath("//span[@class='form-header']");
    private By pageHeadingText = By.xpath("//td[@id='NewLodgementHeading']");
    private By groupText = By.xpath("//label[@for='approvalGroup']");
    private By typeText = By.xpath("//label[@for='approvalSubType']");

    private By myActivitiesLink = By.xpath("//span[@id='MyAccountMenuText']");
    private By myAccountProfileLink = By.xpath("//span[@id='AccountProfileMenuText']");

//	private By logoutButton = By.xpath("//input[@type='submit']");
//	private By submitButton = By.xpath("//button[@id='submitButton']");
//	private By groupSelect = By.xpath("//select[@id='approvalGroup']");
//	private By typeSelect = By.id("//select[@id='approvalType']");

    private By createAccountLink = By.id("link-signup");
    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Passwd");
    private By loginBtn = By.id("signIn");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");

    @FindBy(xpath ="//input[contains(@id,'idOfInputField')]")
    private WebElement someWebElement;

    @FindBy (xpath = "//select[@id='approvalGroup']")
    private WebElement groupSelectCFL;
    @FindBy (xpath = "//select[@id='approvalType']")
    private WebElement typeSelect;

    @FindBy (xpath = ("//button[@id='submitButton']"))
    private WebElement submitButton;
    @FindBy (xpath = ("//input[@type='submit']"))
    private WebElement logoutBtn;




    public NewLodgementPageTomcat(WebDriver driver) {
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    public String getSignInPageTitle() {
        System.out.println("getSignInPage Title;");
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void verifyPageTitle() {
        //String expectedTitle = "Sign in - Google Accounts";
        //getSignInPageTitle().contains(expectedTitle);
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Welcome to Portal", pageTitle);
    }


    public boolean verifySignInPageText() {
        WebElement element = driver.findElement(pageHeaderText);
        String pageText = element.getText();
        String expectedPageText = "Sign in with your Google Account";
        return pageText.contains(expectedPageText);
    }


    /**
     * waiting for createaccountpage
      *
     */


//    public CreateAccountPage clickonCreateAnAccount() {
//        WebElement element=driver.findElement(createAccountLink);
//        if(element.isDisplayed()||element.isEnabled())
//            element.click();
//        return new CreateAccountPage(driver);
//    }

    public boolean verifySignIn() {
        enterUserName("test");
        enterPassword("pass");
        clickOnSignIn();
        return getErrorMessage().contains("incorrect");
    }

    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if(emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordTextBox);
        if(passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public void clickOnSignIn() {
        WebElement signInBtn = driver.findElement(loginBtn);
        if(signInBtn.isDisplayed())
            signInBtn.click();
    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgTxt);
        if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }


//			public void clickOnLogoutButton() {
//				WebElement logoutBtn = driver.findElement(logoutButton);
//				System.out.println("clickOn Logout button start.");
//				if(logoutBtn.isDisplayed())
//					//System.out.println("SignIn button is displayed.");
//					logoutBtn.click();
//			}

    public void clickOnLogoutButton() {
        //WebElement logoutBtn = driver.findElement(logoutButton);
        System.out.println("clickOn Logout button start.");
        if(logoutBtn.isDisplayed())
            //System.out.println("SignIn button is displayed.");
            logoutBtn.click();
    }



//			@FindBy (xpath = "//select[@id='approvalGroup']")
//			private WebElement groupSelectCFL;

//			private By groupSelect = By.xpath("//select[@id='approvalGroup']");

    public void verifyGroupSelect(int grIndex){
        Select groupSelector = new Select(groupSelectCFL);
        groupSelector.selectByIndex(grIndex);
    }

    public void verifyTypeSelect(int typIndex){
        Select typeSelector = new Select(typeSelect);
        typeSelector.selectByIndex(typIndex);
    }

    //			public void verifyGroupSelectCFL (){
//			//ebElement groupSelectCFL = driver.findElement(By.id("approvalGroup"));
//			WebElement groupSelectCFL = driver.findElement((groupSelect));
//			Select groupSelector = new Select(groupSelectCFL);
//			groupSelector.selectByIndex(3);
//
    public void clickOnSubmitButton(){
        //WebElement signInBtn = driver.findElement(loginBtn);
        if(submitButton.isDisplayed())
            submitButton.click();
    }
//
//		}

}
