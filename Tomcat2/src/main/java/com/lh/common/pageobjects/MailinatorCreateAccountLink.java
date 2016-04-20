package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

// this is the page to retriev the initial account create link sent from the Portal Tomcat CreateAccount page


public class MailinatorCreateAccountLink {

    private WebDriver driver;
    private By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");

    private By inboxField = By.xpath("//input[@id='inboxfield']");
    private By anyInboxLink = By.xpath("//input[@placeholder='Check Any Inbox!']");



    public MailinatorCreateAccountLink(WebDriver driver) {
        this.driver=driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle() {
        String pageTitle = "Create your Google Account";
        return getPageTitle().contains(pageTitle);
    }
    public boolean verifyCreateAccountPageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText ="Create your Google Account";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
        //need to write steps for creating an account
    }
}