package com.lh.common.pageobjects;

/**
 * Created by mcs on 19/04/16.
 */


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class SuccessfullLogoutPageTomcat {

    private WebDriver driver;
    private By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");

    private By successfullLogoutText = By.xpath("//h3[contains(.,'You have successfully logged out.')]");


    public SuccessfullLogoutPageTomcat(WebDriver driver) {
        this.driver=driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle() {
        String pageTitle = "Welcome to Portal";
        return getPageTitle().contains(pageTitle);
    }
    public boolean verifySuccessfullLogoutPageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText ="You have successfully";
        return element.getText().contains(pageText);
    }


}