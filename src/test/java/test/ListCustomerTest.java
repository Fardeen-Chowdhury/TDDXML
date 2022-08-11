package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContacts;
import page.Dashboard;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	WebDriver driver;
	
	@Test
	@Parameters({"userName", "password", "FullName",
		"CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName,
			String password, String fullName, String companyName, String email,	String phone,
			String address, String city, String country, String state, String zip) {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUseName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		Dashboard dashboardpage = PageFactory.initElements(driver, Dashboard.class);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardpage.validDashboardPage("Dashboard");
		dashboardpage.clickCustomerMenuButton();
		dashboardpage.clickListCustomerMenuButton();
		
		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.clickAddCustomerOnListCustomer();
		
		AddContacts addContactPage = PageFactory.initElements(driver, AddContacts.class);
		addContactPage.validateAddContactPage("Add Contact");
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
		
		dashboardpage.clickListCustomerMenuButton();
	}
}
