package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class wallethubProfilePage {

	WebDriver driver = null;

	//Locators
	By rating_box = By.xpath("(//review-star[@class='rvs-svg']//*[name()='svg'])");
	By review_field = By.xpath("//textarea[@placeholder='Write your review...']");
	By policy_dropdown = By.xpath("//span[contains(text(),'Select...')]");
	By submit_review_button = By.xpath("//div[contains(text(),'Submit')]");

	//constructor
	public wallethubProfilePage (WebDriver driver) {
		this.driver = driver;
	}
	
	//Help Functions
	public void sleep(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Set Functions
	public void rate_profile () {
		//Scroll element into view
		WebElement element = driver.findElement(rating_box);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		//Get Rating box
		Actions action = new Actions(driver);
		List<WebElement> all_stars = driver.findElements(rating_box);
		//Hover over each star
		for (int i = 0; i<5; i++) {
			this.sleep(500);
			action.moveToElement(all_stars.get(i)).build().perform();
			if(i == 3) {
				action.moveToElement(all_stars.get(i)).click().build().perform();
			}
		}
	}

	public void select_policy () {
		driver.findElement(policy_dropdown).click();
		driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]")).click();
	}

	public void enter_in_review_field(String review) {
		driver.findElement(review_field).sendKeys(review);
	}

	public void click_on_submit_review () {
		driver.findElement(submit_review_button).click();
	}

	//Test Functions
	public void post_review (String review) {
		this.select_policy();
		this.enter_in_review_field(review);
		this.click_on_submit_review();
	}
}
