package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// page factory design pattern

	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a")
	WebElement loginBtn;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public HomePage login(String em, String pwd) throws InterruptedException {

		loginBtn.click();

		email.sendKeys(em);
		password.sendKeys(pwd);
		login.click();
		
		Thread.sleep(3000);

		return new HomePage();

	}

}
