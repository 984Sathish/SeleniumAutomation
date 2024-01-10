package Selenium4;

import org.openqa.selenium.By;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePopupByUrl {
	
	@Test
	public void handlePopup() throws InterruptedException {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		
		// Original url --> http://the-internet.herokuapp.com/
		
		//we can add username and password with this url, to by pass popup
		driver.get("http://admin:admin@the-internet.herokuapp.com/"); 
		driver.findElement(By.linkText("Basic Auth")).click();
		
		Thread.sleep(2000);
		String text = driver.findElement(By.tagName("p")).getText();
		if(text == "Congratulations! You must have the proper credentials.") {
			System.out.println("Verify text: "+text);
		}
		
		driver.close();
	}

}
