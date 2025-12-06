package com.practice.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	public static String takeScreenShot(WebDriver driver, String testName) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		// screenshot filename
		String fileName = testName + "-" + timeStamp + ".png";
		// file storage path - /screenshots/-->Folder inside project
		String path = System.getProperty("user.dir") + "/screenshots/" + fileName;
		// Capture Screenshot Using Selenium
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// This file is where the screenshot will be saved permanently.
		File dest = new File(path);
		// Copy Screenshot from src → dest .Copies the temporary screenshot file into your /screenshots folder
		try {
			 Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
