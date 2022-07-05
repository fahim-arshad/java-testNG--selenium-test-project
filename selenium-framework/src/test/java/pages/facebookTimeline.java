package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class facebookTimeline {

	WebDriver driver = null;
	
	//Locators
	By status_text_field = By.xpath("//span[contains(text(),\"What's on your mind, Hamza?\")]");
	By status_text_box = By.xpath("//div[@role='textbox']");
	By post_status_button = By.xpath("//span[contains(text(),'Post')]");

	//constructor
	public facebookTimeline (WebDriver driver) {
		this.driver = driver;
	}

	//Set Functions
	public void click_status_text_field () {
		driver.findElement(status_text_field).click();
	}
	
	public void enter_in_status_text_box (String value) {
		driver.findElement(status_text_box).sendKeys(value);
	}
	
	public void click_post_status_button () {
		driver.findElement(post_status_button).click();
	}
	
	public void post_status(String status) {
		this.click_status_text_field();
		this.enter_in_status_text_box(status);
		this.click_post_status_button();
	}
	
}
