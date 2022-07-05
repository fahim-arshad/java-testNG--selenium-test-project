package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class walletHubMyProfilePage {

	WebDriver driver = null;
	
	//constructor
		public walletHubMyProfilePage (WebDriver driver) {
			this.driver = driver;
		}

	//Locators
	By company_name = By.xpath("//a[contains(text(),'Test Insurance Company')]");
	By recommendation = By.xpath("//h2[contains(text(),'I RECOMMEND')]");
	
	public void assert_recommendation() {
		assertEquals("Test Insurance Company", driver.findElement(company_name).getText());
		assertEquals("I RECOMMEND", driver.findElement(recommendation).getText());
	}
	
	
}
