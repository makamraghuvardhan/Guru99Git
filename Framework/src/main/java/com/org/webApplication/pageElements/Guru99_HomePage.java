package com.org.webApplication.pageElements;

import org.openqa.selenium.By;

import com.org.webApplication.Framework.InitializeBrowser;

public class Guru99_HomePage extends InitializeBrowser {
	
      protected By userID = By.name("uid");
      protected By passWord = By.name("password");
      protected By newCustomer = By.xpath("//ul[@class='menusubnav']/li[2]/a");
      protected By customername = By.name("name");
      protected By genderMale = By.xpath("//input[@value='m']");
      protected By genderfeMale = By.xpath("//input[@value='f']");
      protected By dateofBirth = By.name("dob");
      protected By address = By.name("addr");
}
