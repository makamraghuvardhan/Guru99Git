package com.org.webApplication.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeBrowser {
	public WebDriver driver;
	public Properties pro = new Properties();
	String pathofPropertyFile = "/home/raghu/git/Guru99Git/Framework/config.properties";
	
	public void callingBrowser() throws IOException {
		InputStream file = new FileInputStream(pathofPropertyFile);
		pro.load(file);
		switch (pro.getProperty("browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","/home/raghu/git/Guru99Git/Framework/Drivers/geckodriver");
			driver = new ChromeDriver();
			getURL_AndMax();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","/home/raghu/git/Guru99Git/Framework/Drivers/geckodriver");
			driver =new FirefoxDriver();
			getURL_AndMax();
			break;
		default:
			break;
		}
	}
	
	public void getURL_AndMax() throws IOException
	{
		InputStream file = new FileInputStream(pathofPropertyFile);
		pro.load(file);
		driver.get(pro.getProperty("url"));
		driver.manage().window().fullscreen();
	}
	
	public void screenShot() throws IOException
	{
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		File sourcefiledir = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefiledir, new File("/home/raghu/git/Guru99Git/Framework/Screen/"+(dtf.format(new Date())+".png")));
	}

}
