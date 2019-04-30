package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.commonutilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver; 
	
	public static Properties prop; //variable

//create constructor
	public TestBase() {
	    try {
	    	prop = new Properties();
	        FileInputStream ip =new FileInputStream("C:\\Users\\Prasath\\eclipse-workspace\\crmautomationtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	    prop.load(ip);
	    }
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
	    catch(IOException e) {
	    	e.printStackTrace();
	    }
		  
		}

 //initilization
	
	public static void initalization()
	{
		String browserName= prop.getProperty("browser");// getting Chrome browser properties
	     if(browserName.equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prasath\\eclipse-workspace\\crmautomationtest\\Resources\\chromedriver.exe");
	
	     //to define the driver
	     driver = new ChromeDriver();//to launch the chrome
	     
	     
	     }


  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
  driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//to launch the url
  driver.get(prop.getProperty("url"));

}
}