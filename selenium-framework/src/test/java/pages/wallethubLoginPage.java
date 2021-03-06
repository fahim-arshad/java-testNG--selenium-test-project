package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wallethubLoginPage {

	WebDriver driver = null;

	//ALL Locators
	By email_field = By.id("email");
	By password_field = By.id("password");
	By login_button = By.xpath("//body/main[1]/div[1]/form[1]/div[4]/button[2]");

	//constructor
	public wallethubLoginPage (WebDriver driver) {
		this.driver = driver;
	}

	//Set Functions
	public void enter_in_email_field (String value) {
		driver.findElement(email_field).sendKeys(value);
	}
	
	public void enter_in_password_field (String value) {
		driver.findElement(password_field).sendKeys(value);
	}
	
	public void click_login_button () {
		driver.findElement(login_button).click();
	}
	
	//Test Functions
	public void sign_in_to_wallethub (String email, String password) {
		this.enter_in_email_field(email);
		this.enter_in_password_field(password);
		this.click_login_button();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
