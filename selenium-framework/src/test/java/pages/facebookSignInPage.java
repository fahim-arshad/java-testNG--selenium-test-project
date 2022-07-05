package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class facebookSignInPage {

	WebDriver driver = null;
	
	//ALL Locators
	By username_field = By.name("email");
	By password_field = By.name("pass");
	By login_button = By.id("loginbutton");

	//constructor
	public facebookSignInPage (WebDriver driver) {
		this.driver = driver;
	}

	//Set Functions
	public void enter_in_username_field (String value) {
		driver.findElement(username_field).sendKeys(value);
	}

	public void enter_in_password_field (String value) {
		driver.findElement(password_field).sendKeys(value);
	}

	public void click_signin_button () {
		driver.findElement(login_button).click();
	}

	public void sign_in_to_facebook(String username, String password) {
		this.enter_in_username_field(username);
		this.enter_in_password_field(password);
		this.click_signin_button();
	}

}
