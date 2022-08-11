package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage {
	
	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy (how = How.XPATH , using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER;
	
	@FindBy (how = How.XPATH , using = "//*[@id=\"foo_filter\"]")
	WebElement SearchBar_LIST_CUSTOMER;
	
	public void clickAddCustomerOnListCustomer() {
		ADD_CUSTOMER_ON_LIST_CUSTOMER.click();
	}
	
	public void insertSearchBarOnListCustomer() {
		String insertName = AddContacts.getNamePrint();
		SearchBar_LIST_CUSTOMER.sendKeys(insertName);
	}
}
