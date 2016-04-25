package com.lh.base;

import com.lh.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseSetup {

    private WebDriver driver;
    static String driverPath = "c:/chromedriver_win32/";

    private String browserType = "firefox";
    private String appURL = "https://ws-tomcat-test.custman.com.au:8443";

    public WebDriver getDriver() {

        System.out.println("Starting getDriver..");
        //Log.startTestCase("MyActivitiesPageTomcat");
        return driver;

    }

    private void setDriver(String browserType, String appURL) {

        browserType = this.browserType;
        appURL = this.appURL;

        System.out.println("Starting switch browser.1.");
        if (browserType.equals("chrome")) {
            driver = initChromeDriver(appURL);

        } else if (browserType.equals("firefox")) {
            System.out.println("Starting switch browser.2.");
            driver = initFirefoxDriver(this.appURL);

        } else {
            System.out.println("browser : " + browserType
                    + " is invalid, Launching Firefox as browser of choice..");
            driver = initFirefoxDriver(this.appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {


        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath
                + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {


//		private static WebDriver initFirefoxDriver(String appURL) {	

        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
//		driver.navigate().to("http://www.google.com");
        driver.navigate().to(appURL);
//		driver.navigate().to("https://ws-tomcat-test.custman.com.au:8445");
        return driver;
    }

    //	@Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup() {


//		 browserType = this.browserType;
//		 appURL = this.appURL;


        System.out.println("Starting Parameter window ..");
        try {
//			setDriver("firefox", "https://ws-tomcat-test.custman.com.au:8445");
            setDriver(this.browserType, this.appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() {

        Log.info("Tear Down BASETEST..");
        driver.quit();
    }
}