package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.facebookSignInPage;
import pages.facebookTimeline;

public class postSatusOnFacebook {
	
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest () {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String username = "03224013059";
		String password = "hamza1122";
		
		facebookSignInPage SignInPageObj = new facebookSignInPage(driver);
		
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		
		SignInPageObj.sign_in_to_facebook(username, password);
	}

	@Test
	public static void postStatus () {
		
		String status = "Hello World";
		
		driver.get("https://web.facebook.com/");
		
		facebookTimeline TimelineObj = new facebookTimeline(driver);
		
		TimelineObj.post_status(status);
		
	}
	
//	@AfterTest
//	public void tearDownTest () {
//		
//		driver.close();
//		driver.quit();
//		System.out.println("Test Completed Successfully!");
//	}
}
