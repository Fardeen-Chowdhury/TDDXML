package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.Dashboard;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	
	
	
	@Test
	@Parameters({"userName","password"})
	public void vllidUserShouldBeAbleToLogin(String userName , String password) {	     
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUseName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		Dashboard dashboardpage = PageFactory.initElements(driver, Dashboard.class);
		dashboardpage.validDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
		
		
	}
}
