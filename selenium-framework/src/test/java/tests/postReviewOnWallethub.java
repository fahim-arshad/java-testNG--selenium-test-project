package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.walletHubMyProfilePage;
import pages.wallethubLoginPage;
import pages.wallethubProfilePage;

public class postReviewOnWallethub {
	
private static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public static void postReview () {
		
		String username = "fahim.arshad54@gmail.com";
		String password = "P@$$w0rd";
		String review = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
		
//		//Post Review
		wallethubProfilePage OnWalletHubProfilePage = new wallethubProfilePage(driver);
		driver.get("https://wallethub.com/profile/13732055i");	
		OnWalletHubProfilePage.rate_profile();
		OnWalletHubProfilePage.post_review(review);
		
		//Login to your profile
		wallethubLoginPage WallethubLoginPageObj = new wallethubLoginPage(driver);
		driver.get("https://wallethub.com/login");
		WallethubLoginPageObj.sign_in_to_wallethub(username, password);
		
		walletHubMyProfilePage OnMyProfilePage = new walletHubMyProfilePage(driver);
		OnMyProfilePage.assert_recommendation();
	}
	
	@AfterTest
	public void tearDownTest () {
		
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully!");
	}
}
