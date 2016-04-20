package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class BasePageTomcat {

    private WebDriver driver;
    //private By signInButton = By.linkText("Sign in");
    private By usernameText = By.xpath("//td[contains(.,'Username:')]");
    private By homeLink = By.xpath("//span[@id='HomeMenuText']");
    private By helpLink = By.xpath("//a[contains(.,'Help')]");
    private By resetPasswordLink = By.xpath("//a[contains(.,'Reset Password')]");
    private By createAccountLink = By.xpath("//a[contains(.,'Create Account')]");
    private By loginLink = By.xpath("//input[@type='submit']");
    private By welcometoPortalText = By.xpath("//h3[contains(.,'Welcome to Portal')]");
    private By navigatePortalText = By.xpath("//span[@id='specTitle']");
    private By signInButton = By.xpath("//input[@type='submit']");

    // added from signin
    private	By userNameLoginBox = By.xpath("//input[@id='j_username']");
    private	By passwordLoginBox = By.xpath("//input[@id='j_password']");
    private	By loginButton = By.xpath("//input[@type='submit']");



    public BasePageTomcat(WebDriver driver) {
        this.driver = driver;
    }

    //original start
    public SignInPageTomcat clickSignInBtn() {
        System.out.println("basePageTomcat Clicking on sign in button.");
        WebElement signInBtnElement=driver.findElement(signInButton);
        if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
            //signInBtnElement.click();
            System.out.println("SignInButtound FOUND.");
        else System.out.println("Element not found");
        System.out.println("basePageTomcat Clicked on sign in button.");
        return new SignInPageTomcat(driver);
    }
    //originl end

    //modify start
//	public SignInPageTomcat clickSignInBtn() {
//		System.out.println("Clicking on sign in button");
//		WebElement signInBtnElement=driver.findElement(loginButton);
//		System.out.println("Clicked on sign in button");
//		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
//			signInBtnElement.click();
//		else System.out.println("Element not found");
//		return new SignInPageTomcat(driver);
//	}
    //modify end


    public void clickImagesLink() {
        //It should have a logic to click on images link
        //And it should navigate to google images page
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyBasePageTitle() {
        String expectedPageTitle="Welcome to Portal";
        System.out.println("basePageTomcat verifyBasePageTitle is " + getPageTitle());
        return getPageTitle().contains(expectedPageTitle);
    }


    public boolean verifyBasePageHomeLink() {
        WebElement element = driver.findElement(homeLink);
        return (element.isDisplayed()||element.isEnabled());
    }

    public boolean verifyBasePageHelpLink() {
        System.out.println("verifyBasePsgeHelpLink.1");
        WebElement element = driver.findElement(helpLink);
        System.out.println("verifyBasePageHelpLink.2");
        return (element.isDisplayed()||element.isEnabled());
    }

    public boolean verifyBasePageResetPasswordLink() {
        System.out.println("verifyBasePageResetPasswordLink.1");
        WebElement element = driver.findElement(resetPasswordLink);
        System.out.println("verifyBasePageResetPasswordLink.2");
        return (element.isDisplayed()||element.isEnabled());
    }

    public boolean verifyBasePageCreateAccountLink() {
        System.out.println("verifyBasePageCreateAccountLink.1");
        WebElement element = driver.findElement(createAccountLink);
        System.out.println("verifyBasePageCreateAccountLink.2");
        return (element.isDisplayed()||element.isEnabled());
    }


    public boolean verifyBasePageLoginLink() {
        System.out.println("verifyBasePageLoginLink.1");
        WebElement element = driver.findElement(loginLink);
        System.out.println("verifyBasePageLoginLink.2");
        return (element.isDisplayed()||element.isEnabled());
    }

    public boolean verifyBasePageWelcomeToPortalText() {
        System.out.println("verifyBasePageWelcomeToPortalText.1");
        WebElement element = driver.findElement(welcometoPortalText);
        System.out.println("verifyBasePageWelcomeToPortalText.2");
        return (element.isDisplayed()||element.isEnabled());
    }

    public boolean verifyBasePageNavigatePortalText() {
        System.out.println("verifyBasePageNavigatePortalText.1");
        WebElement element = driver.findElement(navigatePortalText);
        System.out.println("verifyBasePageNavigatePortalText.2");
        return (element.isDisplayed()||element.isEnabled());
    }


}