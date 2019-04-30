package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contacts;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement add;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstName;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/input")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement company;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean checkContactTitle()
	{
		return contacts.isDisplayed();
	}

	public void clickOnNewLink() {
		add.click();
	}

	public void createNewContacts(String fName, String lName, String cmp, String em)

	{

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(cmp);
		email.sendKeys(em);

		saveBtn.click();

	}

}
