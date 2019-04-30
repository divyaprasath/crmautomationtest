package com.crm.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.commonutilities.TestUtil;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "ContactsDataSheet";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
     public void setUp() throws InterruptedException {
		initalization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}
    @Test(priority=1)
    public void clickOnContactLinkTest() {
    	contactsPage = homePage.clickOnContactsPage();
    }
   
    @Test(priority = 2)
    public void verifyContactIconTest() {
    	contactsPage = homePage.clickOnContactsPage();
    	Assert.assertTrue(contactsPage.checkContactTitle());
    }
   
    @DataProvider
    public Object[][] getCrmTestData(){
		Object [][] data =TestUtil.getTestData(sheetName);
    	return data;
    	
    }
    
	@Test(priority = 3,dataProvider="getCrmTestData")
	public void validateCreateNewContact(String firstName, String lastName, String Company, String email) {
		contactsPage= homePage.clickOnContactsPage();
    	contactsPage.clickOnNewLink();
		//contactsPage.createNewContacts("Sheraala", "K", "Google", "sheralla@gmail.com");
        contactsPage.createNewContacts(firstName, lastName, Company, email);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
	}

}
