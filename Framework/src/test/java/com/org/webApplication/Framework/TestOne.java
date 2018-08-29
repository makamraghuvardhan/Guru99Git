package com.org.webApplication.Framework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.webApplication.pageElements.Guru99_HomePage;

import jxl.JXLException;

public class TestOne extends Guru99_HomePage{
	Guru99_HomePage guru99hp = new Guru99_HomePage();
	
	HttpURLConnection huc = null;
	@BeforeTest
	public void initialiseBrw() throws IOException {
		callingBrowser();
	}

	@Test(priority = 1)
	public void verifyLoginSession() throws IOException {
		driver.findElement(userID).sendKeys("mngr145026");
		driver.findElement(passWord).sendKeys("mYjEvag");
		driver.findElement(By.name("btnLogin")).click();
		screenShot();
	}
	
	@Test(priority = 2)
	public void verifyAllLinksAvailable() throws IOException {
		List<WebElement> linkscount = driver.findElements(By.tagName("a"));
		System.out.println("Links Count ---> "+linkscount.size());
		for(WebElement links : linkscount)
		{
			System.out.println(links.getText());
			String urloflink = links.getAttribute("href");
			System.out.println(urloflink);
			try
			{
				huc = (HttpURLConnection)(new URL(urloflink).openConnection());
				huc.setRequestMethod("HEAD");
                huc.connect();
                int  respCode = huc.getResponseCode();
                if(respCode>=400)
                {
                	System.out.println("the link is broken");
                }
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	@Test(priority = 3)
	public void createNewCustomer() throws IOException, JXLException
	{	
		ReadExcelData rd =new ReadExcelData("Sheet1");
		driver.findElement(newCustomer).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(customername).sendKeys(rd.readData(0, 1));
		driver.findElement(genderMale).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(dateofBirth).sendKeys("01");
		driver.findElement(dateofBirth).sendKeys("09");
		driver.findElement(dateofBirth).sendKeys("1985");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(address).sendKeys("01091985");
		screenShot();
	}
	

	

	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

}
