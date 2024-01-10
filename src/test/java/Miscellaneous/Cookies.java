package Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {
	
	@Test
	public void addCookies() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		
		//driver.manage().deleteCookie(cookiesName);  --> delete specific cookies 
		
		//driver.manage().addCookie(cookiesName);  --> add specific cookies

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	}

}
