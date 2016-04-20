package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyActivitiesPageTomcat {

    private WebDriver driver;
    private By headerPageTxt = By.xpath("//span[@class='form-header']");
    private By accountHeadingText = By.xpath("//td[@id='MyAccountHeading']");
    private By myActivitiesLink = By.xpath("//span[contains(@id,'MyAccountMenuText')]");
    private By accountProfileLink = By.xpath("//span[contains(@id,'AccountProfileMenuText')]");
    private By newLodgementLink = By.xpath("//span[@id='NewLodgementMenuText']");
    private By homeLink = By.xpath("//span[@id='HomeMenuText']");
    private By panelRight = By.xpath("//p[contains(.,'PanelRight')]");
    private By panelLeft = By.xpath("//p[contains(.,'PanelLeft')]");
    private By logoutButton = By.xpath("//input[@type='submit']");
    private By accountUsername = By.xpath("//span[contains(.,'wheel37xr')]");

    @FindBy(xpath = "//span[contains(@id,'AccountProfileMenuText')]")
    private WebElement profileLink;

    public MyActivitiesPageTomcat(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
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

    public void  verifyMyActivitiesPageTomcatText() {
        WebElement element = driver.findElement(accountHeadingText);
        String pageText ="This is your My Activities page. Only sections relating to you are displayed.";
        Assert.assertEquals(pageText, element.getText());
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

        public void verifyMyActivitiesPageAccountProfileLink() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(profileLink.isDisplayed());
//        element.click();
    }


    public void verifyMyActivitiesPageNewLodgementLink() {
        WebElement element = driver.findElement(newLodgementLink);
        Assert.assertTrue(element.isDisplayed()||element.isEnabled());
 //       element.click();

    }

    public void verifyMyActivitiesPageHomeLink() {
        WebElement element = driver.findElement(homeLink);
        Assert.assertTrue(element.isDisplayed()||element.isEnabled());


    }

    public void verifyMyActivitiesPageLogoutButton() {
        WebElement element = driver.findElement(logoutButton);
        Assert.assertTrue(element.isDisplayed()||element.isEnabled());
    }

    public String getMyActivitiesPageUsernameText() {
        WebElement element = driver.findElement(accountUsername);
        String pageText = element.getText();
        return pageText;
    }

    public void clickOnLogoutButton() {
        WebElement signInBtn = driver.findElement(logoutButton);
        System.out.println("clickOn SignIn button start.");
        if(signInBtn.isDisplayed())
            //System.out.println("SignIn button is displayed.");
            signInBtn.click();
    }


//	public void createAccount() {
//		//need to write steps for creating an account
//	}


}