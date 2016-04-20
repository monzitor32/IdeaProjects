package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class CreateAccountMessagePageTomcat {

    private WebDriver driver;
    private By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");

    private By createAccountMessageHeadingText = By.xpath("//span[@id='CreateAccountMessage']");
    private By createAccountMessageText = By.xpath("//h4[contains(.,'You have successfully registered with Fisheries Portal. A confirmation email has been sent. Please confirm your email address (wheel37xs@mailinator.com) using the link in the email to verify your account.')]");
    private By createAccountMessageHomeLink = By.xpath("//span[@id='HomeMenuText']");


    public CreateAccountMessagePageTomcat(WebDriver driver) {
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
    public boolean verifyCreateAccountMessagePageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText ="Create your Google Account";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
        //need to write steps for creating an account
    }
}