package com.lh.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by mcs on 24/04/16.
 */
public class ScreenShooter {

    private String fileName;
    private String filePath;

    public static void getscreenshot(String fileName, WebDriver driver) throws Exception
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("C:/ScreenShots/screenshot.png"));
    }


    public static void messageTomcatPrint(String messageOut){
        Log.info(messageOut);
    }


}



